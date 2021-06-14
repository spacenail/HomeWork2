/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
 */

public class Cat implements Sportsman {
    private int maxRunDistance;
    private int maxJumpHeight;

    public Cat(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public int jump() {
        System.out.println("Cat jump");
        return this.maxJumpHeight;
    }

    public int run() {
        System.out.println("Cat run");
        return this.maxRunDistance;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}