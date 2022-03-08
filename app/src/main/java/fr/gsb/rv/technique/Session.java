package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public final class Session {

    private static Session session = null;

    private Visiteur visiteur;

    private Session(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public static void ouvrir(Visiteur visiteur) {
        session = new Session(visiteur);
    }

    public static void fermer() {
        Session.session = null;
    }

    public static Session getSession() {
        if (session == null) {
            session = new Session(session.getLeVisiteur());
        }
        return session;
    }

    public Visiteur getLeVisiteur() {
        return this.visiteur;
    }

    public static boolean estOuverte() {
        if (session == null) {
            return false;
        }
        return true;
    }

}