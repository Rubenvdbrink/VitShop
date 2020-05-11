package Rubenvdbrink.app.model;

import java.util.UUID;

public class Product {
    private UUID productId;
    private String titel;
    private String merk;
    private String beschrijving;
    private double prijs;

    public Product(String titel, String merk, String beschrijving, double prijs) {
        this.productId = UUID.randomUUID();
        this.titel = titel;
        this.merk = merk;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
