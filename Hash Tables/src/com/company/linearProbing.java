package com.company;
/** https://www.sanfoundry.com/java-program-implement-hash-tables-linear-probing/ */

public class linearProbing {
    private final HashEntry[] hashArray;

    private final int arraySize;


    public linearProbing(int size) {
        arraySize = size;
        hashArray = new HashEntry[arraySize];
    }

    public int hashFunction(int x) {
        return  x % 10;
    }


    public void insert(HashEntry item){
        int key = item.getKey();
        int hashVal = hashFunction(key); // hash the key
        // until empty cell or -1,
        if (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            do {
                ++hashVal; // go to next cell
                hashVal %= arraySize; // wraparound if necessary
            } while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1);
        }
        hashArray[hashVal] = item; // insert item
    }

    public void printHashTable()
    {
        int i = 0;
        while (i < hashArray.length) {
            System.out.print("\nHashTable ["+ (i ) +"] : ");
            HashEntry entry = hashArray[i];
            if (entry != null) {
                do {
                    System.out.print(entry.data + " ");
                    entry = entry.next;
                } while (entry != null);
            }
            i++;
        }
    }


}

