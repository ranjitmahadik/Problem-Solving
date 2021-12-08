#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

int getUniqueElement(vector<int>& arr){
    int lo = 0, hi = arr.size()-2;
    while (lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(arr[mid] == arr[mid ^ 1])    lo = mid + 1;
        else    hi = mid - 1;
    }
    return arr[lo];
}


int main(){
    vector<int> arr = {1,1,2,3,3,4,4,5,5};
    cout<<getUniqueElement(arr);
    return 0;
}