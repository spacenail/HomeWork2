public class Wall {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public boolean tryingJump(int height){
        if(height >= wallHeight) {
            return true;
        } else {
            return false;
        }
    }
}
