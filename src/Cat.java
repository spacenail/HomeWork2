public class Cat implements Sportsman{

    @Override
    public void run() {
        System.out.println(this.getClass().getName() + " run");
    }

    @Override
    public void jump() {
        System.out.println(this.getClass().getName() + " jump");
    }
}