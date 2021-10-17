package task3;

import java.util.Scanner;
/**
 *  Implement a java program that stores the graph and checks if there exists an edge
 * between any two nodes (vertices) captured from the user
 * I am going to use an adjacent matrix to solve this problem.
 */
public class FindEdge{
   public static void main(String[] args){
      // Storing the graph of ten nodes in an adjancent matrix which is a multidimessional array.
      int[][] adjancent_matrix = {{0,1,0,1,0,1,0,1,0,1},
                                  {1,0,1,0,1,0,1,0,1,0},
                                  {0,1,0,1,0,1,0,1,0,1},
                                  {1,0,1,0,1,0,1,0,1,0},
                                  {0,1,0,1,0,1,0,1,0,1},
                                  {1,0,1,0,1,0,1,0,1,0},
                                  {0,1,0,1,0,1,0,1,0,1},
                                  {1,0,1,0,1,0,1,0,1,0},
                                  {0,1,0,1,0,1,0,1,0,1},
                                  {1,0,1,0,1,0,1,0,1,0}
                              };
      Scanner scan = new Scanner(System.in);
      int node2;
      int node1;
      while(true){
         System.out.println("Enter the two nodes to determine if there is an edge between them.");
         System.out.print("node1: ");
         node1 = scan.nextInt();

         System.out.print("node2: ");
         node2 = scan.nextInt();
         System.out.println();
         if(getEdge(node1, node2, adjancent_matrix) == 1){
            System.out.println("There is an edge from "+node1+" to "+node2);
         }else{
            System.out.println("There is no edge");
         }

         System.out.print("Enter 'q' to quit ");
         String quit = scan.next();
         if(quit.equals("q")){
            break;
         }
      }
      scan.close();
   }
   /**
    * This method returns an integer at postions of node1 and 2 in the adjacency matrix.
    * @param node2 : int
    * @param node1 : int
    */

    static int getEdge(int node1, int node2, int[][] l/**This is the adjancent matrix */){
       return l[node1-1][node2-1];
    }
}