public class Main {
    public static void main(String[] args) {
        //Course c = new Course(...); // Создаем полосу препятствий
        Team team = new Team("Earth",new Human(),new Cat(),new Human(),new Cat()); // Создаем команду
        team.getTeamInfo();
        //c.doIt(team); // Просим команду пройти полосу
       // team.showResults(); // Показываем результаты
    }
}
