package Rubenvdbrink.app.webservices;

import Rubenvdbrink.app.model.Product;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.UUID;

@Path("/product")
public class ProductResource {

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        try {
            return Response.ok(Product.getAlleProducten()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "Productoverzicht niet gevonden!")).build();
        }
    }

    @POST
    @RolesAllowed("admin")
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(@FormParam("titel") String titel,
                                  @FormParam("merk") String merk,
                                  @FormParam("beschrijving") String beschrijving,
                                  @FormParam("prijs") double prijs,
                                  @FormParam("afbeeldingPad") String afbeeldingPad){
        if (titel == null || merk == null || beschrijving == null || prijs == 0 || afbeeldingPad == null) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "Niet alle velden zijn correct ingevuld!")).build();
        }
        Product newProduct = new Product(titel, merk, beschrijving, prijs, afbeeldingPad);

        if(Product.addProduct(newProduct)) {
            System.out.println("Product: " + titel + " is aangemaakt!");
            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product: " + titel + " is aangemaakt!")).build();
        }
        return Response.status(Response.Status.CONFLICT).entity(
                new AbstractMap.SimpleEntry<>("resultaat", "Product: " + titel + " bestaat al!")).build();
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@FormParam("UUID") UUID uuid) {
        if (uuid == null) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "velden niet correct ingevuld!")).build();
        }
        if (Product.deleteProduct(uuid)) {
            System.out.println("Product met id: " + uuid + " Is verwijderd!");
            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product is verwijderd!")).build();
        }
        return Response.status(Response.Status.CONFLICT).entity(
                new AbstractMap.SimpleEntry<>("resultaat", "Het product met UUID " + uuid + " bestaat niet!")).build();
    }
}
