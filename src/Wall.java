/*
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
 */

public class Wall implements Obstacle {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public boolean overcome(Sportsman sportsman) {
        if(sportsman.jump()>=this.wallHeight) {
            System.out.printf("%s jumped over the wall!\n",sportsman.getClass().getName());
            return true;
        }else{
            System.out.printf("%s not jumped over the wall(\n",sportsman.getClass().getName());
            return false;
        }
    }
}