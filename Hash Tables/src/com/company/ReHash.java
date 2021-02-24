package com.company;

public class ReHash {


    private int initialCapacity;
    private HashEntry table[];
    private int size;
    public int insertProbes;
    public int getProbes;


    public ReHash(int cap)
    {
        initialCapacity = cap;
        table = new HashEntry [initialCapacity];
        size = 0;
        insertProbes = 0;
        getProbes = 0;
    }

    // do get and remove methods

    public int hashFunction(int x) {
        return 7-(x % 7);
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
        insertProbes++;
        while (i < table.length) {
            if (table[m] == null) {
                table[m] = n;
                size++;
                return 0;
            }


            if ((table[m].key) == (key)) {
                int oldValue = table[m].data;
                table[m] = n;
                return oldValue;
            }
            i = (i + c * c++) % table.length;
            if (i < 0) {
                return 0;
            }
            m = i;
            insertProbes++;
        }

        if( ++size > table.length / 2 ) {
            rehash();
        }
        return 0;
    }
    private void allocateArray( int arraySize )
    {
        table = new HashEntry[ nextPrime( arraySize ) ];
    }

    private static int nextPrime( int n )
    {
        if( n <= 0 )
            n = 3;

        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }

    private void rehash( )
    {

        HashEntry[ ] oldArray = table;

        // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) );
        size = 0;

        // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null )
                insert( oldArray[ i ].key, oldArray[ i ].data);
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
