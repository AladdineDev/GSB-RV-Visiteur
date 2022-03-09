package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "GSB MAIN ACTIVITY";

    TextView tvErreur;
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
        Visiteur dandre = new Visiteur("dandre", "azerty", "Andre", "David");
        String dandreNom = dandre.getPrenom() + " " + dandre.getNom();
        Session.ouvrir(dandre);
        if(Session.estOuverte()) {
            bSeConnecter = (Button) findViewById(R.id.bSeConnecter);
            bSeDeconnecter = (Button) findViewById(R.id.bAnnuler);
            Toast.makeText(this, dandreNom, Toast.LENGTH_LONG).show();
            bSeConnecter.setEnabled(false);
            bSeDeconnecter.setEnabled(false);
        } else {
            tvErreur = findViewById(R.id.tvErreur);
            tvErreur.setText("Échec à la connexion. Recommencez...");
            tvErreur.setTextColor(Color.RED);
            annuler(view);
        }
    }

    public void annuler(View view) {
        etMatricule = findViewById(R.id.etMatricule);
        etMdp = findViewById(R.id.etMdp);
        etMatricule.setText("");
        etMdp.setText("");
    }

}