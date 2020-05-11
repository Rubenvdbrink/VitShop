package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Productoverzicht {
    private UUID productOverzichtId;
    private ArrayList<Product> alleproducten = new ArrayList<Product>();

    public Productoverzicht() {
        this.productOverzichtId = UUID.randomUUID();
    }

    public UUID getProductOverzichtId() {
        return productOverzichtId;
    }

    public void setProductOverzichtId(UUID productOverzichtId) {
        this.productOverzichtId = productOverzichtId;
    }

    public ArrayList<Product> getAlleproducten() {
        return alleproducten;
    }

    public void setAlleproducten(ArrayList<Product> alleproducten) {
        this.alleproducten = alleproducten;
    }

    @Override
    public String toString() {
        return "Productoverzicht{" +
                "productOverzichtId=" + productOverzichtId +
                ", alleproducten=" + alleproducten +
                '}';
    }
}
