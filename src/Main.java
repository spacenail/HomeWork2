public class Main {
    public static void main(String[] args) {
/*
Создайте два массива: с участниками и препятствиями, и заставьте всех
 участников пройти этот набор препятствий.
* У препятствий есть длина (для дорожки) или высота (для стены),
 а участников ограничения на бег и прыжки. Если участник не смог
 пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
        Sportsman[] dreamTeam = {
                new Human(2,50),
                new Cat(3,40),
                new Robot(1,100)};

        Obstacles[] trainingTrack = {
                new Wall(1),
                new Treadmill(40),
                new Wall(2),
                new Treadmill(50)};

        for (Sportsman sportsman:dreamTeam){
            for(Obstacles obstacles:trainingTrack){
                if (!obstacles.overcome(sportsman)) {
                    break;
                }
            }
        }

    }
}
