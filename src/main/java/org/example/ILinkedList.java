package org.example;

import java.util.Comparator;
import java.util.function.BiPredicate;

public interface ILinkedList<T> {
    boolean insertFirst(T value);
    boolean insertAfter(int index, T value);
    boolean moveElement(T element , int distance);
    boolean removeByIndex(int index);
    boolean removeEveryNthElement(int n);
    void sort();
    MyLinkedList<T> copyList() throws CloneNotSupportedException;
    void clear();
    int getSize();
    T getFirstValue();

    void display();

}
