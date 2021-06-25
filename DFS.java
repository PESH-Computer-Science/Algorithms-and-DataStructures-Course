import java.util.ArrayList;

public class DFS {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean visited[];
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

    static void dfs(int vertex, int depth){
        visited[vertex] = true;
        for(int i = 0; i <= depth; i++)
            System.out.print(" ");
        System.out.println("Visiting " + vertex);
        for(int neighbor: adj.get(vertex))
            if(!visited[neighbor])
                dfs(neighbor, depth + 1);
    }

    public static void main(String[] args) {
        adj = getAdjacencyList();
        visited = new boolean[adj.size()];

        dfs(1, 0);
    }
}
