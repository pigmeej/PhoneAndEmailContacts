package com.blazi;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails =  ContactData.getData("emails");
        List<Contact> phones = ContactData.getData("phones");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        printData("Phone List", phoneContacts);
        printData("Email List", emailContacts);

        // Union
        Set<Contact> unionSet = new HashSet<>(emailContacts);
        unionSet.addAll(emailContacts);
        printData("Union", unionSet);

        // Intersect
        Set<Contact> intersectSet = new HashSet<>(emailContacts);
        intersectSet.retainAll(phoneContacts);
        printData("Intersect", intersectSet);
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

