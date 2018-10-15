package com.joeysin.paper;

import lombok.Data;

@Data
public class Equals {
    private Long id;

    public static void main(String[] args) {
        Equals e1 = new Equals();
        Equals e2 = e1;
        e1.setId(1L);
        e2.setId(1L);
        System.out.println(e1 == e2);
    }
}
