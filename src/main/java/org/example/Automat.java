package org.example;

import java.util.Arrays;


public class Automat {

    public static void main(String[] args) {

        // Клет. автомат вернулся в исх. состояние ?
        // Управл. строка содержит полед. команд "U" - вверх, "D" - вниз, "R" - вправо, "L" - влево
        // прочие симолы игнор.

        String str = "UURRLLDD";

        System.out.println(isStartPoint(str));

        // последовательность монотонная?
        // 1 1 2 3 4 4 4 5 6 8 8 9
        // 80 75 75 75 75 75  74  73 5 5 5
        // 10 10 11 11 12 12 13 12

        System.out.println(isMono(string_toDigit("50 80 80 80 80 60 80 80 80 80 80")));

    }

    public static boolean isStartPoint(String s) {

        int vCount = 0;
        int hCount = 0;

        char eStr;

        for (int i = 0; i < s.length(); i++) {

            eStr = s.charAt(i);

            if (eStr == 'U') vCount++;
            else if (eStr == 'D') vCount--;
            else if (eStr == 'L') hCount++;
            else if (eStr == 'R') hCount--;
            else continue; // все прочие символы пропустит

        }
        return vCount == 0 && hCount == 0;

    }

    public static boolean isMono(Integer[] array) {
        if (Monotone(array) == 1) {
            System.out.println("Монотонно возрастает.");
            return true;
        }
        if (Monotone(array) == -1) {
            System.out.println("Монотонно убывает.");
            return true;
        }
        if (Monotone(array) == 0) {
            System.out.println("Стационарная последовательность.");
            return true;
        } else { // возвращает любое другое число
            System.out.println("Немонотонная последовательность.");
            return false;
        }
    }

    private static Integer[] string_toDigit(String string) {

        String[] str = string.split("\\s+|,|\\.|:|;"); // разделители
        int length = str.length;

        Integer[] intArray = new Integer[length];

        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.valueOf(str[i]);
        }
        return intArray;
    }

    // определить монотонность последовательности
    public static int Monotone(Integer[] array) {

        int sofarr = array.length;

        int[] arrOfSign = new int[sofarr - 1]; // новый массив для значений перемены знака

        for (int i = 0; i < sofarr - 1; i++) {
            int curr = array[i];
            int next = array[i + 1];
            arrOfSign[i] = next - curr >= 0 ? (next - curr == 0 ? 0 : 1) : -1;
        }
        if (Arrays.stream(arrOfSign).allMatch(e -> e == 0)) return 0; // стационарная послед.
        if (Arrays.stream(arrOfSign).allMatch(e -> e >= 0)) return 1; // монотонно возрастает
        if (Arrays.stream(arrOfSign).allMatch(e -> e <= 0)) return -1; // монотонно убывает
        else return 2; // немонотонная последовательность
    }
}