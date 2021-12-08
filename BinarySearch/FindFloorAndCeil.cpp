#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;


int getFloor(vector<int>& arr,int x){
    int lo = 0, hi = arr.size()-1;
    
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;

        if(arr[mid] == x)   return mid;
        else if(arr[mid] > x)    hi = mid - 1;
        else   lo = mid + 1;


        /*
            else if(arr[mid] < x)   lo = mid + 1;
            else hi = mid + 1;
            }
            return lo - 1; 
        */
    }
    return hi;
}

int getCeil(vector<int>& arr,int x){
    int lo = 0, hi = arr.size()-1;
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;

        if(arr[mid] == x)   return mid;
        else if(arr[mid] < x)   lo = mid + 1;
        else hi = mid - 1;
    }
    return lo;
}


int main(){
    vector<int> arr = {1,2,8,10,11,12,19};
    int x = 0;
    db(getFloor(arr,x));
    return 0;
}