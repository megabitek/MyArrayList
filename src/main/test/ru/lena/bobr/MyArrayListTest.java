package ru.lena.bobr;

import org.junit.Assert;
import org.junit.Test;
import ru.lenabobr.MyArrayList;

public class MyArrayListTest {
    @Test
    public void getSize(){
        MyArrayList arrayList = new MyArrayList(10);
        Assert.assertEquals(0,arrayList.getSize());
    }

    @Test
    public void getElementByIndex(){
        MyArrayList arrayList = new MyArrayList(10);
        arrayList.addElement(1);
        arrayList.addElement(3);
        arrayList.addElement(5);
        arrayList.addElement(6);
        Assert.assertEquals(5, arrayList.getElementByIndex(2));
    }
    @Test
public void addElementBy(){
    MyArrayList arrayList = new MyArrayList(10);

    }
}
