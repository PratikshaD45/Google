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
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));
        graph[1].add(new Edge(1, 3));

    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean visted[], int curr, boolean recStack[]) {
        visted[curr] = true;
        recStack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest]) { // cycle found
                return true;
            } else if (!visted[e.dest]) {
                if (isCycle(graph, visted, e.dest, recStack)) {
                    return true;
                }
            }

        }
        recStack[curr] = false;
        return false;

    }

    public static void main(String args[]) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(isCycle(graph, new boolean[v], 0, new boolean[v]));

    }

}
