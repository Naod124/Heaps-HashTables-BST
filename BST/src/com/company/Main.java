package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        FileRead fileRead = new FileRead();

        Time time = new Time();
        Scanner input = new Scanner(System.in);
        System.out.println("1. Binary search Tree");
        System.out.println("2. Heap");
        System.out.println("3. AVL");
        System.out.println("4. Red-Black Tree");
        // System.out.println("Menu");
        //System.out.println("1. insertion using MinHeap");
        int choice = input.nextInt();

        int[] sample = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2 } ;

        if (choice==1){
            time.startTimer();
            for (int i = 100; i < 1000001; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new BinarySearchTree( fileNumbers);
            }


            // for numbers in file inputs

        }
        if (choice==2){
            for (int i = 100; i < 1000001; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new heap( fileNumbers.length,fileNumbers);
            }

        }
        if (choice==3 ){
            for (int i = 100; i < 1000001; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new AVL( fileNumbers);
            }
        }
        if (choice==4){
            for (int i = 100; i < 1000001; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new RedBlackTree( fileNumbers.length,fileNumbers);
            }
        }

    }
}
