package Rubenvdbrink.app.webservices;

import Rubenvdbrink.app.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.UUID;

@Path("/productpagina")
public class ProductPaginaResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productPagina(@PathParam("id") String id) {
        try {
            if (id == null) {
                throw new Exception();
            }
            var product = Product.getProductByUUID(UUID.fromString(id));
            return Response.ok(product).build();

        } catch(Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "productpagina is niet gevonden!")).build();
        }
    }
}
