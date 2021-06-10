public class Human implements Jumpable,Runnable {
    private int maxRunDistance;
    private int maxJumpHeight;

    public Human(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.tryingJump(maxJumpHeight)) {
            System.out.println("Human jumped over the wall");
        } else {
            System.out.println(("Human not jumped over the wall"));
        }
    }

    @Override
    public void run(RunningTrack runningTrack) {
        if (runningTrack.tryingRun(maxRunDistance)) {
            System.out.println("Human ran successfully");
        } else {
            System.out.println(("Human couldn't run"));
        }
    }
}