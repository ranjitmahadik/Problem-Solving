#include<bits/stdc++.h>

using namespace std;
vector<int> tree [20];
int dp[21];
void dfs(int src){
    dp[src] = src;
    int maxFromChilds = 0;
    for(int child : tree[src]){
        dfs(child);
        maxFromChilds = max(maxFromChilds,dp[child]);
    }

    dp[src] += maxFromChilds;
}
    /***
     *                          3
     *                2         6           10
     *         1        8       9       11  12  13
     *      4     5             7
     *
     */
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

    memset(dp,0,sizeof(dp));
    dfs(3);
    cout<<dp[3];

    return 0;
}