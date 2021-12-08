#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;


int getPeak(vector<int>& arr){
    int lo = 0, hi = arr.size()-1;
    if(lo == hi)    return 0;
    
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;

        if(arr[mid] > arr[mid+1]){
            hi = mid - 1;            
        }else{
            lo = mid + 1;
        }
    }
    return hi + 1;
}


int main(){
    vector<int> arr = {2,4,10,25,20};
    db(getPeak(arr));
    return 0;
}