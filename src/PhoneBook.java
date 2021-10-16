import java.util.*;

public class PhoneBook {
          /*
        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных
         номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи.
         С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной
         фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой
         фамилии должны выводиться все телефоны.
         */
   private final Map<String, Set<String> > phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber){
        if(phoneBook.containsKey(lastName)) {
            phoneBook.get(lastName).add(phoneNumber);
        }else{
            Set<String> set = new HashSet<>();
            set.add(phoneNumber);
            phoneBook.put(lastName,set);
        }
    }

    public void get(String lastName){
        try {
            System.out.println(lastName + " " + phoneBook.get(lastName).toString());
        } catch (NullPointerException e){
            System.out.println("Фамилия " + lastName + " не найдена!");
        }
    }
}
