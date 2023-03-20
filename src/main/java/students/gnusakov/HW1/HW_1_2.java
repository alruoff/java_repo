package students.gnusakov.HW1;

//1)    В классе IntegerListDemo создайте список целых чисел.
//      Продемонстрируйте как:
//      добавить в список элемент (в начало и в конец)
//      узнать длину списка
//      удалить элемент из списка (по индексу и без)
//      узнать пустой список или нет
//      обойти список и вывести на консоль каждый элемент.

//      2) Могут ли реализации интерфейса java.util.List хранить одинаковые
//      элементы (дубликаты)? Напишите код программы, который демонстрирует ответ на этот вопрос.

public class HW_1_2 {
    public static void main(String[] args) {

        System.out.println("============");

        IntegerListDemo listDemo = new IntegerListDemo(10);

        listDemo.addElement(1); // добавляем последовательно элементы
        listDemo.addElement(10);
        listDemo.addElement(100);
        listDemo.addElement(101); // хранение 3-х одинаковых элементов
        listDemo.addElement(101);
        listDemo.addElement(101);
        listDemo.addElement(103);
        listDemo.addElement(105);

        System.out.println(listDemo.toString()); // вывод текущего состояния списка

        listDemo.addElement(80); // добавляем в конец списка ещё один элемент
        System.out.println(listDemo); // неявный вызов метода .toString()

        listDemo.addElementAsFirst(90); // добавляем в начало списка элемент
        System.out.println(listDemo);

        System.out.println("Size of the List: " + listDemo.getListIntegerSize());

        listDemo.removeElement(2);// удаляем элемент по индексу 2
        System.out.println(listDemo);
        System.out.println("Size of the List: " + listDemo.getListIntegerSize());

        System.out.println(listDemo.getNextElement());


        listDemo.removeElement();// удаляем текущий элемент в списке
        System.out.println(listDemo);
        System.out.println("Size of the List: " + listDemo.getListIntegerSize());

        System.out.println(listDemo.getNextElement()); // получаем след. элем. из списка
        System.out.println(listDemo.getLastElement()); // получаем последний элем. из списка

        System.out.println("Список пуст: " + ((listDemo.getListIntegerSize() == 0) ? "Yes" : "No")); // пуст список или нет

        System.out.println("==========");

        listDemo.iteratorReset(); //вывод всех эементов списка поэлементно
        while (listDemo.hasElement())
            System.out.println(listDemo.getNextElement());


    }
}