package ru.lena.bobr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lenabobr.MyArrayList;

public class MyArrayListTestInt {

    MyArrayList arrayList = new MyArrayList<Integer>(10);


    @Before
    public void init() {
    //    MyArrayList arrayList = new MyArrayList(10);
        arrayList.addElement(3);
        arrayList.addElement(2);
        arrayList.addElement(2);
        arrayList.addElement(8);
    }
    @Test
    public void getSize(){
       // MyArrayList arrayList = new MyArrayList(10);
        Assert.assertEquals(4,arrayList.getSize());
    }

    @Test
    public void getElementByIndex() {

        Assert.assertEquals(5, arrayList.getElementByIndex(2));
       }


    @Test
     public void addElementByIndex(){
        arrayList.addElementByIndex(2, 2);
        Assert.assertEquals(5, arrayList.getSize());
        Assert.assertEquals(2, arrayList.getElementByIndex(2));
    }
    @Test
    public void deleteElement(){
    arrayList.deleteElement(3);
    Assert.assertEquals(3, arrayList.getSize());
    }

@Test
    public void changeElement(){
        Assert.assertEquals(5, arrayList.getElementByIndex(2));
        arrayList.changeElement(56, 2);
        Assert.assertEquals(56, arrayList.getElementByIndex(2));
    }

    @Test
    public void sortArray(){
        arrayList.sortArray();
        Assert.assertEquals(2, arrayList.getElementByIndex(0));
        Assert.assertEquals(2, arrayList.getElementByIndex(1));
        Assert.assertEquals(3, arrayList.getElementByIndex(2));
        Assert.assertEquals(8, arrayList.getElementByIndex(3));
    }
}

