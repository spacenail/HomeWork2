public class Main {
    public static void main(String[] args) {
        String[][] wrongArray = {{"1", "2", "3"}, {"a", "b", "c"}};
        String[][] partlyCorrectArray = {{"1", "2", "3", "4"}, {"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}};
        String[][] correctArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        System.out.println(sumIntArray(correctArray));
    }


    static public int sumIntArray(String[][] stringArray) {
        if (stringArray.length != 4 && stringArray[0].length != 4) {
            throw new MyArraySizeException();
        }
        return adder(stringArray);
    }

    private static int adder(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, e);
                }
            }
        }
        return sum;
    }
}
