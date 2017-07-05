package com.company;


//Welcome to Davis Data Structures!

//Have you ever had any issues with Trees? Feel like they're the most intimidating of data structures?
//Need a review?
//Well look no further!

//So this is my section of figuring out how to explain Trees, Binary Search Trees, Traversing, and associative
//functions.
//This is to better help me prepare for interviews and is a sort of review. I'm really rusty when it comes ot Trees and
//I'm needing some serious rethinking of how I look at them. I know they're incredibly useful with O nlogn search
//and retrieval when you start getting into Binary Search Tree but let's start with
// BT's for now. As far as sorting goes though, it can take longer but there are some neat tricks, especially when
//you start getting into red and black trees.
//For this, we'll just stick with the basics.

//Part 1 - Nodes
// >>Move on over and open up the TreeNode class to see more

//Part 2 - The Tree (of Nodes)
// >>See below

//Part 3 - Traversing (Moving about the tree)
/*
    1. InOrder Traversing
    2. PreOrder Traversing
    3. PostOrder Traversing


  Part 4 - Binary Search Trees
  >>See the Binary Search Tree class (BST)
 */


import sun.reflect.generics.tree.Tree;

public class BinaryTree {

    private TreeNode root; //here is our root node

    public BinaryTree(){
        TreeNode alpha = new TreeNode(1);
        TreeNode echo = new TreeNode(2);
        TreeNode bravo = new TreeNode(6);
        TreeNode charlie = new TreeNode(3, bravo, null);
        alpha.right = charlie;
        alpha.left = echo;
        TreeNode foxtrot = new TreeNode(4);
        echo.left = foxtrot;
        TreeNode delta = new TreeNode(5);
        echo.right = delta;
        root = alpha;
    }



    /*
    Now that we've added some nodes, let's see what this tree looks like.


                                    Root -->     (1) <---Alpha
                                                /   \
                                Echo --->    (2)    (3)  <---Charlie
                                             / \     /\
                              Foxtrot ---> (4) (5) (6) (null)
                                                ^   ^
                                                |   |
                                            Delta   Bravo


     */
    //------------------------------------------------------------------------------------------------------------

    /*
        Traversals

        The basic idea of traversals is that you move through the tree in a certain fashion. There are three basic ways
        to do this:

            1. InOrder
            2. PreOrder
            3. PostOrder

        Each one has their own strengths and merits. It's important to understand how each one works so you can figure
        out which one best applies to your program.

        These are all recursive methods (which means they call themselves).

        It consists of three parts...

            1. Visit the node (in other words, process the information at that node. This could be printing it out,
            passing in new methods and using the node as an argument, all sorts of things!)

            2. Go left (keep going down to the left half of the subtree until you reach NULL (ie., no more kids because
            you're at the end of the tree, aka. the leaves)

            3. Go right (same as go left but the opposite direction)

        If you get in trouble or confused, take a look at this website to see the graphs and animations for how this works.

        https://en.wikipedia.org/wiki/Tree_traversal#In-order

     */

    private void inOrderTraverse (TreeNode btree){
        if (btree != null){
            inOrderTraverse(btree.left); //recurse to go down all the way to the left
            System.out.print(btree.data + " --- ");  //print out the node
            inOrderTraverse(btree.right);   //go down the right side
        }
    }

    public void inOrder(){
        inOrderTraverse(root);
    } //this is public because the previous inOrderTraverse method
    //is private...we need to able to get to the method but without editing the method

//------------------------------------------------------------------------------------------------------------------


    private void preOrderTraverse(TreeNode btree){
        if(btree != null){
            System.out.print(btree.data + " --- ");  //"visit" or print out the node
            preOrderTraverse(btree.left); //go down the left
            preOrderTraverse(btree.right); //go down the right
        }
    }

    public void preOrder() {
        preOrderTraverse(root);
    }

//------------------------------------------------------------------------------------------------------------------


    private void postOrderTraverse(TreeNode btree){
        if(btree != null){
            postOrderTraverse(btree.left);  //travel down the left subtree
            postOrderTraverse(btree.right);  //travel down the right subtree
            System.out.print(btree.data + " --- ");  //"visit" or in this case print the node data
        }
    }

    public void postOrder(){
        postOrderTraverse(root);
    }

//------------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();
        System.out.println("InOrder Traversal is : " );
        theTree.inOrder();

        System.out.println("\n");

        System.out.println("PreOrder Traversal is : ");
        theTree.preOrder();

        System.out.println("\n");

        System.out.println("PostOrder Traversal is : ");
        theTree.postOrder();


    }
}
