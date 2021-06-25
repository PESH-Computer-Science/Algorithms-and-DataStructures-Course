import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDistance {
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
        int distances[] = new int[adj.size()];

        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.println("At vertex " + vertex + " distance " + distances[vertex]);
            for(int neighbor : adj.get(vertex)){
                if(!visited[neighbor]){
                    distances[neighbor] = distances[vertex] + 1;
                    if(distances[neighbor] == 2){
                        System.out.println("Suggestion for you: " + neighbor);
                    }else if (distances[neighbor] < 2){
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
