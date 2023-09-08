package  ru.lenabobr;
import java.util.ArrayList;
import java.util.Arrays;


public class MyArrayList<T>{
    private T [] array;
    private int currentSize;

    public MyArrayList(int maxSize){
        array = (T[]) new Object [maxSize];
        currentSize =0;
    }
    public void addElement(T elem){
        array[currentSize] = elem;
        currentSize++;
    }
    public void addElementByIndex(T elem, int index){
        growSize(currentSize+1);
        for (int i=currentSize; i>index; i--){
            array[i]=array[i-1];
        }
         array[index]=elem;
        currentSize++;

    }

    public int getSize(){
        return currentSize;
    }

    public T getElementByIndex(int index)  {
        if (index <= currentSize)
            return array[index];
        else return null;
    }

    public void deleteElement(int index){
        for (int i=index+1; i<currentSize; i++){
            array[i-1]=array[i];
        }
        array[currentSize-1]=null;
        currentSize--;
    }
    public void cleanAll(){
        for(int i = 0; i < currentSize; i++) {
            array[i] = null;
                    }
        currentSize=0;
    }
    public void sortArray(){

    }
    public void changeElement(int index){}

    private void growSize(int newSize){
        if (array.length - newSize<3){
            T [] newAr= (T[]) new Object [array.length*2];
            newAr = Arrays.copyOf(array, array.length);
            array= newAr;
            newAr = null;
        }
    }
    public void printArr(){
        Arrays.stream(array).forEach(n -> System.out.println(n));
    }
}
