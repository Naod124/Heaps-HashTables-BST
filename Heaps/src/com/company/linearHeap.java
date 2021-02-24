package com.company;

import java.util.stream.IntStream;

import static java.lang.System.arraycopy;

public class linearHeap {

    private int[] Heap;


    private int size;
    private int maxSize;
    Time time = new Time();

    public linearHeap(int maxSize, int [] list){
        this.maxSize = maxSize;
        this.size = 0;
        this.Heap = new int[maxSize];
        resetHeap();
        buildHeapLinearTime(list);
        time.startTimer();
        for (int i = 0; i <list.length; i++) {

            insert(list[i]);
        }

        time.stopTimer();
        long totalTime = time.getTime();
        System.out.println("Size : "+ list.length + " & total time for inserting is " + time.toString(totalTime));
        System.out.println();

        if (list.length==1000000) {
            System.out.println("------------------------------------------------------------");
            System.out.println(" deleting min heap");
            time.startTimer();
            deleteMin();
      /*  for(int i = 1; i <= size; i++){

            System.out.print(Heap[i] +"  ");
        }


       */



            time.stopTimer();
            long newTime1 = time.getTime();

            System.out.println();

            System.out.println(" total time for deletion min is " + time.toString(newTime1));

            //System.out.println("Total time  is " + time.toString(newTime));
            System.out.println("-----------------------------------------------------------------");

        }

    }
    public linearHeap(){}

    private int parent(int i){
        if(i <=0 || i >= this.size){
            return -1;
        }
        return (i-1)/2;
    }

    private int left(int i){
        int left = 2*i + 1;
        if(left >= this.size){
            return -1;
        }
        return left;
    }

    private int right(int i){

        int right = 2*i + 2;
        if(right >= this.size){
            return -1;
        }
        return right;
    }

    private void minHeapify(int i){
        int leftChild = left(i);
        int rightChild = right(i);
        int min;
        if(leftChild != -1 && this.Heap[leftChild] < this.Heap[i]){
            min = leftChild;
        }
        else {
            min = i;
        }
        if(rightChild != -1 && this.Heap[rightChild] < this.Heap[min]){
            min = rightChild;
        }
        if(min != i){
            swap(this.Heap,i,min);
            minHeapify(min);
        }
    }

    private void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printHeap(){
        for(int i = 0; i<this.size; i++){
            System.out.print(this.Heap[i] + " ");
        }
    }


    public void insert(int data){
        if(this.size == this.maxSize){
            resizeHeap();
        }
        this.size++;
        int i = this.size-1;
        this.Heap[i] = data;
        while (i >=0 && parent(i) >=0 && this.Heap[parent(i)] > this.Heap[i]){
            swap(Heap,i,parent(i));
            i = parent(i);
        }
    }

    private void resizeHeap(){
        int[] oldArr = new int[this.maxSize];
        arraycopy(this.Heap,0,oldArr,0,this.size-1);
        this.Heap = new int[this.maxSize *2];
        for(int i =0; i< oldArr.length ; i++){
            this.Heap[i] = oldArr[i];
        }
        this.maxSize *=2;

    }

    public int deleteMin(){
        if (this.size == 1)
        {
            this.size--;
            return this.Heap[0];
        }

        int root = this.Heap[0];
        this.Heap[0] = this.Heap[this.size-1];
        this.size--;
        minHeapify(0);
        return root;
    }

    public void buildHeapLinearTime(int [] arr){
        if (arr.length > this.maxSize - this.size) {
            do {
                resizeHeap();
            } while (arr.length > this.maxSize - this.size);
        }
        {
            int i=0 ;
            while (i < arr.length) {
                this.Heap[i] = arr[i];
                this.size++;
                i++;
            }
        }
        int firstNonLeaf = (this.size - 1)/2;
        IntStream.iterate(firstNonLeaf, i -> i >= 0, i -> i - 1).forEach(this::minHeapify);
    }

    private void resetHeap(){
        this.size = 0;
        this.Heap = new int[this.maxSize];
    }


}