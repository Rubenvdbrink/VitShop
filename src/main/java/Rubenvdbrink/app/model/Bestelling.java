package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Bestelling {
    private UUID bestelNummer;
    private double totaalPrijs;
    private ArrayList<Product> alleProducten = new ArrayList<Product>();
    private Besteloverzicht besteloverzicht;

    public Bestelling() {
        this.bestelNummer = UUID.randomUUID();
        this.totaalPrijs = 0.0;
        this.alleProducten = new ArrayList<>();
    }

    public void voegProductToe(Product product) {
        alleProducten.add(product);
        this.totaalPrijs += product.getPrijs();
    }

    public Besteloverzicht getBesteloverzicht() {
        return besteloverzicht;
    }

    public void setBesteloverzicht(Besteloverzicht besteloverzicht) {
        this.besteloverzicht = besteloverzicht;
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

    public void setTotaalPrijs(ArrayList<Product> alleProducten) {
        this.totaalPrijs = Utils.berekenTotaalPrijs(alleProducten);
    }

    public ArrayList<Product> getAlleProducten() {
        return alleProducten;
    }

    @Override
    public String toString() {
        return "Bestelling{" +
                "bestelNummer=" + bestelNummer +
                ", totaalPrijs=" + totaalPrijs +
                ", alleProducten=" + alleProducten +
                '}';
    }
}
