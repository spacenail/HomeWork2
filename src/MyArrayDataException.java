public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int x, int y, Throwable e) {
        super("Cell [" + x + "][" + y + "] is not a number",e);
    }
}
