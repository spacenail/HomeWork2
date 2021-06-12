/*
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
*/

public class Main {
    public static void main(String[] args) {
        Sportsman[] sportsmenArray = {
                new Human(100, 2),
                new Robot(500, 3),
                new Cat(20, 1)
        };

        Obstacle[] obstaclesArray = {
                new Wall(2),
                new RunningTrack(100)
        };

        for (int i = 0; i < sportsmenArray.length; i++) {
            for (int j = 0; j < obstaclesArray.length; j++) {
                if (!obstaclesArray[j].overcome(sportsmenArray[i])) {
                    System.out.println(sportsmenArray[i].getClass().getName() + " eliminated from tournament");
                    break;
                }
            }
        }
    }
}