package Rubenvdbrink.app.webservices;

import Rubenvdbrink.app.model.Klant;
import Rubenvdbrink.app.model.Product;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;
import java.util.UUID;

@Path("/winkelwagen")
public class WinkelwagenResource {

    @POST
    @Path("/producttoevoegen/{id}")
    @RolesAllowed("klant")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productToevoegenAanWinkelwagen(@Context SecurityContext context,
                                                   @PathParam("id") String productId) {
        System.out.println(productId);
        try {
            if (productId == null) {
                throw new IllegalArgumentException();
            }

            var klant = (Klant) context.getUserPrincipal();
            var product = Product.getProductByUUID(UUID.fromString(productId));

            klant.getWinkelwagen().voegProductToe(product);

            System.out.println(klant.getName() + " heeft een product aan zijn/haar winkelmandje toegevoegd!");

            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product is toegevoegd!")).build();

        } catch(Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "product is niet toegevoegd!")).build();
        }
    }
}
