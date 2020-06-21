package Rubenvdbrink.app.model;

import java.util.UUID;

public class Administrator extends Klant {
    private UUID adminId;

    public Administrator(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord);
        this.adminId = UUID.randomUUID();
        this.setAdmin();
    }

    public UUID getAdminId() {
        return adminId;
    }

    public void setAdminId(UUID adminId) {
        this.adminId = adminId;
    }

    public String toString() {
        return super.toString();
    }
}
