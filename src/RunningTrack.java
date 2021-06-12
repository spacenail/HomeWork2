/*
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
 */

public class RunningTrack implements Obstacle {
    private int TrackLength;

    public RunningTrack(int length) {
        this.TrackLength = length;
    }

    @Override
    public boolean overcome(Sportsman sportsman) {
        if(sportsman.run()>=this.TrackLength) {
            System.out.printf("%s ran the entire distance!\n", sportsman.getClass().getName());
            return true;
        }else{
            System.out.printf("%s could not pass the distance(\n", sportsman.getClass().getName());
            return false;
        }
    }
}