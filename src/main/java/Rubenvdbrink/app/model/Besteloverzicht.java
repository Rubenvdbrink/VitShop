package Rubenvdbrink.app.model;

import java.util.ArrayList;
import java.util.UUID;

public class Besteloverzicht {
    private UUID bestelOverzichtId;
    private ArrayList<Bestelling> alleBestellingen = new ArrayList<Bestelling>();

    public Besteloverzicht(Klant klant) {
        this.bestelOverzichtId = UUID.randomUUID();
        this.alleBestellingen = new ArrayList<>();
    }

    public UUID getBestelOverzichtId() {
        return bestelOverzichtId;
    }

    public void setBestelOverzichtId(UUID bestelOverzichtId) {
        this.bestelOverzichtId = bestelOverzichtId;
    }

    public ArrayList<Bestelling> getAlleBestellingen() {
        return alleBestellingen;
    }

    public void setAlleBestellingen(ArrayList<Bestelling> alleBestellingen) {
        this.alleBestellingen = alleBestellingen;
    }

    @Override
    public String toString() {
        return "Besteloverzicht{" +
                "bestelOverzichtId=" + bestelOverzichtId +
                ", alleBestellingen=" + alleBestellingen +
                '}';
    }
}
