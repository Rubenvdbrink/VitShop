package Rubenvdbrink.app.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Product implements Serializable {
    private UUID productId;
    private String titel;
    private String merk;
    private String beschrijving;
    private String afbeeldingPad;
    private double prijs;
    private static ArrayList<Product> alleProducten = new ArrayList<Product>();

    public Product(String titel, String merk, String beschrijving, double prijs, String afbeeldingPad) {
        this.productId = UUID.randomUUID();
        this.titel = titel;
        this.merk = merk;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.afbeeldingPad = afbeeldingPad;
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

    public static ArrayList<Product> getAlleProducten() {
        return alleProducten;
    }

    public static void setAlleProducten(ArrayList<Product> alleProducten) {
        Product.alleProducten = alleProducten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.prijs, prijs) != 0) return false;
        if (titel != null ? !titel.equals(product.titel) : product.titel != null) return false;
        return merk != null ? merk.equals(product.merk) : product.merk == null;
    }

    public static boolean addProduct(Product newProduct) {
        for (Product product : alleProducten) {
            if (product.equals(newProduct)) {
                return false;
            }
        }
        alleProducten.add(newProduct);
        return true;
    }

    public static boolean deleteProduct(UUID uuid) {
        for (Product product : alleProducten) {
            if (product.getProductId().equals(uuid)) {
                alleProducten.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", titel='" + titel + '\'' +
                ", merk='" + merk + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", afbeeldingPad='" + afbeeldingPad + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
