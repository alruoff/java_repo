package students.gnusakov.HW1;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IntegerListDemo {
    // create class List with Integer as elements...
    private List<Integer> listInteger;
    // point Start of List
    private Iterator<Integer> iter; //

    private ListIterator<Integer> listerator;

    public IntegerListDemo(int cpList) {

        listInteger = new ArrayList<>(cpList);
    }

    public void addElement(int i) {
        listInteger.add(i);
    }

    public void addElementAsLast(int i) {
        addElement(i); // по умолчанию добавляет в конец списка
    }
    public void addElementAsFirst(int i) {
        listInteger.add(0, i);
    }

    public void removeElement(int i) {
        listInteger.remove(i);
    }

    public void removeElement() {
        if (iter != null) {
            iter.remove();
        } else {
            iter = listInteger.iterator();
            if (iter.hasNext()) {iter.next(); iter.remove();}
        }
    }

    Integer getNextElement() {
        if (iter == null) iter = listInteger.iterator();
        if (iter.hasNext()) {
            return iter.next();
        } else return 0;
    }
    boolean hasElement() {
        if (iter == null) iter = listInteger.iterator();
        if (iter.hasNext()) {
            return true;
        } else return false;
    }
    void iteratorReset() {
        iter = listInteger.iterator();
    }

    Integer getLastElement() {
        listerator = listInteger.listIterator(listInteger.size());

        return listerator.hasPrevious() ? listerator.previous() : 0;
    }

    @Override
    public String toString() {
        return "ListDemo " + listInteger.toString();
    }

    public Integer getListIntegerSize() {
        return listInteger.size();
    }

    public List<Integer> getListInteger() {
        return listInteger;
    }

}
