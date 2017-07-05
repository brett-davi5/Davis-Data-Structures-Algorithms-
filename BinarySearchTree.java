package com.company;

//Welcome to Davis Data Structures!

import sun.reflect.generics.tree.Tree;

/**
 * Created by Family on 7/4/2017.
 */

/*

Glad you found your way over here to Binary Search Trees.

I think it's important that before you move one we review a few things about Binary Trees.

Basic Ground Rules:
    1. BT's have two kiddo's at maximum (left and right)
    2. Is made up of nodes
    3. Has a "root" at the heart/beginning of the tree


Now we can start looking at BST's (Binary Search Trees). These are slightly different but still interesting to use.
They're actually better to use for searching and retreiving purposes because there's a sort of "order" when
you input information into a BST. This is because of the following:

BST's:
    1. Two kiddos (left and right)
    2. All kiddos on the left are less than the parent
    3. All kiddos on the right are greater than the parent
    4. Root is considered a parent (so remember that this creates a sort of "waterfall" sorting effect - see the tree
    below to see what I mean


    Now that we've added some nodes, let's see what this tree looks like.


                                    Root -->     (4) <---Alpha
                                                /   \
                                Echo --->    (2)    (6)  <---Charlie
                                             / \     /\
                              Foxtrot ---> (1) (3) (5) (7)  <-- Gulf
                                                ^   ^
                                                |   |
                                            Delta   Bravo

    Notice the left subtree: 2 -- 1 -- 3
        1.    1 (left) is less than 2 (parent)
        2.    3 (right) is greater than 2 (parent)
    Notice the top subtree: 4 -- 2 -- 6
        1.    2 (left) is less than 4 (parent)
        2.    6 (right) is greater than 4 (parent)

Now I would recommend you take a look at the traversals again to get a new, awesome appreciation and respect for BST's.


 */


public class BinarySearchTree {

    private TreeNode root; //our root :D

    public BinarySearchTree(){
        //gonna build this tree from bottom to top but it reflects the tree drawn above
        //notice that we are manually building this tree
        //this means we already know where we will put certain nodes within the tree
        //this can take a lot of time and there are better ways to do this but for now, this'll work!
        TreeNode delta = new TreeNode(3);
        TreeNode foxtrot = new TreeNode(1);
        TreeNode echo = new TreeNode(2, foxtrot, delta);
        TreeNode bravo = new TreeNode(5);
        TreeNode gulf = new TreeNode(7);
        TreeNode charlie = new TreeNode(6, bravo, gulf);
        TreeNode alpha = new TreeNode(4, echo, charlie);
        root = alpha;
    }

    /* --------------------------------------------------------------------------------------------------------------

    Notice the differences and the awesomeness of BST's and the traversals...

    ***Note: All three traversals actually stay the same!

    1. InOrderTraverse will now output the information from the BST in proper numerical order of least to greatest.
        Now can you understand the power and fast access and search of a BST? When you have stuff in order, going to find
        something is very rapid. It's almost like building a data structure with Binary Search built it (if you don't know
        binary search, stop now and go review the code in Davis Data Structures. It'll really help you appreciate BST's).

    2. PreOrderTraverse will now do a great job of showing how PreOrder basically works. It's a sort of top to bottom &
        left to right approach to searching for an item in the BST. Think of it this way...if you need to look for
        something in a BST and you want to start with the root, PreOrder is the way to go!

    3. PostOrder Traverse does the same as above, a great representation of just how this traversal works and it's
        benefits. This is a great searching/retreival method if you want to start with the leaves of the BST first
        and then work your way up the tree.

     */

    private void inOrderTraverse (TreeNode btree){
        if (btree != null){
            inOrderTraverse(btree.left); //recurse to go down all the way to the left
            System.out.print(btree.data + " --- ");  //print out the node
            inOrderTraverse(btree.right);   //go down the right side
        }
    }

    public void inOrder() {
        inOrderTraverse(root);
    }

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
//----------------------------------------------------------------------------------------------------------------

/*
    Now let's take a look at adding and removing nodes from a tree.


 */

    public void add(int data){
        add(data, root);
    }

    private TreeNode add(int x, TreeNode bSTree){

        if(bSTree == null){ //if the tree is empty! here is a great way to start building from a blank tree and/or how
            //we keep adding values down the left and right of the tree
            return new TreeNode(x);
        }

        if(x < bSTree.data){ //if the value is less than the parent
            bSTree.left = add(x, bSTree.left); //notice this is recursive and moves to the left
        }else{ //if the value is greater than the parent
            bSTree.right = add(x, bSTree.right); //recursive and moves to the right
        }
        return bSTree;

    }


    //Now let's look at how to remove values from the tree. This can get a little tricky!
    /*

    Because removing nodes can start to alter the shape and idea of the tree, let's take a look at three important
    test cases for removing nodes. The first two are easy to grasp, the third being the most challenging but not too
    difficult once you see it in action!

    1. The node you're removing has NO children. Remove the node by setting the reference to it in it's parent node
    to null.

    2. The node you're removing has ONE child. Remove the node and promote the child of the node to take the place
    of its parent in the tree.

    3. The node you're removing has TWO children (this is the tricky one). Remove the node and replace it with the
    largest node in its left subtree. This way things still stay in order without having to move THE ENTIRE remaining
    nodes of the tree. :)

     */

    public void deleteKey(int key){ //key is the value we wish to delete from the BST
        root = deleteTreeNode(root, key);
    }

    private TreeNode deleteTreeNode(TreeNode root, int key){
        if(root == null){ //if the tree is empty
            return root;
        }

        //looking for the key

        if(key < root.data){ //if less than the root, go left
            root.left = deleteTreeNode(root.left, key); //recursive to the left node of the subtree
        }else if(key > root.data){ //if greater than the root, go right
            root.right = deleteTreeNode(root.right, key); //recursive to the right node of the subtree
        }else{ //if the key to be deleted is at the root...which means we found it
            //now we check to see how many kids it has...(like the scenarios listed above
            if(root.left == null){//if no left child...
                return root.right; //return the right child
            }else if(root.right == null){ //if no right child...
                return root.left;//return the left child
            }
            //node with two kiddo's
            root.data = minValue(root.right); //get the "inOrder" successor (ie. the smallest in the right subtree)
            root.right = deleteTreeNode(root.right, root.data);//delete the "inOrder" successor
        }
        return root;
    }

    private int minValue(TreeNode root){ //here is where we find the "inOrder" successor
        int minValue = root.data;
        while(root.left != null){ //go to the smallest, lowest value on the subtree ...to the left
            minValue = root.left.data; //copy over the value
            root = root.left; //move the node down to the left of the subtree..seeking the last one (because it'll be
            //equal to null
        }
        return minValue;
    }


//----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){

        BinarySearchTree bstTree = new BinarySearchTree();

        System.out.println("InOrder Traversal: ");
        bstTree.inOrder();

        System.out.println("\n");

        System.out.println("PreOrder Traversal: ");
        bstTree.preOrder();

        System.out.println("\n");

        System.out.println("PostOrder Traversal: ");
        bstTree.postOrder();

        System.out.println("\n");

        //Add a value to the tree

        System.out.println("Adding value 8");
        System.out.println("\n");

        bstTree.add(8);
        System.out.println("New BSTree - InOrder Traversal");

        bstTree.inOrder();

        System.out.println("\n");

        //Remove a value from the tree
        System.out.println("Removing value 2");
        bstTree.deleteKey(2);

        System.out.println("\n");

        System.out.println("New BSTree - InOrder Traversal");
        bstTree.inOrder();

    }


}
