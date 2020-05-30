package Rubenvdbrink.app.model;

public class Gebruiker {
    protected String gebruikersnaam;
    protected String wachtwoord;

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "gebruikersnaam='" + gebruikersnaam + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                '}';
    }
}
