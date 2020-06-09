package Rubenvdbrink.app.model;

import java.util.UUID;

public class Klant extends MyUser{
    private UUID klantId;
    private String emailAdres;
    private Winkelwagen winkelwagen;
    private Besteloverzicht besteloverzicht;

    public Klant(String gebruikersnaam, String wachtwoord, String emailAdres) {
        super(gebruikersnaam, wachtwoord);
        this.emailAdres = emailAdres;
        this.klantId = UUID.randomUUID();
    }

    public UUID getKlantId() {
        return klantId;
    }

    public void setKlantId(UUID klantId) {
        this.klantId = klantId;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public Winkelwagen getWinkelwagen() {
        return winkelwagen;
    }

    public void setWinkelwagen(Winkelwagen winkelwagen) {
        this.winkelwagen = winkelwagen;
    }

    public Besteloverzicht getBesteloverzicht() {
        return besteloverzicht;
    }

    public void setBesteloverzicht(Besteloverzicht besteloverzicht) {
        this.besteloverzicht = besteloverzicht;
    }

    public String toString() {
        return super.toString();
    }
}
