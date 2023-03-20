package students.rusakov.HW1;

import java.util.*;

//      3) создать List наполнить его 10М> элементами
//      При наполнении списка  сохраняем i- тый элемент в переменную temp
//      перебрать for-each loop
//      classic for и вызываем list.size() для каждой итерации
//      classic for, но list.size() определяем в переменную
//      classic for, list.size() определяем в переменную, перебираем с конца (i--)
//      используя Itertor
//      используя ListIterator
//      для всех случаев сделать замер времени
//      результат вывести в консоль

public class HW_3 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Integer temp = 1025; // элемент с таким индексом сохраним в этой же переменной

        Random rand = new Random();
// ************** создаём массив 10М ***********************************
        long time = System.nanoTime(); // фикс. время до

        for (int i = 0; i < 10000000; i++) {

            list.add(rand.nextInt());
            if (i == temp) temp = list.get(i);
        }
        System.out.println(temp);

        time = System.nanoTime() - time; // фикс. время после, разница в перем. time
        System.out.print("Время создания массива 10 000 000 элементов рандом-значений: ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// ************** проход по массиву с чтением одного и того же элемента ****************
        time = System.nanoTime();

        for (Integer inr : list) list.get(0);

        time = System.nanoTime() - time;
        System.out.print("Время прохода по массиву: for-each-loop ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// ************** проход по массиву for-i циклом (размер опред.каждый раз) *
        time = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {

                    list.get(i);

        }
        time = System.nanoTime() - time;
        System.out.print("Время перебора массива: for-i 1 ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// ************** проход по массиву for-i циклом (размер один раз) *********
        time = System.nanoTime();

        Integer listSize = list.size();
        for (int i = 0; i < listSize; i++) {

                    list.get(i);

        }
        time = System.nanoTime() - time;
        System.out.print("Время перебора массива: for-i 2 ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// *********************** for-i в обратном направлении ********************
        time = System.nanoTime();

        for (int i = listSize - 1; i >= 0; i--) {


                    list.get(i);

        }
        time = System.nanoTime() - time;
        System.out.print("Время перебора массива: for-i 3 ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// ************** Итератор с начала в конец массива ******************************
        // итератором с начала массива в конец
        time = System.nanoTime();
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {

            itr.next();
        }
        time = System.nanoTime() - time;
        System.out.print("Время перебора массива: Iterator вперёд ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);

// ******************** Итератор с конца в начало ****************************
        //итератором с конца массива в начало
        time = System.nanoTime();
        ListIterator<Integer> litr = list.listIterator(list.size());
        while (litr.hasPrevious())
            //System.out.println(
                litr.previous();
            //);
        time = System.nanoTime() - time;
        System.out.print("Время перебора массива: Iterator назад ");
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);
    }

}
