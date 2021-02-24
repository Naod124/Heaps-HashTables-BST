package com.company;
/** https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/*/
/** source ^*/
public class BinarySearchTree {
Time time = new Time();
    Node root;

    BinarySearchTree(int [] list)
    {
        root = null;
        time.startTimer();
        for (int i = 0; i <list.length; i++) {

            insert(list[i]);
        }

        time.stopTimer();
        long totalTime = time.getTime();

        System.out.println("Size : "+ list.length + " & total time is " + time.toString(totalTime));

    }

    void insert(int key)
    {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key)
    {

        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

}