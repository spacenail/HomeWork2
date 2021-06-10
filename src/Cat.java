public class Cat implements Jumpable,Runnable{
    private int maxRunDistance;
    private int maxJumpHeight;

    public Cat(int maxRunDistance,int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.tryingJump(maxJumpHeight)) {
            System.out.println("Cat jumped over the wall");
        } else {
            System.out.println(("Cat not jumped over the wall"));
        }
    }

    @Override
        public void run(RunningTrack runningTrack) {
            if (runningTrack.tryingRun(maxRunDistance)) {
                System.out.println("Cat ran successfully");
            } else {
                System.out.println(("Cat couldn't run"));
            }
        }
    }