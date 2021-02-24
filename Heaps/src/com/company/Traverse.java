package com.company;
/** https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/ */

// Java program for different tree traversals

/* Class containing left and right child of current
   node and key value*/


import java.util.LinkedList;
import java.util.Queue;

public class Traverse
{
    // Root of Binary Tree
    Node root;
    Traverse()
    {
        root = null;
    }




    void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.print(node.key + " ");
    }

    void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.print(node.key + " ");

        printInorder(node.right);
    }

    void printPreorder(Node node)
    {
        if (node == null)
            return;


        System.out.print(node.key + " ");


        printPreorder(node.left);


        printPreorder(node.right);
    }

     void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();


        q.add(root);


        q.add(null);


         if (!q.isEmpty()) {
             do {

                 Node curr = q.poll();

                 if (curr == null) {
                     if (!q.isEmpty()) {
                         q.add(null);

                     }
                 } else {

                     if (curr.left != null)
                         q.add(curr.left);


                     if (curr.right != null)
                         q.add(curr.right);

                     System.out.print(curr.key + " ");
                 }
             } while (!q.isEmpty());
         }
    }

    void printPostorder()  {
        printPostorder(root);
    }
    void printInorder() {
        printInorder(root);
    }
    void printPreorder()   {
        printPreorder(root);
    }
    void levelOrder(){
        levelOrder(root);
    }

}