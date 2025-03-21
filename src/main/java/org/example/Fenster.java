package org.example;

public class Fenster {
    private boolean offen;
    private Raum raum;

    public Fenster(Raum raum) {
        this.raum = raum;
    }

    public void oeffneFenster() {
        offen = true;
    }

    public void schliesseFenster() {
        offen = false;
    }

    public boolean isOffen() {
        return offen;
    }

    public Raum getRaum() {
        return raum;
    }
}