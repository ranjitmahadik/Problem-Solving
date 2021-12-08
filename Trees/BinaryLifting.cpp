#include<bits/stdc++.h>
using namespace std;
auto parent;
vector<int> tree[20];
auto lvl;
int logOfTree = -1;
    /***
     *                          3
     *                2         6           10
     *         1        8       9       11  12  13
     *      4     5             7
     *
     */

void buildTable(int src,int par){
    parent[src][0] = par;

    for(int i=1;i<logOfTree;i++){
        parent[src][i] = parent[parent[src][i-1]][i-1];
    }
    for(int child : tree[src]){
        buildTable(child,src);
        lvl[child] = lvl[par] + 1;
    }
}

int query(int t1,int t2){
    if(t1 == t2)    return t1;
    else if(lvl[t1] > lvl[t2])    return query(t2,t1);

    while(lvl[t1] != lvl[t2]){
        t2 = parent[t2][0];
    }

    if(t2 == t1)    return t2;

    while(t1 != t2){
        t2 = parent[t2][0];
        t1 = parent[t1][0];
    }
    return t1;
}

int optimalQuery(int u,int v){
    if(u == v)  return v;
    else if(lvl[u] > lvl[v])    return optimalQuery(v,u);

    int diff = lvl[v] - lvl[u];

    for(int i=logOfTree;i>=0;i--){
        if(diff & (1 << i)){
            v = parent[v][i];
        }
    }

    if(u == v)  return v;

    for (int i = logOfTree; i >= 0; i--) {
        if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
        }
    }

    return v;
}

int main(){
    tree[3].push_back(2);
    tree[3].push_back(6);
    tree[3].push_back(10);

    tree[2].push_back(1);
    tree[2].push_back(8);

    tree[1].push_back(4);
    tree[1].push_back(5);

    tree[6].push_back(9);
    tree[6].push_back(7);

    tree[10].push_back(11);
    tree[10].push_back(12);
    tree[10].push_back(13);

    logOfTree = (log(13)/log(2) )+ 1;
    parent = new int[20][logOfTree];
    lvl = new int[20];
    for(int i=0;i<20;i++){
        for(int j=0;j<logOfTree;j++){
            parent[i][j] = 0;
        }
    }
    lvl[3] = 0;
    buildTable(3);
    query(4,8);
    return 0;
}