package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "GSB MAIN ACTIVITY";

    EditText etMatricule;
    EditText etMdp;
    Button bSeConnecter;
    Button bSeDeconnecter;
    Button bAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seConnecter(View view) {

        try {
            etMatricule = findViewById(R.id.etMatricule);
            etMdp = findViewById(R.id.etMdp);
            String matricule = URLEncoder.encode(etMatricule.getText().toString(),"UTF-8");
            String mdp = URLEncoder.encode(etMdp.getText().toString(),"UTF-8");
            String url = String.format("https://10.0.2.2:9967/visiteurs/%s/%s", matricule, mdp);
            Visiteur visiteur = new Visiteur();

            Response.Listener<JSONObject> ecouteurReponse = response -> {
                try {
                    visiteur.setMatricule(response.getString("vis_matricule"));
                    visiteur.setNom(response.getString("vis_nom"));
                    visiteur.setPrenom(response.getString("vis_prenom"));
                    Log.i("APP-RV", visiteur.getNom() + " " + visiteur.getPrenom());

                    Session.ouvrir(visiteur);
                    if(Session.estOuverte()) {
                        bSeConnecter = findViewById(R.id.bSeConnecter);
                        bSeDeconnecter = findViewById(R.id.bAnnuler);
                        Toast.makeText(this, visiteur.getPrenom() + " " + visiteur.getNom(), Toast.LENGTH_LONG).show();
                        bSeConnecter.setEnabled(false);
                        bSeDeconnecter.setEnabled(false);
                    } else {
                        Toast.makeText(this, "Échec à la connexion. Recommencez...", Toast.LENGTH_LONG).show();
                        annuler(view);
                    }

                } catch (JSONException e) {
                    Log.e("APP-RV", "Erreur JSON : " + e.getMessage());
                }
            };

            Response.ErrorListener ecouteurErreur = error -> {
                Log.e("APP-RV", "Erreur JSON : " + error.getMessage());
                Toast.makeText(this, "Échec à la connexion. Recommencez...", Toast.LENGTH_LONG).show();
                annuler(view);
            };

            JsonObjectRequest requete = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    ecouteurReponse,
                    ecouteurErreur
            );

            RequestQueue fileRequetes = Volley.newRequestQueue(this);
            fileRequetes.add(requete);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void annuler(View view) {
        etMatricule = findViewById(R.id.etMatricule);
        etMdp = findViewById(R.id.etMdp);
        etMatricule.setText("");
        etMdp.setText("");
    }

}