package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RechercheRvActivity extends AppCompatActivity {

    Spinner spinnerMois;
    Spinner spinnerAnnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);

        spinnerMois = findViewById(R.id.spinnerMois);
        spinnerAnnee = findViewById(R.id.spinnerAnnee);

        ArrayAdapter<Integer> aaMois = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        aaMois.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMois.setAdapter(aaMois);
        AdapterView.OnItemSelectedListener variable = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<Integer> annees = new ArrayList<>();
                LocalDate aujourdhui = LocalDate.now();
                for (int y = 0; y <= 5; y++) {
                    annees.add(aujourdhui.minusYears(y).getYear());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }
}