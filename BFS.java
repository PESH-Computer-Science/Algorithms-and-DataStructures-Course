import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static ArrayList<ArrayList<Integer>> getAdjacencyList(){
        int n = 7;
        int v1[] = {1, 1, 2, 2, 3, 4, 4, 5};
        int v2[] = {3, 2, 3, 4, 5, 5, 6, 7};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < v1.length; i++){
            adj.get(v1[i]).add(v2[i]);
            adj.get(v2[i]).add(v1[i]);
        }
        return adj;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList();

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.size()];
        // visited[3] = true if we've already been to 3.

        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            System.out.println("Visiting: " + currentVertex);
            for(int neighbor : adj.get(currentVertex)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

    }
}
