/*
Balanced Tree

When using a tree data structure, it's common for the tree to become unbalanced over time due to the insertion order of nodes, which can in turn 
affect the performance of our programs. Let's define a balanced tree as one where the difference in height of the left and right subtrees is at most one,
for all nodes in the given tree. Write a function is_balanced(node) that determines whether a binary tree is balanced or not.

Input: The root node of a binary tree

Output: True if the tree is balanced, False otherwise.

Assume you are given the root node of a tree that conforms to the following interface:

class Node {
  left: Node
  right: Node
  height: int
}
Examples
Example 1: Balanced

      a
     / \
    b   c
   / \   \
  d   e   f

is_balanced(a) # => True
Example 2: Balanced

     a
    / \
   b   c
        \
         d

is_balanced(a) # => True
Example 3: Not Balanced

     a
    / \
   b   c
        \
         d
          \
           e

is_balanced(a) # => False
Example 4: Not Balanced

      a
     / \
    b   c
   /     \
  d       e
 /         \
f           g

is_balanced(a) # => False
Note that while the last tree seems symmetrical, it is not balanced because nodes b and c are not balanced.

*/

import java.util.*;
import java.io.*;

public class MyClass {
    public static boolean is_balanced(Node rootNode){
        if(rootNode = null) return true;
        
        int l_height = get_height(rootNode.left);
        int r_height = get_height(rootNode.right);
        int height_diff = Math.abs(l.height - r.height);
        
        if(height_diff > 1){
            return false;
        }
        return is_balanced(rootNode.left) && is_balanced(rootNode.right);
    
    }
    public static int get_height(Node rootNode){
        if(rootNode == null) return 0;
        
        int l_height = get_height(node.left);
        int r_height = get_height(node.right);
        
        return max(l_height, r_height) + 1;
    }
    public static void main(String args[]) {
      
    }
}
