/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 */

public class Human implements Sportsman{
    private int maxHeight;
    private int maxDistance;

    public Human(int maxHeight, int maxDistance) {
        this.maxHeight = maxHeight;
        this.maxDistance = maxDistance;
    }


    @Override
    public int run() {
        System.out.println(this.getClass().getName() + " run");
        return maxDistance;
    }

    @Override
    public int jump() {
        System.out.println(this.getClass().getName() + " jump");
        return maxHeight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "maxHeight=" + maxHeight +
                ", maxDistance=" + maxDistance +
                '}';
    }
}
