#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

bool isPossible(vector<int>& arr,const int fixedSum,const int splits){
    int localSplits = 1, sum = 0;
    for(int i=0;i<n;i++){
        sum += arr[i];
        if(sum > fixedSum){
            sum = arr[i];
            localSplits ++;
        }
    }
    return localSplits <= splits;
}

int splitArray(vector<int>& arr,int m){
    int lo = *max_element(arr.begin(),arr.end());
    int hi = accumulate(arr.begin(),arr.end(),0);

    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(isPossible(arr,mid,m))   hi = mid - 1;
        else    lo = mid + 1;
    }
    return hi + 1;
}

int main(){
    vector<int> arr = {7,2,5,10,8};
    int m = 2;
    return 0;
}