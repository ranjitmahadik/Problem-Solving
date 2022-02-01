package Graph.Basics;

import util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {

    private static void bfs(Traversals.Graph g, int src, int n) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(src, 0));
        boolean[] vis = new boolean[n + 1];
        vis[src] = true;

        while (!q.isEmpty()) {
            int parentNode = q.peek().getFirst();
            int noOfDiceThrown = q.peek().getSecond();
            q.poll();

            if (parentNode == n) {
                System.out.println("Reached at end in " + noOfDiceThrown + "dice throws.");
                break;
            }

            for (int child : g.graph[parentNode]) {
                if (vis[child]) continue;
                vis[child] = true;
                q.offer(new Pair<>(child, noOfDiceThrown + 1));
            }
        }


    }

    private static void minDiceRequiredToReachDest(int n, ArrayList<Pair<Integer, Integer>> snakes, ArrayList<Pair<Integer, Integer>> ladders) {
        int[] board = new int[n + 1];
        for (int i = 0; i < snakes.size(); i++) {
            int start = snakes.get(i).getFirst();
            int end = snakes.get(i).getSecond();
            board[start] = end - start;
        }

        for (int i = 0; i < ladders.size(); i++) {
            int start = ladders.get(i).getFirst();
            int end = ladders.get(i).getSecond();
            board[end] = end - start;
        }

        Traversals.Graph g = new Traversals.Graph(n + 1);
        for (int i = 1; i < n; i++) {
            for (int dice = 1; dice < 7; dice++) {
                int v = i + dice;
                if (v <= n) {
                    v += board[v];
                    if (v <= n)
                        g.addEdge(i, v, false);
                }
            }
        }
        bfs(g, 1, n);

    }

    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> snakes = new ArrayList<>();
        snakes.add(new Pair<>(17, 4));
        snakes.add(new Pair<>(24, 16));
        snakes.add(new Pair<>(34, 12));
        snakes.add(new Pair<>(32, 30));

        ArrayList<Pair<Integer, Integer>> ladders = new ArrayList<>();
        ladders.add(new Pair<>(2, 15));
        ladders.add(new Pair<>(5, 7));
        ladders.add(new Pair<>(9, 27));
        ladders.add(new Pair<>(25, 35));
        ladders.add(new Pair<>(18, 29));

        minDiceRequiredToReachDest(36, snakes, ladders);


    }
}
