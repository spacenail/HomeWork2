/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
 и просуммировать. Если в каком-то элементе массива преобразование не удалось
  (например, в ячейке лежит символ или текст вместо числа), должно быть
   брошено исключение MyArrayDataException, с детализацией в какой именно
    ячейке лежат неверные данные.
 3. В методе main() вызвать полученный метод, обработать возможные исключения
  MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) {
        String[][] array1 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] array2 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        String[][] array3 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"s","2","3","4"}};
        try {
            System.out.println(arrayAdder(array1)); // 40
            //System.out.println(arrayAdder(array2)); // MyArraySizeException
            System.out.println(arrayAdder(array3)); // MyArrayDataException
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int arrayAdder(String[][] array) throws MyArraySizeException, MyArrayDataException {
      checkSize(array);
      int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(e,i,j);
                }
            }
        }

      return sum;
    }

    private static void checkSize(String[][] array) throws MyArraySizeException{
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
    }
}
