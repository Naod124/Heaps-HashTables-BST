package com.company;
/** https://www.geeksforgeeks.org/min-heap-in-java/ */
public class BinaryHeap {

    private int[] Heap;
    private int size;
    private int maxsize;
    Time time = new Time();
    private static final int FRONT = 1;

    public BinaryHeap(int maxsize, int [] list) {

        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
        time.startTimer();
        for (int i = 0; i < list.length; i++) {

            insert(list[i]);

        }

        time.stopTimer();
        long newTime = time.getTime();
        System.out.println("Size : " + list.length + " & total time is " + time.toString(newTime) + " for insertion");
        System.out.println();

        if (list.length==1000000) {
            System.out.println("------------------------------------------------------------");
            System.out.println(" deleting min heap");
            time.startTimer();
            remove();
      /*  for(int i = 1; i <= size; i++){

            System.out.print(Heap[i] +"  ");
        }


       */

            time.stopTimer();
            long newTime1 = time.getTime();

            System.out.println();

            System.out.println(" total time for deletion min is " + time.toString(newTime1));

            System.out.println("-----------------------------------------------------------------");

        }
    }





    public BinaryHeap(){}

    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int current, int parent)
    {
        int tmp;
        tmp = Heap[current];
        Heap[current] = Heap[parent];
        Heap[parent] = tmp;
    }

    private void minHeapify(int pos)
    {

        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {


                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }


                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(int element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        if (Heap[current] < Heap[parent(current)]) {
            do {
                swap(current, parent(current));
                current = parent(current);
            } while (Heap[current] < Heap[parent(current)]);
        }
    }

    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        System.out.println();

        return popped;
    }

}
