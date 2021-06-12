/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
 */

public class Human implements Sportsman{
    private int maxRunDistance;
    private int maxJumpHeight;

    public Human(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }


    public int jump() {
            System.out.println("Human jump");
            return this.maxJumpHeight;
    }


    public int run() {
        System.out.println("Human run");
        return this.maxRunDistance;
    }
}