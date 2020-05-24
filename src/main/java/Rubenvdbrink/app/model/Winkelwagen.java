package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Winkelwagen {
    private UUID wagenId;
    private double totaalPrijs;
    private ArrayList<Product> alleProducten;

    public Winkelwagen() {
        this.wagenId = UUID.randomUUID();
        this.totaalPrijs = 0.0;
        this.alleProducten = new ArrayList<>();
    }

    public void voegProductToe(Product product) {
        this.alleProducten.add(product);
        this.totaalPrijs += product.getPrijs();
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

    public void setTotaalPrijs(ArrayList<Product> alleProducten) {
        this.totaalPrijs = Utils.berekenTotaalPrijs(alleProducten);
    }

    public ArrayList<Product> getAlleProducten() {
        return alleProducten;
    }

    public void setAlleProducten(ArrayList<Product> alleProducten) {
        this.alleProducten = alleProducten;
    }

    @Override
    public String toString() {
        return "Winkelwagen{" +
                "wagenId=" + wagenId +
                ", totaalPrijs=" + totaalPrijs +
                ", alleProducten=" + alleProducten +
                '}';
    }
}
