package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class MyLinkedList<T> implements ILinkedList<T>, Cloneable {

       private Link<T> first;

        private int size;
       public MyLinkedList()
       {
           first = null;
           size = 0;
       }
       @Override
    public int getSize() {
        return size;
    }

    @Override
    public T getFirstValue() {
        return first.value;
    }

    @Override
    public boolean insertFirst(T value) {
           Link<T> newLink = new Link<>(value);
           newLink.next = first;
           first = newLink;
           size++;
        return true;
    }

    @Override
    public boolean insertAfter(int index, T value) {
           if (index < size) {
               Link<T> link = first;
               Link<T> newLink = new Link<>(value);
               for (int i = 0; i != index; i++) {
                   link = link.next;
               }
               newLink.next = link.next;
               link.next = newLink;
               size++;
                return true;
           }
           else
        return false;
    }

    @Override
    public boolean moveElement(T element, int distance) {
           Link<T> link = find(element);
           if (link == null) return false;
           int index = getIndex(link);

           removeByIndex(index);

         for (int i = 1; i <= distance; i++)
         {
             index ++;
             if (index > size) index = 0;
         }


           insertAfter(index, element);
           return true;

    }

    @Override
    public boolean removeByIndex(int index) {

           Link<T> linkCurr = getElementByIndex(index);
           if (linkCurr == null) return false;
           if (index == 0)
           {
               first = first.next;
           }
           else
           {
               Link<T> linkPrev = getElementByIndex(index - 1);

               linkPrev.next = linkCurr.next;
           }

           size--;

        return true;
    }

    @Override
    public boolean removeEveryNthElement(int n) {
           if (n == 0) return false;
           for(int i = n; i < size; i += n)
           {
               removeByIndex(i - 1);

           }
        return true;
    }

    @Override
    public void sort() {
         boolean sorted = false;

         while (!sorted)
         {
             sorted = true;
             Link<T> link = first;
             for (int i = 0 ; i < size - 1; i++)
             {
                 if (link.next != null) {
                     if (link.value instanceof Integer) {
                         if (((Integer) link.value).compareTo((Integer) link.next.value) == 1) {
                             sorted = false;
                             T n = link.value;
                             link.value = link.next.value;
                             link.next.value = n;

                         }
                         link = link.next;

                     }
                     if (link.value instanceof String) {
                         if (((String) link.value).compareTo((String) link.next.value) == 1) {
                             sorted = false;
                             T n = link.value;
                             link.value = link.next.value;
                             link.next.value = n;

                         }
                         link = link.next;

                     }
                 }

             }
         }
    }

    @Override
    public MyLinkedList<T> copyList() throws CloneNotSupportedException {
           MyLinkedList<T> myLinkedList = (MyLinkedList<T>) this.clone();
           return myLinkedList;

    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    private Link<T> find(T value)
    {
        Link<T> link = first;
        while (!link.value.equals(value))
        {
            if(link.next == null)
            {
                return null;
            }
            else
            {
                link = link.next;
            }
        }
        return link;
    }

    private int getIndex(Link<T> link)
    {
        Link<T> f = first;
        int i = 0;
        while (!f.equals(link))
        {
            if (f.next == null)
            {
                return -1;
            }
            else {
                f = f.next;
            }
            i++;
        }
        return i;
    }

    private Link<T> getElementByIndex(int index)
    {
        Link<T> link = first;
        if (index >= size) return null;
        for (int i = 0; i < index; i++)
        {
            link = link.next;
        }
        return link;
    }

    public void display()
    {
        System.out.println(first);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size && Objects.equals(first, that.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, size);
    }

    class Link<T>
    {
        T value;
        Link<T> next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Link<?> link = (Link<?>) o;
            return Objects.equals(value, link.value) && Objects.equals(next, link.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        public Link(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }



    }
}
