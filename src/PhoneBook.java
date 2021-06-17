import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        if (phoneBook == null) {
            phoneBook = new HashMap<>();
        }
    }

    public void set(String lastName, String phoneNumber) {
        if(phoneBook.containsKey(lastName)){
            phoneBook.get(lastName).add(phoneNumber);
        }else {
            List list = new ArrayList();
            list.add(phoneNumber);
            phoneBook.put(lastName, list);
        }
    }

    public void get(String lastName){
        if(phoneBook.containsKey(lastName)) {
            System.out.println(phoneBook.get(lastName));
        }else {
            System.out.println("Фамилии " + lastName + " в телефонной книге не обнаружено");
        }
    }
}
