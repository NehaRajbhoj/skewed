package com.greatlearning.practice;



//Class of the node
class Node
{
 int val;
 Node left, right;
 
 // Helper function that allocates a new node
 // with the given data and NULL left and right
 // pointers.
 Node(int item)
 {
     val = item;
     left = right = null;
 }
}
class GFG
{
 public static Node node;
 static Node prevNode = null;
 static Node headNode = null;

 // Function to flatten the binary
 // search tree into a skewed tree in
 //  decreasing order
 static void flattenBTToSkewed(Node root)
             
 {
    
     // Base Case
     if(root == null)
     {
         return;
     }
    
     
         flattenBTToSkewed(root.left);
     
     Node rightNode = root.right;
     
    
     // Condition to check if the root Node
     // of the skewed tree is not defined
     if(headNode == null)
     {
         headNode = root;
         root.left = null;
         prevNode = root;
     }
     else
     {
         prevNode.right = root;
         root.left = null;
         prevNode = root;
     }
    
    
     
         flattenBTToSkewed(rightNode);
     
 }

 // Function to traverse the right
 // skewed tree using recursion
 static void traverseRightSkewed(Node root)
 {
     if(root == null)
     {
         return;
     }
     System.out.print(root.val + " ");
     traverseRightSkewed(root.right);       
 }

 // Driver Code
 public static void main (String[] args)
 {
    new GFG();
     GFG.node = new Node(5);
     GFG.node.left = new Node(3);
     GFG.node.right = new Node(6);
         
     flattenBTToSkewed(node);
     traverseRightSkewed(headNode);
 }
}