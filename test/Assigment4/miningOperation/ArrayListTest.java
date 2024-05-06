package Assigment4.miningOperation;

import utility.collection.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void addToIndexTest(){
        list.add(0,"Hello");

        assertEquals(0,list.indexOf("Hello"));
    }

    @Test
    public void addToIndexThrowsExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.add(1,"Hello");
        });
    }

    @Test
    public void addToEndOfListTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");
        list.add("Hello");

        assertEquals(2,list.indexOf("Hello"));
    }

    @Test
    public void setTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");
        list.set(1,"Hello");

        assertEquals(1,list.indexOf("Hello"));
    }

    @Test
    public void setThrowsExceptionTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");

        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.set(2,"Hello");
        });
    }

    @Test
    public void getTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");

        assertEquals("Hi",list.get(0));
    }


    @Test
    public void getThrowsExceptionTest(){
        list.add(0,"Hi");

        assertThrows(IllegalStateException.class, ()->{
            list.get(1);
        });
    }

    @Test
    public void removeTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");
        list.remove(0);

        assertEquals(0,list.indexOf("Hey"));
    }

    @Test
    public void removeThrowsExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, ()->{
            list.remove(2);
        });
    }

    @Test
    public void removeElementTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");
        list.remove("Hi");

        assertEquals(0,list.indexOf("Hey"));
    }

    @Test
    public void removeElementThrowsExceptionTest(){
        list.add(0,"Hi");

        assertThrows(IllegalStateException.class, ()->{
           list.remove("Hello");
        });
    }

    @Test
    public void indexOfTest(){
        list.add(0,"Hi");

        assertEquals(0,list.indexOf("Hi"));
    }

    @Test
    public void containsTest(){
        list.add(0,"Hi");

        assertTrue(list.contains("Hi"));
    }

    @Test
    public void isEmptyTest(){
        assertTrue(list.isEmpty());
    }

    @Test
    public void sizeTest(){
        list.add(0,"Hi");

        assertEquals(1,list.size());
    }

    @Test
    public void toStringTest(){
        list.add(0,"Hi");
        list.add(1,"Hey");

        assertEquals("{Hi, Hey}",list.toString());
    }

    @Test
    public void isFullTest(){
        list.add(0,"Hi");

        assertTrue(list.isFull());
    }
}
