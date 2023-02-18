package com.stoxalpha;

public class HashTable {

    private final int INITIAL_SIZE = 16;
    private HashEntry[] data; //LinkedList

    private class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable() {
        data = new HashEntry[this.INITIAL_SIZE];
    }

    //O(1) but if the hashtable is not designed correctly it will be O(n)
    public void put(String key, String value) {
        int index = getIndex(key);

        HashEntry entry = new HashEntry(key, value);
        if (data[index] == null) {
            data[index] = entry;
        } else {
            HashEntry entries = data[index];

            while(entries.next != null) {
                entries = entries.next;
            }

            entries.next = entry;
        }
    }

    //O(1) but if the hashtable is not designed correctly it will be O(n)\
    public String get(String key) {
        int index = getIndex(key);

        HashEntry entries = data[index];

        if (entries != null) {
            while (entries.next != null) {
                if (entries.key.equals(key)) {
                    return entries.value;
                }
                entries = entries.next;
            }
        }

        return null;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        System.out.println("hashCode: " + hashCode);

        int index = hashCode % this.INITIAL_SIZE;

        if (key.equals("A") || key.equals("B")) {
            index = 4;
        }

        return index;
    }
}
