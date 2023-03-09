package com.example.bluejackpharmacy;

import java.util.Base64;

public class User {
    int id;
    String name;
    String email;
    String password;
    String phone;

    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
        this.phone = phone;
    }

    static String hashPassword(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
