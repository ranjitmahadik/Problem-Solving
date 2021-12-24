package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {
    /**
     * Approach 1: is to calculate height for each node u.
     * and store all the heights and return nodes with min height.
     * <p>
     * Approach 2: we don't have to calculate height for each node u.
     * we just calculate height for node u and while calculating the height
     * of node u store all other node's height.
     * and use stored height to figure out rest others node height
     * without actually calling the height method for each node.
     */

    List<Integer>[] tree;
    int[] in;
    int[] out;

    private void dfs1(int src,int par){
        in[src] = 0;
        for(int child : tree[src]){
            if(child != par){
                dfs1(child,src);
                in[src] = Math.max(in[src],1 + in[child]);
            }
        }
    }

    private void dfs2(int src,int par){
        int max1 = -1,max2 = -1;
        for(int child : tree[src]){
            if(child != par){
                if(in[child] >= max1){
                    max2 = max1;
                    max1 = in[child];
                }else if(in[child] > max2){
                    max2 = in[child];
                }
            }
        }

        for(int child : tree[src]){
            if(child != par){
                int using = max1;
                if(using == in[child]){
                    using = max2;
                }

                out[child] = Math.max(out[src] + 1, using + 2);
                dfs2(child,src);
            }
        }

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        tree = new ArrayList[n];
        in = new int[n];
        out = new int[n];
        for(int i=0;i<n;i++)    tree[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs1(0,-1);
        dfs2(0,-1);

        Map<Integer,List<Integer>> ans = new HashMap();
        for(int i=0;i<n;i++){
            int minItem = Math.max(in[i],out[i]);
            ans.computeIfAbsent(minItem, x -> new ArrayList<>()).add(i);
        }

        int minSize = Integer.MAX_VALUE;
        int count = minSize;
        for(Map.Entry<Integer, List<Integer>> mp : ans.entrySet()){
            if(mp.getKey() < minSize){
                minSize = mp.getKey();
            }
        }
        if(minSize != count)  return ans.get(minSize);

        return new ArrayList<>();
    }
}
