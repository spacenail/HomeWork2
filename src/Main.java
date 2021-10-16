import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         Посчитать сколько раз встречается каждое слово.
         */
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Multithreading", "JDBC", "Servlet", "Swing",
                "Spring","Maven","SQL","Git", "Java", "Servlet", "HTML" ,"CSS"));
        System.out.println(list);
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        for (String s:set){
            System.out.println("В списке содержится " + Collections.frequency(list,s) + " " + s);
        }
        /*
        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных
         номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи.
         С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной
         фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой
         фамилии должны выводиться все телефоны.
         */

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Willis","01");
        phoneBook.add("Willis","01");
        phoneBook.add("Willis","89294442323");
        phoneBook.get("Willis");
        phoneBook.get("Payne");
    }
}
