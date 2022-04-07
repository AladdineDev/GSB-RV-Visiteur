package fr.gsb.rv.entites;

import java.time.LocalDate;

public class Praticien {

    private int numero;
    private String nom;
    private String prenom;
    private String ville;
    private double coefNotoriete;
    private LocalDate dateDerniereVisite;
    private int dernierCoefConfiance;
    private String adresse;
    private String codePostal;

    public Praticien(){};

    public Praticien(int numero, String nom, String prenom, String ville, double coefNotoriete,
            LocalDate dateDerniereVisite, int dernierCoefConfiance, String adresse, String codePostal) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.coefNotoriete = coefNotoriete;
        this.dateDerniereVisite = dateDerniereVisite;
        this.dernierCoefConfiance = dernierCoefConfiance;
        this.adresse = adresse;
        this.codePostal = codePostal;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getCoefNotoriete() {
        return this.coefNotoriete;
    }

    public void setCoefNotoriete(double coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public LocalDate getDateDerniereVisite() {
        return this.dateDerniereVisite;
    }

    public void setDateDerniereVisite(LocalDate dateDerniereVisite) {
        this.dateDerniereVisite = dateDerniereVisite;
    }

    public int getDernierCoefConfiance() {
        return this.dernierCoefConfiance;
    }

    public void setDernierCoefConfiance(int dernierCoefConfiance) {
        this.dernierCoefConfiance = dernierCoefConfiance;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "{" +
                " numero='" + getNumero() + "'" +
                ", nom='" + getNom() + "'" +
                ", prenom='" + getPrenom() + "'" +
                ", ville='" + getVille() + "'" +
                ", coefNotoriete='" + getCoefNotoriete() + "'" +
                ", dateDerniereVisite='" + getDateDerniereVisite() + "'" +
                ", dernierCoefConfiance='" + getDernierCoefConfiance() + "'" +
                ", adresse='" + getAdresse() + "'" +
                ", codePostal='" + getCodePostal() + "'" +
                "}";
    }

}
