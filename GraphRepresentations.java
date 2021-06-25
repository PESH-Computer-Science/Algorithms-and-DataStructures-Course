import java.util.ArrayList;

public class GraphRepresentations {
    public static void main(String[] args) {
        // 1. Edge list
        // from list
        int[] v1 = {0, 0, 1, 1, 2, 3};
        int[] v2 = {1, 2, 2, 4, 3, 4};
        for (int i = 0; i < v1.length; i++) {
//            System.out.println(v1[i] + " to " + v2[i]);
        }

        ArrayList<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 1));
        edgeList.add(new Edge(0, 2));
        edgeList.add(new Edge(1, 2));
        edgeList.add(new Edge(1, 4));
        edgeList.add(new Edge(2, 3));
        edgeList.add(new Edge(3, 4));

        for (Edge edge : edgeList) {
            if (edge.v1 == 2) {
//                System.out.println(edge.v1 + " to " + edge.v2);
            }
        }


        //2. Adjacency Matrix
        int[][] adjMatrix = new int[5][5];
        adjMatrix[0][1] = 1;
        adjMatrix[1][0] = 1;
        adjMatrix[0][2] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[2][3] = 1;
        adjMatrix[3][4] = 1;

        //3. Adjacency Lists
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            adjList.add(new ArrayList<>());
        System.out.println(adjList);
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(2).add(3);
        adjList.get(3).add(4);

        System.out.println(adjList);
        for (int i = 0; i <= 4; i++) {
            System.out.println(i + " is connected to: " + adjList.get(i));
        }
    }

    static class Edge {
        int weight;
        int v1, v2;

        public Edge(int from, int to) {
            v1 = from;
            v2 = to;
        }
    }
}
