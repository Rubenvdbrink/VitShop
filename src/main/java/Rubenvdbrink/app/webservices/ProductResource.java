package Rubenvdbrink.app.webservices;

import Rubenvdbrink.app.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.UUID;

@Path("/product")
public class ProductResource {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(@FormParam("titel") String titel,
                                  @FormParam("merk") String merk,
                                  @FormParam("beschrijving") String beschrijving,
                                  @FormParam("prijs") double prijs,
                                  @FormParam("afbeeldingPad") String afbeeldingPad){
        System.out.println(beschrijving);
        if (titel == null || merk == null || beschrijving == null || prijs == 0 || afbeeldingPad == null) {
            System.out.println("Product niet aangemaakt, niet alle velden zijn correct ingevuld!");
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "Niet alle velden zijn correct ingevuld!")).build();
        }
        Product newProduct = new Product(titel, merk, beschrijving, prijs, afbeeldingPad);

        if(Product.addProduct(newProduct)) {
            System.out.println("Product: " + titel + " is aangemaakt!");
            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product: " + titel + " is aangemaakt!")).build();
        }
        System.out.println("Product: " + titel + " bestaat al!");
        return Response.status(Response.Status.CONFLICT).entity(
                new AbstractMap.SimpleEntry<>("resultaat", "Product: " + titel + " bestaat al!")).build();
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        return Response.ok(Product.getAlleProducten()).build();
    }

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@FormParam("UUID") UUID uuid) {
        if (uuid == null) {
            System.out.println("product niet verwijderd!");
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "velden niet correct ingevuld!")).build();
        }
        if (Product.deleteProduct(uuid)) {
            return Response.ok(new AbstractMap.SimpleEntry<>("resultaat", "Product is verwijderd!")).build();
        }
        return Response.status(Response.Status.CONFLICT).entity(
                new AbstractMap.SimpleEntry<>("resultaat", "Het product met UUID " + uuid + " bestaat niet!")).build();
    }
}
