package Rubenvdbrink.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("vitshop")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("Rubenvdbrink.app.webservices, Rubenvdbrink.app.security");
        register(RolesAllowedDynamicFeature.class);
    }
//    "Rubenvdbrink.app.webservices"
}
