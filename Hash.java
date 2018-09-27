package com.joeysin.paper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Hash {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String aa = encoder.encode("1");
        System.out.println(aa);
        System.out.println(encoder.matches("1", aa));
    }
}
