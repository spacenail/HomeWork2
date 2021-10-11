/*
Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 */

public class Treadmill implements Obstacles {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Sportsman sportsman) {
        if (sportsman.run() >= length) {
            System.out.println(sportsman + " преодолел препятствие " + this);
            return true;
        } else {
            System.out.println(sportsman + " не смог преодолеть препятствие " + this);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }
}
