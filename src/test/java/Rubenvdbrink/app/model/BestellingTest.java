package Rubenvdbrink.app.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestellingTest {

    @Test
    void testVoegProductToe() {
        Product p1 = new Product("Titel","merk", "beschrijving",30.50);
        Product p2 = new Product("Tite2l","merk2", "beschrijving2",50);
        Bestelling b1 = new Bestelling();

        b1.voegProductToe(p1);
        b1.voegProductToe(p2);

        ArrayList<Product> testList = new ArrayList<>();
        testList.add(p1);
        testList.add(p2);

        assertEquals(testList, b1.getAlleProducten());
    }

    @Test
    void berekenTotaalPrijs() {
        Product p1 = new Product("Titel","merk", "beschrijving",30.50);
        Product p2 = new Product("Tite2l","merk2", "beschrijving2",50);
        Bestelling b1 = new Bestelling();

        b1.voegProductToe(p1);
        b1.voegProductToe(p2);

        assertEquals(80.50, b1.getTotaalPrijs());
    }
}
