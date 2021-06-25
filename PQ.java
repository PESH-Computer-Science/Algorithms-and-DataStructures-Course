import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(5);
//        pq.add(3);
//        pq.add(10);
//        pq.add(1);
//        pq.add(2);
//        while(!pq.isEmpty())
//            System.out.println(pq.poll());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 4, 5));
        pq.add(new Edge(1, 2, 2));
        pq.add(new Edge(3, 2, 10));
        pq.add(new Edge(3, 9, 9));
        pq.add(new Edge(1, 3, 3));
        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
    static class Edge implements Comparable<Edge>{
        int weight, v1, v2;
        public Edge(int a, int b, int c){
            v1 = a; v2 = b; weight = c;
        }
        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
        public String toString(){
            return v1 + " to " + v2 + " with weight " + weight;
        }
    }
}
