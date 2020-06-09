package Rubenvdbrink.app.webservices;

import Rubenvdbrink.app.model.Klant;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;

@Path("/klant")
public class KlantResource {

    @GET
    @Path("/winkelwagen")
    @RolesAllowed("klant")
    @Produces(MediaType.APPLICATION_JSON)
    public Response toonWinkelwagen(@Context SecurityContext context) {

        try {
            var klant = (Klant) context.getUserPrincipal();
            return Response.ok(klant.getWinkelwagen().getAlleProducten()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "Winkelmandje niet gevonden!")).build();
        }
    }
}
