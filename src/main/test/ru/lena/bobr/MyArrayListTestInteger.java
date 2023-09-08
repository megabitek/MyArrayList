package ru.lena.bobr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lenabobr.MyArrayList;

public class MyArrayListTestInteger {

    MyArrayList arrayList = new MyArrayList(10);


    @Before
    public void init() {
    //    MyArrayList arrayList = new MyArrayList(10);
        arrayList.addElement(1);
        arrayList.addElement(3);
        arrayList.addElement(5);
        arrayList.addElement(6);
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
}
