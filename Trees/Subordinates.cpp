#include<bits/stdc++.h>
using namespace std;

vector<int> arr[200005];
vector<int> ans;

void dfs(int src,int par){
    int subs = 0;
    for(int child : arr[src]){
        if(child != par){
            dfs(child,src);
            subs += (1 + ans[child]);
        }
    }
    ans[src] = subs;
}

int main(){
    int n;
    cin>>n;
    ans.resize(n+1,0);
    for(int i=2;i<=n;i++){
        int x;
        cin>>x;
        arr[i].push_back(x);
        arr[x].push_back(i);
    }
    dfs(1,0);
    for(int i=1;i<=n;i++)   cout<<ans[i]<<" ";
    return 0;
}