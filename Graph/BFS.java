import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

        graph[7].add(new Edge(7, 8));
        graph[7].add(new Edge(7, 9));

        graph[8].add(new Edge(8, 7));
        graph[8].add(new Edge(8, 9));

        graph[9].add(new Edge(9, 8));
        graph[9].add(new Edge(9, 7));

    }

    public static void bfs(ArrayList<Edge> graph[], int v, boolean visted[], int start) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visted[curr]) {
                System.out.print(curr + " ");
                visted[curr] = true;

                // find out neighbours of curr node
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }

    }

    public static void main(String args[]) {
        int v = 10;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean visted[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visted[i] == false) {
                bfs(graph, v, visted, i);
            }
        }

    }

}
