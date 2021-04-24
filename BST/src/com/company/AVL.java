package com.company;
/** https://www.geeksforgeeks.org/avl-tree-set-1-insertion/*/

/** source ^ */
public class AVL {

    Time time = new Time();
    static class Node{
        Node left, right;
        int data;
        int height;


        public Node(int n)
        {
            left = null;
            right = null;
            data = n;
            height = 0;
        
    

    private Node root;


    public AVL(int [] list)
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


    public void insert(int data)
    {
        root = insert(data, root);
    }

    private int height(Node t )
    {
        return t == null ? -1 : t.height;
    }
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    private Node insert(int x, Node t)
    {
        if (t == null)
            t = new Node(x);
        else if (x < t.data)
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x < t.left.data )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x > t.data )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x > t.right.data)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }

    private Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }

    private Node doubleWithLeftChild(Node k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }

    private Node doubleWithRightChild(Node k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }






}

