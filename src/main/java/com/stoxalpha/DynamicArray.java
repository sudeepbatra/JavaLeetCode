package com.stoxalpha;

public class DynamicArray<String> {

    private Object[] data;
    private int size;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        //Check size
        if (this.size == this.initialCapacity) {
            resize();
        }

        //Copy up
        for (int j = size; j > index; j--) {
            data[j] = data[j-1];
        }

        //Insert
        data[index] = value;
        size++;
    }

    //O(n)
    public void delete(int index) {
        //Copy down
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j+1];
        };

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String value) {
        for (int i =0; i < size; i++) {
            String currentIndexValue = (String) data[i];
            if (currentIndexValue.equals(value)) {
                return true;
            }
        }

        return false;
    }

    private void resize() {
        Object[] newData = new Object[this.initialCapacity * 2];
        for (int i = 0; i < this.initialCapacity; i++) {
            newData[i] = data[i];
        }

        data = newData;
        this.initialCapacity = this.initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i=0; i < size; i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }

    public void add(String value) {
        if (this.size == this.initialCapacity) {
            resize();
        }

        data[size] = value;
        size++;
    }
}
