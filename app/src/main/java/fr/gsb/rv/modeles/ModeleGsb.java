package fr.gsb.rv.modeles;

import java.util.List;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

public class ModeleGsb {

    private static ModeleGsb modele = null;

    private List<Visiteur> lesVisiteurs;

    private ModeleGsb() {}

    public static ModeleGsb getInstance() {
        if (modele == null) {
            modele = new ModeleGsb();
        }
        return modele;
    }

    private void peupler() {

    }

    public Visiteur seConnecter(String matricule, String mdp) {
        return new Visiteur();
    }

}
