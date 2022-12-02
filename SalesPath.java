/*
Sales Path

The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily binary). The root is the company itself, and every node in the tree represents a car distributor that receives cars from the parent node and ships them to its children nodes. The leaf nodes are car dealerships that sell cars direct to consumers. In addition, every node holds an integer that is the cost of shipping a car to it.

Take for example the tree below:

(https://www.pramp.com/img/content/img_01.png)

A path from Honda’s factory to a car dealership, which is a path from the root to a leaf in the tree, is called a Sales Path. The cost of a Sales Path is the sum of the costs for every node in the path. For example, in the tree above one Sales Path is 0→3→0→10, and its cost is 13 (0+3+0+10).

Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.

Implement your function in the most efficient manner and analyze its time and space complexities.

For example:

Given the rootNode of the tree in diagram above

Your function would return:

7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)
*/

  public class SalesPath {
      static class Node {
      
         int cost;
         Node[] children;
         Node parent;

         Node(int cost) {
         this.cost = cost;
         children = null;
         parent = null;
    }
  }
      public static int getCheapestCost(Node rootNode) {
         int n = (rootNode.children != null) ? rootNode.children.length : 0;
          
         if(n == 0){
             return rootNode.cost;
         }
         else{
             int minCost = Integer.MAX_VALUE;
             for(int i=0; i < rootNode.children.length; i++){
                 int curCost = getCheapestCost(rootNode.children[i]);
                 minCost = Math.min(minCost, curCost);
             }
             return minCost + rootNode.cost;
         }
              
      }
  
    public static void main(String args[]) {
        Node node = new Node(0);
        node.children = new Node[3];
        node.children[0] = new Node(5);
        node.children[1] = new Node(3);
        node.children[2] = new Node(6);

        node.children[0].children = new Node[1];
        node.children[0].children[0] = new Node(4);

        node.children[1].children = new Node[2];
        node.children[1].children[0] = new Node(2);
        node.children[1].children[1] = new Node(0);

        node.children[2].children = new Node[2];
        node.children[2].children[0] = new Node(1);
        node.children[2].children[1] = new Node(5);


        node.children[1].children[0].children = new Node[1];
        node.children[1].children[0].children[0] = new Node(1);

        node.children[1].children[1].children = new Node[1];
        node.children[1].children[1].children[0] = new Node(10);

        node.children[1].children[0].children[0].children = new Node[1];
        node.children[1].children[0].children[0].children[0] = new Node(1);

        System.out.println("Min Cost: " + SalesPath.getCheapestCost(node));
    }
}
