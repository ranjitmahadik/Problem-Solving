package Graph.Basics;

import java.util.LinkedList;
import java.util.List;

public class RepresentGraph {
    static class Graph {
        List<Integer>[] graph;
        int v;

        public Graph(int v) {
            this.v = v;
            this.graph = new LinkedList[v];
        }

        private void initNode(int u) {
            if (this.graph[u] == null) this.graph[u] = new LinkedList<>();
        }

        public void addEdge(int u, int v) {
            addEdge(u, v, true);
        }

        public void addEdge(int u, int v, boolean isUndirected) {
            this.initNode(u);
            this.graph[u].add(v);
            if (isUndirected) {
                this.initNode(v);
                this.graph[v].add(u);
            }
        }

        public void showGraph() {
            for (int i = 0; i < this.v; i++) {
                int currNode = i;
                System.out.print(currNode + " => ");
                for (int child : this.graph[currNode]) {
                    System.out.print(child + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.showGraph();
    }
}
