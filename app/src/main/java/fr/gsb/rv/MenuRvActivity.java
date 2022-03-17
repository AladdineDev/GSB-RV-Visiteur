package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import fr.gsb.rv.R;

public class MenuRvActivity extends AppCompatActivity {

    Button bConsulterRv;
    Button bSaisirRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);

        bConsulterRv = findViewById(R.id.bConsulterRv);
        bSaisirRv = findViewById(R.id.bSaisirRv);

        bConsulterRv.setOnClickListener(view -> {
            Intent intent = new Intent(MenuRvActivity.this, SaisieRvActivity.class);
            startActivity(intent);
        });
        bSaisirRv.setOnClickListener(view -> {
            Intent intent = new Intent(MenuRvActivity.this, RechercheRvActivity.class);
            startActivity(intent);
        });

    }

}