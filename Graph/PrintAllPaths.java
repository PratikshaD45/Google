import java.util.*;

public class PrintAllPaths {
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

    //Time-> O(v^v)

    public static void printAllpath(ArrayList<Edge> graph[], boolean visted[], int curr, String path, int tar) {
        // base case
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visted[e.dest]) {
                visted[curr] = true;
                printAllpath(graph, visted, e.dest, path + e.dest, tar);
                visted[curr] = false;
            }

        }

    }

    public static void main(String args[]) {
        int v = 10;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        int tar = 5;
        printAllpath(graph, new boolean[v], src, "0", tar);

    }

}
