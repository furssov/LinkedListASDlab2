package org.example;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ILinkedListTest {
    ILinkedList<Integer> linkedList;
            @BeforeEach
            void setUp()
            {
                linkedList = new MyLinkedList<>();
                linkedList.insertFirst(1);
            }


    @org.junit.jupiter.api.Test
    void insertFirst() {
            assertTrue(linkedList.insertFirst(1));
        assertEquals(2, linkedList.getSize());
        assertEquals(1, linkedList.getFirstValue());
        assertTrue(linkedList.insertFirst(2));
        assertEquals(3, linkedList.getSize());
        assertEquals(2, linkedList.getFirstValue());
        linkedList.display();
    }

    @org.junit.jupiter.api.Test
    void insertAfter() {
                assertTrue(linkedList.insertAfter(0, 10));
                assertEquals(2, linkedList.getSize());
                assertEquals(1, linkedList.getFirstValue());
                assertFalse(linkedList.insertAfter(2, 24));
                assertEquals(2, linkedList.getSize());
                linkedList.display();
    }

    @org.junit.jupiter.api.Test
    void moveElement() {

                linkedList.insertFirst(10);
                linkedList.insertFirst(11);
                linkedList.insertFirst(12);
                linkedList.insertFirst(13);

                linkedList.display();

                linkedList.moveElement(10, 3);

                 System.out.println("__________");
                 linkedList.display();
    }

    @org.junit.jupiter.api.Test
    void removeByIndex() {

        linkedList.insertFirst(10);
        linkedList.insertFirst(11);
        linkedList.insertFirst(12);
        linkedList.insertFirst(13);
        linkedList.display();
        System.out.println("______");
        assertTrue(linkedList.removeByIndex(0));
        linkedList.display();
        System.out.println("______");
        assertTrue(linkedList.removeByIndex(2));
        linkedList.display();
        System.out.println("______");
        assertFalse(linkedList.removeByIndex(4));
        linkedList.display();



    }

    @org.junit.jupiter.api.Test
    void removeEveryNthElement() {
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);
        linkedList.insertFirst(10);
        linkedList.display();
        System.out.println("_________");
        assertTrue(linkedList.removeEveryNthElement(2));
        linkedList.display();
    }

    @org.junit.jupiter.api.Test
    void sort() {
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertFirst(9);
        linkedList.insertFirst(10);
        linkedList.display();
        System.out.println("__________");
        linkedList.sort();
        linkedList.display();

    }

    @org.junit.jupiter.api.Test
    void copyList() throws CloneNotSupportedException {
                MyLinkedList<Integer> myLinkedList = linkedList.copyList();
                assertTrue(myLinkedList.equals(linkedList));
                myLinkedList.insertFirst(54);
                assertFalse(myLinkedList.equals(linkedList));
    }

    @org.junit.jupiter.api.Test
    void clear() {
                linkedList.clear();
                assertEquals(0, linkedList.getSize());
                linkedList.display();
    }
}