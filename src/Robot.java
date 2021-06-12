/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
 */

public class Robot implements Sportsman {
    private int maxRunDistance;
    private int maxJumpHeight;

    public Robot(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public int jump() {
        System.out.println("Robot jump");
        return this.maxJumpHeight;
    }

    public int run() {
        System.out.println("Robot run");
        return this.maxRunDistance;
    }
}