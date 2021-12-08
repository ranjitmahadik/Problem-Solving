#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

bool isPossible(vector<int>& arr,int maxPageLimit,int students){
    int localStudents = 1, currentPages = 0;
    for(int i=0;i<arr.size();i++){
        currentPages += arr[i];
        if(currentPages > maxPageLimit){
            currentPages = arr[i];
            localStudents ++;
        }
        if(localStudents > students)    return false;
    }
    return true;
}

int allocateBooks(vector<int>& arr,int K){
    int lo = *max_element(arr.begin(),arr.end());
    int hi = accumulate(arr.begin(),arr.end(),0);

    while (lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(isPossible(arr,mid,K))   hi = mid - 1;
        else lo = mid + 1;
    }
    return hi + 1;
}



int main(){
    vector<int> arr = {10,20,30,40};
    int K = 2;
    db(allocateBooks(arr,K));
    return 0;
}