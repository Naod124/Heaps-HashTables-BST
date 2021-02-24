package com.company;

/** https://www.sanfoundry.com/java-program-implement-red-black-tree/*/
/** source ^ */
public class RedBlackTree {


    static class RedBlackNode{
        RedBlackNode left, right;
        int element;
        int color;

        public RedBlackNode(int theElement)
        {
            this( theElement, null, null );
        }
        public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
        {
            left = lt;
            right = rt;
            element = theElement;
            color = 1;
        }
    }

    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private static RedBlackNode nullNode;
    Time time = new Time();
    static
    {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    static final int BLACK = 1;
    static final int RED   = 0;

    public RedBlackTree(int maxSize, int [] list)
    {
        header = new RedBlackNode(maxSize);
        header.left = nullNode;
        header.right = nullNode;

        time.startTimer();
        for (int i = 0; i <list.length; i++) {

            insert(list[i]);
        }
        time.stopTimer();
        long totalTime = time.getTime();

        // for numbers in file inputs
        System.out.println("Size : "+ list.length + " & total time is " + time.toString(totalTime));


    }

    public void insert(int item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
        {
            great = grand;
            grand = parent;
            parent = current;
            current = item < current.element ? current.left : current.right;
            // Check if two red children and fix if so
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        if (current != nullNode)
            return;
        current = new RedBlackNode(item, nullNode, nullNode);
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }
    private void handleReorient(int item)
    {
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        switch (parent.color) {
            case RED -> {
                grand.color = RED;
                if (item < grand.element != item < parent.element)
                    parent = rotate(item, grand);  // Start dbl rotate
                current = rotate(item, great);
                current.color = BLACK;
            }
        }
        header.right.color = BLACK;
    }
    private RedBlackNode rotate(int item, RedBlackNode parent)
    {
        if(item < parent.element)
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
        else
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
    }
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
    {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    private RedBlackNode rotateWithRightChild(RedBlackNode k1)
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }


    public void inorder()
    {
        inorder(header.right);
    }
    private void inorder(RedBlackNode r)
    {
        if (r != nullNode)
        {
            inorder(r.left);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            inorder(r.right);
        }
    }
}




