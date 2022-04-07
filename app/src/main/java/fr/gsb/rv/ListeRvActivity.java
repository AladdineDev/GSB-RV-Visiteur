package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.gsb.rv.entites.Praticien;
import fr.gsb.rv.entites.RapportVisite;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class ListeRvActivity extends AppCompatActivity {

    ListView lvRapports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        lvRapports = findViewById(R.id.lvRapports);

        Bundle bundle = this.getIntent().getExtras();
        List<RapportVisite> rapports = new ArrayList<>();

        try {
            String matricule = Session.getSession().getLeVisiteur().getMatricule();
            String mois = URLEncoder.encode(bundle.getString("mois"), "UTF-8");
            String annee = URLEncoder.encode(bundle.getString("annee"), "UTF-8");
            Log.i("APP-RV", "mois : " + mois + "annee : " + annee);
            String url = String.format("https://10.0.2.2:9967/rapports/%s/%s/%s", matricule, mois, annee);

            Response.Listener<JSONArray> ecouteurReponse = response -> {
                try {
                    Log.i("APP-RV", "test");Log.i("APP-RV", response.toString());

                    for (int i = 0; i < response.length(); i++) {
                        Praticien praticien = new Praticien();
                        praticien.setNom(response.getJSONObject(i).getString("pra_nom"));
                        praticien.setPrenom(response.getJSONObject(i).getString("pra_prenom"));
                        praticien.setCodePostal(response.getJSONObject(i).getString("pra_cp"));
                        praticien.setVille(response.getJSONObject(i).getString("pra_ville"));
                        Log.i("APP-RV", "Pranom : " + response.getJSONObject(i).getString("pra_nom"));

                        RapportVisite rapportVisite = new RapportVisite();
                        rapportVisite.setNumero(response.getJSONObject(i).getInt("rap_num"));
                        rapportVisite.setDateVisite(LocalDate.parse(response.getJSONObject(i).getString("rap_date_redaction")));
                        rapportVisite.setDateVisite(LocalDate.parse(response.getJSONObject(i).getString("rap_date_visite")));
                        rapportVisite.setBilan(response.getJSONObject(i).getString("rap_bilan"));
                        rapportVisite.setCoefConfiance(response.getJSONObject(i).getInt("rap_coefficient"));
                        rapportVisite.setMotif(response.getJSONObject(i).getString("rap_motif"));
                        //rapportVisite.setLu(response.getJSONObject(i).getBoolean("rap_lu")); // convert int to boolean
                        rapportVisite.setPraticien(praticien);

                        rapports.add(rapportVisite);
                    }
                    ArrayAdapter<RapportVisite> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rapports);
                    lvRapports.setAdapter(adapter);
                    lvRapports.setOnItemClickListener((adapterView, view, position, l) -> {
                        String rapportSelectionne = rapports.get(position).getPraticien().getNom();
                    });
                    Log.i("APP-RV", "Rapports : " + rapports);
                } catch (JSONException e) {
                    Log.e("APP-RV", "ERREUR HTTP : " + e);
                }
            };
            Response.ErrorListener ecouteurErreur = error -> {
                Log.e("APP-RV", "Erreur JSON : " + error.getMessage());
            };
            JsonArrayRequest requete = new JsonArrayRequest(Request.Method.GET, url, null, ecouteurReponse, ecouteurErreur);

            RequestQueue fileRequetes = Volley.newRequestQueue(this);
            fileRequetes.add(requete);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}