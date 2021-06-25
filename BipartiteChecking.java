import java.util.ArrayList;

public class BipartiteChecking {
    static ArrayList<ArrayList<Integer>> getAdjacencyList(){
        int n = 7;
        int v1[] = {1, 1, 2, 3, 4, 5};
        int v2[] = {3, 2, 4, 5, 6, 7};
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
    static ArrayList<ArrayList<Integer>> adj;
    static boolean visited[];
    static int colors[];
//    1 = green. 2 = red
    static boolean dfs(int vertex, int color){
        visited[vertex] = true;
        colors[vertex] = color;

        for(int neighbor: adj.get(vertex)){
            // visited the neighbor --> Check the neighbor's color
            if(visited[neighbor]){
                if(colors[neighbor] == colors[vertex])
                    return false;
            }else{
                int newColor = 1;
                if(color == 1)
                    newColor = 2;
                // dfs returns whether there are any discrepancies.
                boolean result = dfs(neighbor, newColor);
                if(result == false)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        adj = getAdjacencyList();
        visited = new boolean[adj.size()];
        colors = new int[adj.size()];

        boolean isBipartite = dfs(1, 1);
        System.out.println("The graph is: " + (isBipartite ? "bipartite" : "not bipartite"));
    }
}
