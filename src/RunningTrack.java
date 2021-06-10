public class RunningTrack {
    private int TrackLength;

    public RunningTrack(int length) {
        this.TrackLength = length;
    }

    public boolean tryingRun(int length){
        if(length >= TrackLength) {
            return true;
        } else {
            return false;
        }
    }
}