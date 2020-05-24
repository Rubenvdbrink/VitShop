package Rubenvdbrink.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinkelwagenTest {

    @Test
    void testTotaalPrijs() {
        Product p1 = new Product("Titel", "Merk", "Beschrijving", 20, "pad");
        Product p2 = new Product("Titel2", "Merk2", "Beschrijving2", 25, "pad");
        Product p3 = new Product("Titel3", "Merk3", "Beschrijving3", 25, "pad");

        Winkelwagen w1 = new Winkelwagen();
        w1.voegProductToe(p1);
        w1.voegProductToe(p2);
        w1.voegProductToe(p3);

        assertEquals(70.0, w1.getTotaalPrijs());
    }

}