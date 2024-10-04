package homework_2;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {

    boolean add(T element);
    T get(int index);
    T remove(int index);
    boolean addAll(List<? extends T> c);

    public void sort();
    public int size();
    public Iterator<T> iterator();
}
