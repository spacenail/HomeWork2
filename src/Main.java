import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 */
        List<String> list = new ArrayList<>();
        list.add("Каждый");
        list.add("Охотник");
        list.add("Желает");
        list.add("Каждый");
        list.add("Знать");
        list.add("Каждый");
        list.add("Где");
        list.add("Сидит");
        list.add("Фазан");
        list.add("Фазан");
        System.out.println(list);
/*
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 */
        Set<String> set = new HashSet(list);
        System.out.println(set);
/*
Посчитать сколько раз встречается каждое слово.
*/
        Map<String,Integer> mapOfRepeats = new HashMap<>();
        for (String s : set) {
            mapOfRepeats.put(s,Collections.frequency(list,s));
        }
        System.out.println(mapOfRepeats);
/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список
фамилий и телефонных номеров. В этот телефонный справочник с помощью метода
add() можно добавлять записи. С помощью метода get() искать номер телефона по
фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
(в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "84951001122");
        phoneBook.add("Петров", "84952221122");
        phoneBook.add("Сидоров", "84953001122");
        phoneBook.add("Иванов", "84991001122");
        System.out.println(phoneBook.get("Костров"));
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
    }
}
