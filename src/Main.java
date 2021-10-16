import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         Посчитать сколько раз встречается каждое слово.
         */
        List<String> list = new ArrayList<String>(Arrays.asList("Java", "Multithreading", "JDBC", "Servlet", "Swing",
                "Spring","Maven","SQL","Git", "Java", "Servlet", "HTML" ,"CSS"));
        System.out.println(list);
        Set<String> set = new HashSet<String>(list);
        System.out.println(set);
        for (String s:set){
            System.out.println("В списке содержится " + Collections.frequency(list,s) + " " + s);
        }




    }
}
