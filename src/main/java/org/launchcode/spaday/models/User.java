package org.launchcode.spaday.models;

import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private static int nextId =1;
    private final Date dateJoined;

    public User(String username, String email,
                String password){
        this.username=username;
        this.email=email;
        this.password=password;
        this.dateJoined= new Date();
        this.id=nextId;
        nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
