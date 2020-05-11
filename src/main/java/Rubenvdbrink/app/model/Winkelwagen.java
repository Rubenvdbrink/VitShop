package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Winkelwagen {
    private UUID wagenId;
    private double totaalPrijs;
    private ArrayList<Product> alleProducten = new ArrayList<Product>();
    private Klant klant;

    public Winkelwagen(double totaalPrijs, ArrayList<Product> alleProducten, Klant klant) {
        this.wagenId = UUID.randomUUID();
        this.totaalPrijs = totaalPrijs;
        this.alleProducten = alleProducten;
        this.klant = klant;
    }

    public UUID getWagenId() {
        return wagenId;
    }

    public void setWagenId(UUID wagenId) {
        this.wagenId = wagenId;
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

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}
