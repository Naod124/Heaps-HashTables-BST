package com.company;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here

        FileRead fileRead = new FileRead();

        System.out.println("Menu ");
        System.out.println("1. minHeap");
        System.out.println("2. minHeap(linear Time)");
        System.out.println("3. Traverse(Algorithm 2)");
        System.out.println("4. Traverse(Algorithm 1)");
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();

        int[] sample = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2 } ;

        if (choice== 1) {
            for (int i = 100; i < 1000002; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new BinaryHeap(fileNumbers.length, fileNumbers);
            }



            //new BinaryHeap(sample.length,sample);     // for sample input

        }
        if (choice==2){
           // new linearHeap(sample.length, sample) ;
            for (int i = 100; i < 1000002; i = i * 10) {
                int[] fileNumbers = fileRead.fileReader(i);      //From the file
                new linearHeap(fileNumbers.length, fileNumbers);
            }

        }

        if (choice==3){
            Traverse tree = new Traverse();
            tree.root = new Node(1);
            tree.root.left = new Node(3);
            tree.root.right = new Node(2);
            tree.root.left.left = new Node(6);
            tree.root.left.right = new Node(7);
            tree.root.left.left.left = new Node(15);
            tree.root.left.left.right = new Node(14);
            tree.root.left.right.left = new Node(12);
            tree.root.left.right.right = new Node(9);
            tree.root.right.left = new Node(5);
            tree.root.right.right = new Node(4);
            tree.root.right.right.left = new Node(13);
            tree.root.right.right.right = new Node(8);
            tree.root.right.left.left = new Node(10);
            tree.root.right.left.right = new Node(11);


            System.out.println("Preorder traversal of binary tree is : ");
            tree.printPreorder();

            System.out.println();
            System.out.println(" Inorder traversal of binary tree is : ");
            tree.printInorder();

            System.out.println();
            System.out.println(" Postorder traversal of binary tree is : ");
            tree.printPostorder();

            System.out.println();
            System.out.println(" levelOrder traversal of binary tree is : ");
            tree.levelOrder();
        }

        if (choice==4 ){

            Traverse tree = new Traverse();
            tree.root = new Node(1);
            tree.root.left = new Node(3);
            tree.root.right = new Node(2);
            tree.root.left.left = new Node(12);
            tree.root.left.right = new Node(6);
            tree.root.left.left.left = new Node(15);
            tree.root.left.left.right = new Node(14);
            tree.root.left.right.left = new Node(9);
            tree.root.left.right.right = new Node(7);
            tree.root.right.left = new Node(4);
            tree.root.right.right = new Node(8);
            tree.root.right.right.left = new Node(13);
            tree.root.right.right.right = new Node(10);
            tree.root.right.left.left = new Node(5);
            tree.root.right.left.right = new Node(11);


            System.out.println("Preorder traversal of binary tree is : ");
            tree.printPreorder();

            System.out.println();
            System.out.println(" Inorder traversal of binary tree is : ");
            tree.printInorder();

            System.out.println();
            System.out.println(" Postorder traversal of binary tree is : ");
            tree.printPostorder();

            System.out.println();
            System.out.println(" levelOrder traversal of binary tree is : ");
            tree.levelOrder();
        }

        if (choice==5){
            linearHeap line = new linearHeap();
            line.deleteMin();
            line.printHeap();
        }
        if (choice== 6){
            BinaryHeap binaryHeap = new BinaryHeap();
            binaryHeap.remove();
        }

        }



    }
