package Rubenvdbrink.app.model;

import java.util.ArrayList;

public class Utils {

    public static double berekenTotaalPrijs(ArrayList<Product> alleProducten) {
        double totaal = 0.0;
        for (Product product : alleProducten) {
            totaal += product.getPrijs();
        }
        return totaal;
    }
}
