package org.example;

import java.lang.classfile.constantpool.IntegerEntry;
import java.util.ArrayList;
import java.util.List;

public class Raum extends Thermometer {
    private int raumId;

    private int zieltemperatur;

    private List<Fenster> fensterliste = new ArrayList<>();

    private List<Heizung> heizungliste = new ArrayList<>();

    private Thermometer thermometer;

    public Raum(int raumId, int zieltemperatur) {
        this.raumId = raumId;
        this.zieltemperatur = zieltemperatur;
    }

    public boolean hatOffeneFenster() {
        for (Fenster fenster : fensterliste) {
            if (fenster.isOffen()) {
                return true;
            }
        }
        return false;
    }

    public void regeleTemperatur() {
        if (hatOffeneFenster()) {
            heizungliste.forEach(Heizung::schalteAus);
        } else {
            if (thermometer.getTemperatur() < zieltemperatur) {
                heizungliste.forEach(Heizung::schalteEin);
            } else {
                heizungliste.forEach(Heizung::schalteAus);
            }
        }
    }

    public List<Heizung> getHeizungliste() {
        return heizungliste;
    }

    public int getZieltemperatur() {
        return zieltemperatur;
    }

    public void setZieltemperatur(int zieltemperatur) {
        this.zieltemperatur = zieltemperatur;
    }

    @Override
    public String toString() {
        return "RaumId: " + raumId + "Zieltemperatur: " + zieltemperatur + "°C" + "Fenster" + fensterliste.size()
                + "Heizungen: " + heizungliste.size();
    }
}
