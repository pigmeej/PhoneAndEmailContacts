package com.blazi;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    private final String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();


    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            this.emails.add(email);
        }

        String formattedPhone = formatPhone(phone);
        if (formattedPhone != null) {
            phones.add(formattedPhone);
        }
    }

    public Contact mergeContactData(Contact contact) {
        Contact newContact = new Contact(name);

        newContact.phones.addAll(contact.phones);
        newContact.phones.addAll(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.emails.addAll(this.emails);

        return newContact;
    }

    public String getName() {
        return name;
    }

    private static String formatPhone(long phone) {
        String s = String.valueOf(phone);
        if (s.length() != 10) return null;

        return "(%s) %s-%s".formatted(s.substring(0, 3), s.substring(3, 6), s.substring(6));
    }

    @Override
    public String toString() {
        return """
                %s
                %s
                phones: %s
                emails: %s""".formatted(name, "-".repeat(name.length()), phones, emails);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33 * getName().hashCode();
    }

    public void addEmail(String companyName) {
        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length - 1],
                companyName.replaceAll(" ", "").toLowerCase());
        if (!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {
        if (emails.contains(oldEmail)) {
            emails.remove(oldEmail);
            emails.add(newEmail);
        }
    }
}
