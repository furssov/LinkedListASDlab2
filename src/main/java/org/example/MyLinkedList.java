package org.example;

public class MyLinkedList<T> {

       private Link<T> first;


    class Link<T>
    {
        T value;
        Link<T> next;

        public Link(T value, Link<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
