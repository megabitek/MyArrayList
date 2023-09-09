package ru.lena.bobr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.lenabobr.MyArrayList;

import java.util.Comparator;

public class MyArrayListTestInt {

    MyArrayList arrayList = new MyArrayList<Integer>();


    @Before
    public void init() {
        //    MyArrayList arrayList = new MyArrayList(10);
        arrayList.addElement(3);
        arrayList.addElement(2);
        arrayList.addElement(5);
        arrayList.addElement(8);
    }

    @Test
    public void negativeCapacity() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MyArrayList<Integer> arrayList1 = new MyArrayList<>(-10);
        });
        Assertions.assertEquals("Illegal Capacity: -10", thrown.getMessage());
    }

    @Test
    public void getSize() {
        // MyArrayList arrayList = new MyArrayList(10);
        Assert.assertEquals(4, arrayList.getSize());
    }

    @Test
    public void getElementByIndex() {
        Assert.assertEquals(5, arrayList.getElementByIndex(2));
    }

    @Test
    public void getElementByWrongIndex() {
        Assert.assertEquals(null, arrayList.getElementByIndex(8));
    }

    @Test
    public void getElementByNegativeIndex() {
        Assert.assertEquals(null, arrayList.getElementByIndex(-8));
    }


    @Test
    public void addElementByIndex() {
        arrayList.addElementByIndex(2, 2);
        Assert.assertEquals(5, arrayList.getSize());
        Assert.assertEquals(2, arrayList.getElementByIndex(2));
    }

    @Test
    public void deleteElement() {
        arrayList.deleteElement(3);
        Assert.assertEquals(3, arrayList.getSize());
    }

    @Test
    public void changeElement() {
        Assert.assertEquals(5, arrayList.getElementByIndex(2));
        arrayList.changeElement(56, 2);
        Assert.assertEquals(56, arrayList.getElementByIndex(2));
    }

    @Test
    public void sortArray() {
        arrayList.setComparator(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        arrayList.sortArray();
        Assert.assertEquals(2, arrayList.getElementByIndex(0));
        Assert.assertEquals(3, arrayList.getElementByIndex(1));
        Assert.assertEquals(5, arrayList.getElementByIndex(2));
        Assert.assertEquals(8, arrayList.getElementByIndex(3));
    }

    @Test
    public void sortArrayString(){

        MyArrayList arrayListStr = new MyArrayList<String>();
        arrayListStr.addElement("Tom");
        arrayListStr.addElement("Jane");
        arrayListStr.addElement("John");
        arrayListStr.addElement("Pete");
        arrayListStr.setComparator(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if  (str1.compareTo(str2)==0)
                    return 0;
                else if (str1.compareTo(str2)>0)
                    return 1;
                else
                    return -1;
            }}
        );

        arrayListStr.sortArray();
        Assert.assertEquals("Jane", arrayListStr.getElementByIndex(0));
        Assert.assertEquals("John", arrayListStr.getElementByIndex(1));
        Assert.assertEquals("Pete", arrayListStr.getElementByIndex(2));
        Assert.assertEquals("Tom", arrayListStr.getElementByIndex(3));
    }

    @Test
    public void cleanAll(){
        arrayList.cleanAll();
        Assert.assertEquals(0, arrayList.getSize());
    }
}

