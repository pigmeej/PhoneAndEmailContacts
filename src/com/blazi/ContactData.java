package com.blazi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    private static final String phones = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private static final String emails = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String type) {
        String data = switch (type) {
            case "phones" -> phones;
            case "emails" -> emails;
            default -> "";
        };

        Scanner scanner = new Scanner(data);
        List<Contact> newList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] contactInfo = scanner.nextLine().split(", ");
            newList.add(switch (type) {
                case "phones" -> new Contact(contactInfo[0], Long.parseLong(contactInfo[1]));
                case "emails" -> new Contact(contactInfo[0], contactInfo[1]);
                default -> null;
            });
        }
        return newList;
    }
}
