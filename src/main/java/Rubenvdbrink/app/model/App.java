package Rubenvdbrink.app.model;

import java.io.Serializable;
import java.util.ArrayList;

public class App implements Serializable {
    public ArrayList<Product> alleProducten;

    private static App my_app = new App();

    public static App getApp() { return App.my_app; }
    public static void setApp(App app) { App.my_app = app; }

    public void setAlleProducten(ArrayList<Product> alleProducten) { this.alleProducten = alleProducten; }

    public void setData() { //Hier wordt alle data van de gehele app opnieuw geset in alle klassen (wordt gebruikt in contextinitialized)
        Product.setAlleProducten(this.alleProducten);
    }
}