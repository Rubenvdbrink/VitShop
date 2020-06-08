package Rubenvdbrink.app.security;

import Rubenvdbrink.app.model.MyUser;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private MyUser user;
    private String scheme;

    public MySecurityContext(MyUser user, String scheme){
        this.user = user;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (user.getRole()!= null) {
            return role.equals(user.getRole());
        }
        return false;
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
