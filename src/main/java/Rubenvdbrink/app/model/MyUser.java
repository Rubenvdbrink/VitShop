package Rubenvdbrink.app.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;

public class MyUser implements Principal, Serializable {
    private static ArrayList<MyUser> allMyUsers = new ArrayList<>();
    private String username;
    private String plainpassword;
    private String role;

    public MyUser(String username, String plainpassword) {
        this.username = username;
        this.plainpassword = plainpassword;
        this.role = "user";
        if(!allMyUsers.contains(this)) {
            allMyUsers.add(this);
        }
    }

    public static MyUser getUserByUsername(String username) {
        return allMyUsers.stream()
                .filter(e -> e.username.equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyUser myUser = (MyUser) o;

        return username != null ? username.equals(myUser.username) : myUser.username == null;
    }

    public static String validateLogin(String username, String password) {
        MyUser found = getUserByUsername(username);
        if (found!=null) {
            return password.equals(found.plainpassword) ? found.getRole(): null;
        }
        return null;
    }

    @Override
    public String getName() {
        return this.username;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlainpassword() {
        return plainpassword;
    }
    public void setPlainpassword(String plainpassword) {
        this.plainpassword = plainpassword;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public static void setAllMyUsers(ArrayList<MyUser> allMyUsers) { MyUser.allMyUsers = allMyUsers; }
    public static ArrayList<MyUser> getAllMyUsers() { return allMyUsers; }
}
