package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Besteloverzicht {
    private UUID bestelOverzichtId;
    private Klant klant;
    private ArrayList<Bestelling> alleBestellingen = new ArrayList<Bestelling>();

    public Besteloverzicht(Klant klant, ArrayList<Bestelling> alleBestellingen) {
        this.bestelOverzichtId = UUID.randomUUID();
        this.klant = klant;
        this.alleBestellingen = alleBestellingen;
    }

    public UUID getBestelOverzichtId() {
        return bestelOverzichtId;
    }

    public void setBestelOverzichtId(UUID bestelOverzichtId) {
        this.bestelOverzichtId = bestelOverzichtId;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public ArrayList<Bestelling> getAlleBestellingen() {
        return alleBestellingen;
    }

    public void setAlleBestellingen(ArrayList<Bestelling> alleBestellingen) {
        this.alleBestellingen = alleBestellingen;
    }
}
