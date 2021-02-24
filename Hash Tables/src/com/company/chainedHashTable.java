package com.company;
/** https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/ */
public class chainedHashTable {
    private int TABLE_SIZE;
    private int size;
    private HashEntry[] table;

    public chainedHashTable(int ts)
    {
        size = 0;
        TABLE_SIZE = ts;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    /* Function to insert a key value pair */
    public void insert(int key, int value)
    {
        int hash = (myhash( key ) % 10);
        if (table[hash] == null)
            table[hash] = new HashEntry(key, value);
        else
        {
            HashEntry entry = table[hash];
            if (entry.next != null && !(entry.key == (key))) {
                do entry = entry.next;
                while (entry.next != null && !(entry.key == (key)));
            }
            if (entry.key==(key))
                entry.data = value;
            else
                entry.next = new HashEntry(key, value);
        }
        size++;
    }

    /* Function myhash which gives a hash value */
    private int myhash(int x )
    {
        x %= 10;
        if (x < 0)
            x += 10;
        return x;
    }
    /* Function to print hash table */
    public void printHashTable()
    {
        int i = 0;
        while (i < table.length) {
            System.out.print("\nHashTable ["+ (i ) +"] : ");
            HashEntry entry = table[i];
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


