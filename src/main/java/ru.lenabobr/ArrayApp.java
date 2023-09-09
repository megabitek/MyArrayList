package ru.lenabobr;


import java.util.Comparator;

public class ArrayApp {
public static void main(String[] args){
    MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
    arrayList.addElement(1);
    arrayList.addElement(3);
    arrayList.addElement(6);
    arrayList.addElement(7);
    arrayList.addElement(54);

    //arrayList.addElementByIndex(8, 3);
//arrayList.deleteElement(3);
    arrayList.setComparator(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    arrayList.sortArray();
    arrayList.printArr();

}
}
