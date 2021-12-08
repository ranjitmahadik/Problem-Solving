#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;


// log ( min(m,m))
int getMedian(vector<int>& arr1,vector<int>& arr2){
    int n = arr1.size(), m = arr2.size();
    if(n > m)   return getMedian(arr2,arr1);

    int totalNumbers = (n + m + 1)/2;

    int lo = 0, hi = n;
    while (lo <= hi){
        int mid1 = lo + (hi - lo)/2;
        int mid2 = totalNumbers - mid1;

        int left1 = mid1 == 0 ? INT_MIN : arr1[mid1-1];
        int left2 = mid2 == 0 ? INT_MIN : arr2[mid2-1];

        int right1 = mid1 == n ? INT_MAX : arr1[mid1];
        int right2 = mid2 == m ? INT_MAX : arr2[mid2];

        if(left1 <= right2 && left2 <= right1){
            if((m+n)%2 == 0){
                return (max(left1,left2) + min(right1,right2))/2.0;
            }else{
                return max(left1,left2);
            }
        }else if(left1 > right2){
            hi = mid1 - 1;
        }else{
            lo = mid1 + 1;
        }
    }
    return -1;
}


// C*(log(n) + log(m))
int getMedian(vector<int>& arr1,vector<int>& arr2){
    int lo = 0, hi = 1e9;
    int n = arr1.size();
    int m = arr2.size();
    int limit = (n+m+1)/2;
    while(lo <= hi){
        int mid = lo + (hi-lo)/2;

        int totalNumbers = 0;

        totalNumbers += upper_bound(arr1.begin(),arr1.end(),mid) - arr1.begin();
        totalNumbers += upper_bound(arr2.begin(),arr2.end(),mid) - arr2.begin();

        if(totalNumbers >= limit)   hi = mid - 1;
        else lo = mid + 1;
    }
    return hi + 1;
}

int main(){
    vector<int> arr1 = {1, 3, 4, 7, 10, 12};
    vector<int>  arr2 = {2, 3, 6, 15};
    cout<<getMedian(arr1,arr2);
    return 0;
}