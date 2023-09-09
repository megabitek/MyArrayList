package ru.lenabobr;

import java.util.Arrays;
import java.util.Comparator;

/** My implementation of an array list and methods for working with it*/
public class MyArrayList<T> {
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     * Any empty ArrayList with elementData == DEFAULTSIZE_EMPTY will be expanded to currentSize when the first element is added
     */
    private T[] array;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int currentSize;
    /**
     * Parametr of increase in array capacity when array reached the maximum size
     */
    private final int CAPACITY_DECREASE_PARAMETR = 2;

    /**
     * Parametr specified limited difference between size and capacity
     */
    private final int SIZE_CAPACITY_DIFF = 3;

    /**
     * Default array capacity
     */
    private final int DEFAULT_CAPACITY_EMPTY = 10;

    private Comparator<T> comparator;

    /**
     * This method allows you to install a comparator of a given type. it is needed when sorting an array.
     * @param comparator - comparator for list's elements
     *
     */
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Create new ArrayList with default capacity
     */
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY_EMPTY];
        currentSize = 0;
    }

    /**
     * Create new ArrayList with user specified capacity
     *
     * @param capacity- array capacity
     * @throws  IllegalArgumentException – if the specified initial capacity is negative
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            array = (T[]) new Object[capacity];
            currentSize = 0;
        } else throw new IllegalArgumentException("Illegal Capacity: " +
                capacity);
    }

    /**
     * Add element with specified type in list
     *
     * @param elem - element for add in Array List
     */
    public void addElement(T elem) {
        array[currentSize] = elem;
        currentSize++;
    }

    /**
     * Add element in array list on the specified position.
     * After inserting an element, the capacity is not enough,
     * the array capacity is automatically increased (capacity *CAPACITY_DECREASE_PARAMETR)
     *If the index goes beyond the array boundary, the original array is not modified
     * @param elem - new element in array list
     * @param index - index for new element
     */
    public void addElementByIndex(T elem, int index) {
        checkIndex(index);
        growSize(currentSize + 1);
        for (int i = currentSize; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = elem;
        currentSize++;

    }
/**
 * Return the current size of array
 * @return - the array size (current element count)**/
    public int getSize() {
        return currentSize;
    }

    /**Return the value of element for given position. If index is wrong return null.
     * If the index goes beyond the array boundary, the original array is not modified
     * @param index- index for getting element
     * @return - the element in array list
     * */
    public T getElementByIndex(int index) {

        if (checkIndex(index))
            return array[index];
        else return null;
    }
/**Delete element on specified position from array list.
 * If the index goes beyond the array boundary, the original array is not modified
 @param index -  position of the element to be removed
 * */
    public void deleteElement(int index) {
        if (checkIndex(index)){
        for (int i = index + 1; i < currentSize; i++) {
            array[i - 1] = array[i];
        }
        array[currentSize - 1] = null;
        currentSize--;
    }}
/**
 * Delete all elements from array list*/
    public void cleanAll() {
        for (int i = 0; i < currentSize; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    /**
     * Method is used to sort an array using quicksort algorithm. The field Comparator must be set.
     */
    public void sortArray() {

        quickSort(array, 0, currentSize - 1);
    }

    private void quickSort(T[] array, int start, int end) {
        if (start >= end) return;
        int pivot = partition(array, 0, end, comparator);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(T[] array, int start, int end, Comparator<T> comparator) {
        T value = array[end];
        int position = start;
        for (int i = start; i < end; i++) {
            if (comparator.compare(array[i], value) == 1) continue;
            T temp = array[i];
            array[i] = array[position];
            array[position] = temp;
            position++;
        }
        array[end] = array[position];
        array[position] = value;
        return position;
    }
/**Change current element  value on the given position to new.
 * If the index goes beyond the array boundary, the original array is not modified
 * @param elem - the new  value of changing element in array list
 * @param index - position of the changing element*/
    public void changeElement(T elem, int index) {
        if (checkIndex(index))
        array[index] = elem;
    }

    private boolean checkIndex(int index){
        if ((index <= currentSize)&(index>=0)) return true;
        return false;
    }

    /**
     * When array size reaches the specified size (capacity - size = SIZE_CAPACITY_DIFF),
     * array capacity decrease with specified koefficient (old capacity*CAPACITY_DECREASE_PARAMETR)
     *
     * @param - array size for checking
     */
    private void growSize(int newSize) {
        if (array.length - newSize < SIZE_CAPACITY_DIFF) {
            T[] newAr = (T[]) new Object[array.length * CAPACITY_DECREASE_PARAMETR];
            newAr = Arrays.copyOf(array, array.length);
            array = newAr;
            newAr = null;
        }
    }
/**
 * Input all elements of array list on screen by line*/
    public void printArr() {
        Arrays.stream(Arrays.copyOf(array, currentSize)).forEach(n -> System.out.println(n));
    }
}
