package Rubenvdbrink.app.model;

import java.util.UUID;

public class Product {
    public UUID productId;
    public String titel;
    public String merk;
    public String beschrijving;
    public double prijs;

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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", titel='" + titel + '\'' +
                ", merk='" + merk + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
