public class Robot implements Jumpable,Runnable{
    private int maxRunDistance;
    private int maxJumpHeight;

    public Robot(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.tryingJump(maxJumpHeight)) {
            System.out.println("Robot jumped over the wall");
        } else {
            System.out.println(("Robot not jumped over the wall"));
        }
    }

    @Override
        public void run(RunningTrack runningTrack) {
            if (runningTrack.tryingRun(maxRunDistance)) {
                System.out.println("Robot ran successfully");
            } else {
                System.out.println(("Robot couldn't run"));
            }
        }
    }