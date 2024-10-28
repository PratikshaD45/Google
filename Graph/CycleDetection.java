import java.util.*;

public class CycleDetection {
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
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 2));

    }

    // for directed graph -> recursive stack approach
    public static boolean isCycleD(ArrayList<Edge> graph[], boolean visted[], int curr, boolean recStack[]) {
        visted[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest]) { // cycle found
                return true;
            } else if (!visted[e.dest]) {
                if (isCycleD(graph, visted, e.dest, recStack)) {
                    return true;
                }
            }

        }
        recStack[curr] = false;
        return false;

    }

    // cycle detection for undirected graphs
    public static boolean isCycleU(ArrayList<Edge> graph[], int curr, boolean visted[], int parent) {
        visted[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (visted[e.dest] == true && parent != e.dest) { // cycle exist
                return true;
            } else if (!visted[e.dest]) {
                if (isCycleU(graph, e.dest, visted, curr)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        // System.out.println(isCycle(graph, new boolean[v], 0, new boolean[v]));
        System.out.println(isCycleU(graph, 0, new boolean[v], -1));

    }

}
