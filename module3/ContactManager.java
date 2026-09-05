import java.util.HashMap;
import java.util.ArrayList;

public class ContactManager {
        public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("David Brown", new Contact("David Brown", "+1 617 555 0104"));
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Eva Davis", new Contact("Eva Davis", "+1 617 555 0105"));
        contacts.put("Carol Williams", new Contact("Carol Williams", "+1 617 555 0103"));
        contacts.put("Bob Smith", new Contact("Bob Smith", "+1 617 555 0102"));

 
        // Step 5: look up a contact 
        lookupContact(contacts, "Ada Lovelace");
        lookupContact(contacts, "Cat Will");

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
        System.out.println("==========All Contacts==========");
        sorted.forEach(System.out::println);

    } 
    private static void lookupContact(HashMap<String, Contact> contacts, String name) {
        if (contacts.containsKey(name)) {
            System.out.println(contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }
}
