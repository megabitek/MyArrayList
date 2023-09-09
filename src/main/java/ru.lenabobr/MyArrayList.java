package  ru.lenabobr;
import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<T>{
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     * Any empty ArrayList with elementData == DEFAULTSIZE_EMPTY will be expanded to currentSize when the first element is added*/
    private T [] array;

    /**
     * The size of the ArrayList (the number of elements it contains).*/
    private int currentSize;

    private final int DEFAULTSIZE_EMPTY=10;

    private  Comparator<T> comparator;
/**
 *  This method allows you to install a comparator of a given type. it is needed when sorting an array is required
 *
 *  Type parameters:
 * <T> – the type of elements in this list*/
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }
/**
 * */

/**
 * Create new ArrayList with default capacity*/
    public MyArrayList(){
        array = (T[]) new Object [DEFAULTSIZE_EMPTY];
        currentSize =0;
    }
/**
 * Create new ArrayList with user specified capacity
 * Throws:
 IllegalArgumentException – if the specified initial capacity is negative*/
    public MyArrayList(int capacity){
        if (capacity>0){
        array = (T[]) new Object [capacity];
        currentSize =0;}
        else throw new IllegalArgumentException("Illegal Capacity: "+
                capacity);
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
    /**
     * this method use for array sorting */
    public void sortArray (){

     quickSort(array, 0, currentSize-1);
    }

    private void quickSort(T[] array, int start, int end){
            if (start >=end) return;
            int pivot = partition(array, 0, end, comparator);
            quickSort(array, start, pivot-1 );
            quickSort(array, pivot+1, end);
        }
        private  int partition (T [] array, int start, int end, Comparator <T>  comparator ){
            T value = array[end];
            int position = start;
            for (int i = start;  i<end; i++){
               if (comparator.compare(array[i], value) == 1) continue;
                T temp = array[i];
                array[i] = array[position];
                array[position] = temp;
                position++;
            }
            array[end]= array[position];
            array[position] = value;
            return position;
        }

    public void changeElement(T elem, int index){
        array[index]=elem;
    }

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
