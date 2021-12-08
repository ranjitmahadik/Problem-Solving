#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

int getKthElementFromSortedArrays(vector<int>& arr1,vector<int>& arr2,int K){
    int n = arr1.size(), m = arr2.size();
    if(n > m)   return getKthElementFromSortedArrays(arr2,arr1,K);

    int lo = 0, hi = min(n,K);
    while (lo <= hi){
        int mid1 = lo + (hi - lo)/2;
        int mid2 = K - mid1;

        int left1 = mid1 <= 0 ? INT_MIN : arr1[mid1-1];
        int left2 = mid2 <= 0 ? INT_MIN : arr2[mid2-1];
        
        int right1 = mid1 >= n ? INT_MAX : arr1[mid1];
        int right2 = mid2 >= m ? INT_MAX : arr2[mid2];

        if(left1 <= right2 && left2 <= right1){
            return max(left1,left2);
        }else if(left1 > right2){
            hi = mid1 - 1;
        }else{
            lo = mid1 + 1;
        }
    }
    return -1;
}


int main(){
    vector<int> arr1 = {1, 3, 4, 7, 10, 12,18,20,25,29,30,35};
    vector<int> arr2 = {2, 3, 6, 15};
    cout<<getKthElementFromSortedArrays(arr1,arr2,9);
    return 0;
}