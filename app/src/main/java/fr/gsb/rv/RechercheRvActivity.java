package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.gsb.rv.technique.Annee;
import fr.gsb.rv.technique.Mois;

public class RechercheRvActivity extends AppCompatActivity {

    Spinner spinnerMois;
    Spinner spinnerAnnee;
    Button bAfficherRapports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);

        spinnerMois = findViewById(R.id.spinnerMois);
        spinnerAnnee = findViewById(R.id.spinnerAnnee);
        bAfficherRapports = findViewById(R.id.bAfficherRapports);

        ArrayAdapter<Mois> aaMois = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Mois.values());
        aaMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMois.setAdapter(aaMois);

        ArrayAdapter<Integer> aaAnnee = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Annee.getYears(5));
        aaMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnnee.setAdapter(aaAnnee);

        bAfficherRapports.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("mois", String.valueOf(Mois.valueOf(spinnerMois.getSelectedItem().toString()).ordinal() + 1));
            bundle.putString("annee", spinnerAnnee.getSelectedItem().toString());
            Intent intent = new Intent(RechercheRvActivity.this, ListeRvActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}