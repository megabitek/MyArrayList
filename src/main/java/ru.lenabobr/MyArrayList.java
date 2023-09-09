package  ru.lenabobr;
import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<T>{
    private T [] array;
    private int currentSize;

    private  Comparator<T> comparator;

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

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
