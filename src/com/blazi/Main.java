package com.blazi;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails =  ContactData.getData("emails");
        List<Contact> phones = ContactData.getData("phones");
        printData("Phone List", phones);
        printData("Email List", emails);

    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("----------------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------------");
        contacts.forEach(s -> {
            System.out.println(s);
            System.out.println();
        });
    }
}

