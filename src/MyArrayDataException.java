public class MyArrayDataException extends Exception{

    public MyArrayDataException(Exception e, int i,int j) {
        super("В ячейке [" + i +"][" + j +"] не верные данные",e);
    }
}
