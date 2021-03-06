/**
 * Created by HABDOLLA on 1/13/2016.
 */


public class App {
    //final static private String EASY = "134862705";
    
     final static private String EASY = "fade0bgch";
     
   final static private String MEDIUM = "ag0dcefbh";
   // final static private String MEDIUM = "281043765";
   
    //final static private String HARD = "567408321";
      final static private String HARD = "dabgcef0h";
    
   final static private String GOAL_STATE = "abcde0fgh";
    
 // final static private String GOAL_STATE = "123804765";



    public static void main(String[] args) {
        String rootState = HARD;
        long startTime = System.currentTimeMillis();

        SearchTree search = new SearchTree(new Node(rootState), GOAL_STATE);
        /*Algoritmo DFS*/
       // search.depthFirstSearch();
        System.out.println("----------------------------------------------");
        /*Algoritmo BFS*/
        search.bestFirstSearch();
        System.out.println("----------------------------------------------");
        /*Algoritmo Iterative deeping*/
       // search.iterativeDeepening(depthLimit);
        System.out.println("----------------------------------------------");
        /*Algoritmo costo uniforme*/
        search.uniformCostSearch();
        System.out.println("----------------------------------------------");
        /*Algoritmo de A**/
        search.aStar(Heuristic.H_ONE);
        System.out.println("----------------------------------------------");
        
        

        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("Time  :" + totalTime);


    }
}
