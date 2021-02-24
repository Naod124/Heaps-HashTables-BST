package com.company;


public class quadraticProbing {

 private int initCap;
    private HashEntry table[];
    private int size;
    public int putProbes;
    public int getProbes;


    public quadraticProbing(int cap)
    {
        initCap = cap;
        table = new HashEntry [initCap];
        size = 0;
        putProbes = 0;
        getProbes = 0;
    }

    public int hashFunction(int x) {
        return x % 10;
    }


    public int insert(int key, int value)
    {
        if(size == table.length)
        {
            return 0;
        }
        HashEntry n = new HashEntry(key, value);
        int m = hashFunction(key);
        int i = m;
        int c = 1;
        do
        {
           if(table[m] == null )
            {
                table[m] = n;
                size++;
                return 0;
            }


            if((table[m].key)==(key) )
            {
                int oldValue = table[m].data;
                table[m] = n;
                return oldValue;
            }
            i = (i + c * c++) % table.length;
            if(i < 0)
            {
                return 0;
            }
            m = i;
            putProbes++;
        }
        while(i < table.length);

        return 0;
    }


    public void printHashTable() {
        int i = 0;
        while (i < table.length) {
            System.out.print("\nHashTable [" + (i) + "] : ");
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


