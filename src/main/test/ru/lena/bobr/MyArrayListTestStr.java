package ru.lena.bobr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lenabobr.MyArrayList;

import java.util.Comparator;

public class MyArrayListTestStr {

    MyArrayList arrayList = new MyArrayList<String>();


    @Before
    public void init() {
    //    MyArrayList arrayList = new MyArrayList(10);
        arrayList.addElement("Tom");
        arrayList.addElement("Jane");
        arrayList.addElement("John");
        arrayList.addElement("Pete");
    }
    @Test
    public void getSize(){
       // MyArrayList arrayList = new MyArrayList(10);
        Assert.assertEquals(4,arrayList.getSize());
    }

    @Test
    public void getElementByIndex() {
       Assert.assertEquals("Jane", arrayList.getElementByIndex(2));
       }
    @Test
public void addElementByIndex(){
        arrayList.addElementByIndex("Maggie", 2);
        Assert.assertEquals(5, arrayList.getSize());
        Assert.assertEquals("Maggie", arrayList.getElementByIndex(2));
    }
@Test
    public void deleteElement(){
    arrayList.deleteElement(3);
    Assert.assertEquals(3, arrayList.getSize());
    }
@Test
    public void changeElement(){
        Assert.assertEquals("Jane", arrayList.getElementByIndex(2));
        arrayList.changeElement("56", 2);
        Assert.assertEquals("56", arrayList.getElementByIndex(2));
    }

    @Test
    public void sortArray(){
        arrayList.setComparator(new Comparator<String>() {
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

        arrayList.sortArray();
        Assert.assertEquals("Jane", arrayList.getElementByIndex(0));
        Assert.assertEquals("John", arrayList.getElementByIndex(1));
        Assert.assertEquals("Pete", arrayList.getElementByIndex(2));
        Assert.assertEquals("Tom", arrayList.getElementByIndex(3));
    }
}



