package fr.gsb.rv.technique;

import android.util.Log;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Annee {

    public static List<Integer> getYears(int numberOfYears) {
        List<Integer> years = new ArrayList<>();
        LocalDate currentDate = LocalDate.parse(LocalDate.now().toString());
        for(int i = 0; i < numberOfYears; i++) {
            years.add(currentDate.minusYears(i).getYear());
        }
        return years;
    }
}
