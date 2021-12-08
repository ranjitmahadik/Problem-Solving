#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

int getFirstOccurrence(vector<int>& arr, int target){
    int lo = 0, hi = arr.size()-1, ans = -1;
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(arr[mid] == target){
            ans = mid;
            hi = mid - 1;
        }else if(arr[mid] > target){
            lo = mid + 1;
        }else{
            hi = mid - 1;
        }
    }
    return ans;
}


int getLastOccurrence(vector<int>& arr, int target){
    int lo = 0, hi = arr.size()-1, ans = -1;
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(arr[mid] == target){
            ans = mid;
            lo = mid + 1;
        }else if(arr[mid] > target){
            lo = mid + 1;
        }else{
            hi = mid - 1;
        }
    }
    return ans;
}



signed main(){
    vector<int> arr = {1,2,3,4,5,6,6,6,6,7,9,10};
    int target = 6;
    int firstOccurrence = getFirstOccurrence(arr,target);
    int lastOccurrence = getLastOccurrence(arr,target);
    db(firstOccurrence);
    db(lastOccurrence)
    return 0;
}