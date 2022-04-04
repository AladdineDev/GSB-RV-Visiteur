package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListeRvActivity extends AppCompatActivity {

    TextView tvMois;
    TextView tvAnnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        tvMois = findViewById(R.id.tvMois);
        tvAnnee = findViewById(R.id.tvAnnee);

        Bundle bundle = this.getIntent().getExtras();
        String mois = bundle.getString("mois");
        String annee = bundle.getString("annee");

        tvMois.setText(mois);
        tvAnnee.setText(annee);
    }
}