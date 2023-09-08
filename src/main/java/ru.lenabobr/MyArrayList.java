package  ru.lenabobr;
import java.util.ArrayList;
import java.util.Arrays;


public class MyArrayList {
    private int[] array;
    private int currentSize;

    public MyArrayList(int maxSize){
        array = new int [maxSize];
        currentSize =0;
    }
    public void addElement(int elem){
        array[currentSize] = elem;
        currentSize++;
    }
    public void addElementByIndex(int elem, int index){
        growSize(currentSize+1);
        for (int i=currentSize; i>=index; i--){
            array[i]=array[i-1];
        }
         array[index-1]=elem;
        currentSize++;

    }

    public int getSize(){
        return currentSize;
    }

    public int getElementByIndex(int index){
        return array[index];
    }
    public void deleteElement(int index){
        for (int i=index; i<currentSize; i++){
            array[i-1]=array[i];
        }
        array[currentSize-1]=0;
        currentSize--;
    }
    public void cleanAll(){}
    public void sortArray(){}
    public void changeElement(int index){}

    private void growSize(int newSize){
        if (array.length - newSize<3){
            int[] newAr= new int[array.length*2];
            newAr = Arrays.copyOf(array, array.length);
            array= newAr;
            newAr = null;
        }
    }
    public void printArr(){
        Arrays.stream(array).forEach(n -> System.out.println(n));
    }
}
