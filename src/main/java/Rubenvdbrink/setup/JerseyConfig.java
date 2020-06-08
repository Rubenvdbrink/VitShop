package Rubenvdbrink.setup;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("vitshop")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("Rubenvdbrink.app.webservices, Rubenvdbrink.app.security");
    }
//    "Rubenvdbrink.app.webservices"
}
