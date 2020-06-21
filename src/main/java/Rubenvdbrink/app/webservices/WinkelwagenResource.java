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
    @RolesAllowed({"klant","admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response productToevoegenAanWinkelwagen(@Context SecurityContext context,
                                                   @PathParam("id") String productId) {
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

    @POST
    @Path("/clear")
    @RolesAllowed({"klant","admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearWinkelWagen(@Context SecurityContext context) {
        try {
            var klant = (Klant) context.getUserPrincipal();
            if (klant.getWinkelwagen().getAlleProducten().isEmpty()) {throw new Exception();}

            if (klant.clearWinkelwagen()) {
                System.out.println(klant.getName() + " heeft zijn winkelwagen geleegd door een bestelling te plaatsen!");
                return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Winkelwagen is geleegd!")).build();
            } else {throw new Exception();}
        } catch(Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "winkelwagen niet geleegd!")).build();
        }
    }

    @DELETE
    @Path("/removeproduct/{id}")
    @RolesAllowed({"klant","admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProduct(@Context SecurityContext context,
                                  @PathParam("id") String id) {
        try {
            var klant = (Klant) context.getUserPrincipal();
            var winkelwagen = klant.getWinkelwagen();
            var product = winkelwagen.getProductByUUID(UUID.fromString(id));
            winkelwagen.getAlleProducten().remove(product);
            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product verwijderd uit winkelwagen!")).build();
        } catch(Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "Kan product niet verwijderen uit winkelmandje!")).build();
        }
    }
}
