package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Bestelling {
    private UUID bestelNummer;
    private double totaalPrijs;
    private ArrayList<Product> alleProducten = new ArrayList<Product>();

    public Bestelling(double totaalPrijs, ArrayList<Product> alleProducten) {
        this.bestelNummer = UUID.randomUUID();
        this.totaalPrijs = totaalPrijs;
        this.alleProducten = alleProducten;
    }

    public UUID getBestelNummer() {
        return bestelNummer;
    }

    public void setBestelNummer(UUID bestelNummer) {
        this.bestelNummer = bestelNummer;
    }

    public double getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    public ArrayList<Product> getAlleProducten() {
        return alleProducten;
    }

    public void setAlleProducten(ArrayList<Product> alleProducten) {
        this.alleProducten = alleProducten;
    }
}
