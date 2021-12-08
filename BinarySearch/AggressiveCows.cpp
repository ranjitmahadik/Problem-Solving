#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

bool isPossible(vector<int>& arr,const int fixDistance,const int cows){
    int currentCows = 1, currentDistance = arr[0];
    for(int i=1;i<arr.size();i++){
        int tempDistance = arr[i] - currentDistance;
        if(tempDistance >= fixDistance){
            currentDistance = arr[i];
            currentCows ++;
        }
    }
    return currentCows >= cows;
}

int getAggressiveCows(vector<int>& arr,int cows){
    sort(arr.begin(),arr.end());
    int lo = 0, hi = arr[arr.size()-1] - arr[0];

    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(isPossible(arr,mid,cows))    lo = mid + 1;
        else  hi = mid - 1;
    }
    return lo - 1;
}

int main(){
    return 0;
}