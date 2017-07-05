package com.company;

//Welcome to Davis Data Structures!


/**
 * Created by Family on 7/3/2017.
 */

//Glad you found the TreeNode section! Let's take a look!
    /* What you need to know is that a Tree is made up of nodes connected together similar to that like a
    linked list.

    The top node of the tree is called the root. A binary tree is composed of nodes and each node never has more than
    two children (hence the term Binary - 0 and 1 ). A node in a tree without children are known as leaves (or leaf for
    singular purposes). Each node usually is known as a parent to left and right children.

    Let's take a look!

    */

public class TreeNode {

    int data; //here is the data we'll store for each node ...you can use objects, primitive data types, etc. LOTS of options :)

    TreeNode left;   //the kiddo's!
    TreeNode right;     //notice that these are the same types as the class we are defining
                        //these are recursive objects!
                        // these are also references to the data (like addresses to a house)
                        // these are not the data nodes themselves (going to the house versus actually being at the house)

    TreeNode(int data){  //constructor #1 - used for making new nodes with only a stored value
        this.data = data;
        left = null;
        right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right){ //constructor #2 - used for making new nodes and knowing
        //who you want the children to be
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

/*
    So this will pretty much do it for TreeNodes. Let's start looking at the different ways to move through a tree.
    This is known as traversing.
    Open up the InOrderTraversing class to take a look.

 */
