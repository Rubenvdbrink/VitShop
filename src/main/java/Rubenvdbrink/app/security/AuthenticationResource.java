package Rubenvdbrink.app.security;

import Rubenvdbrink.app.model.Klant;
import Rubenvdbrink.app.model.MyUser;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticationResource {
    final public static Key key = MacProvider.generateKey();

    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUserByPassword(@FormParam("username") String username,
                                               @FormParam("password") String password) {
        try {
            String role = MyUser.validateLogin(username, password);
            if (role == null) {
                throw new IllegalArgumentException();
            }
            String token = createToken(username, role);

            AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
            System.out.println(LocalTime.now() + " " + username + " is ingelogd!");
            return Response.ok(JWT).build();
        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", "kan niet geauthenticeerd worden")).build();
        }
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response registerMyUser(@FormParam("username") String username,
                                     @FormParam("password") String password,
                                     @FormParam("email") String email) {
        try {
            if (username == null || password == null || email == null) {
                throw new IllegalArgumentException("Voer alle velden in!");
            }
            for (MyUser user : MyUser.getAllMyUsers()) {
                if (user.getName().equals(username)) {
                    throw new IllegalArgumentException("Gebruikersnaam bestaat al!");
                }
            }

            new Klant(username,password,email);
            String role = MyUser.validateLogin(username, password);
            String token = createToken(username, role);
            AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
            System.out.println(LocalTime.now() + " " + username + " is geregistreerd!");
            return Response.ok(JWT).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(
                    new AbstractMap.SimpleEntry<>("resultaat", e.getMessage())).build();
        }
    }
}