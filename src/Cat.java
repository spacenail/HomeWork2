/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 */

public class Cat implements Sportsman{
    private int maxHeight;
    private int maxDistance;

    public Cat(int maxHeight, int maxDistance) {
        this.maxHeight = maxHeight;
        this.maxDistance = maxDistance;
    }

    @Override
    public int run() {
        System.out.println(this.getClass().getName() + " начинает бег");
        return maxDistance;
    }

    @Override
    public int jump() {
        System.out.println(this.getClass().getName() + " совершает прыжок");
        return maxHeight;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "высота прыжка=" + maxHeight +
                ", макс.дистанция=" + maxDistance +
                '}';
    }
}