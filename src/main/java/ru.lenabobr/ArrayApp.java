package ru.lenabobr;


public class ArrayApp {
public static void main(String[] args){
    MyArrayList<Integer> arrayList = new MyArrayList<Integer>(10);
    arrayList.addElement(1);
    arrayList.addElement(3);
    arrayList.addElement(6);
    arrayList.addElement(7);
    arrayList.addElement(54);

    //arrayList.addElementByIndex(8, 3);
//arrayList.deleteElement(3);
    arrayList.sortArray();
    arrayList.printArr();

}
}
