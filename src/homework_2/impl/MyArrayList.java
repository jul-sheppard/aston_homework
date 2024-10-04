package homework_2.impl;

import homework_2.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements List<T> {

    private T[] objects;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity < 0");
        } else {
            objects = (T[]) new Object[capacity];
        }
    }

    public MyArrayList() {
        objects = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T element) {
        if (size == objects.length) {
            objects = Arrays.copyOf(objects, 2 * objects.length);
        }
        objects[size++] = (T) element;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return objects[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T element = objects[index];
        if (index < size) {
            objects[index] = null;
            System.arraycopy(objects, index + 1, objects, index, size - index - 1);
            size--;
        }
        return element;
    }

    @Override
    public boolean addAll(List<? extends T> c) {
        ensureCapacity(size + c.size());
        for (T element : c) {
            add(element);
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > objects.length) {
            objects = Arrays.copyOf(objects, size * 2);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(objects[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (objects[j].compareTo(objects[j + 1]) > 0) {
                    T tmp = objects[j];
                    objects[j] = objects[j + 1];
                    objects[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }
    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return objects[currentIndex++];
        }
    }
}
