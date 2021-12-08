#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

using matrix = vector<vector<int>>;


int getUpperBound(vector<int> arr,int key){
    int lo = 0, hi = arr.size()-1;
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;
        if(arr[mid] > key)   hi = mid - 1;
        else    lo = mid + 1;
    }
    return hi + 1;
}

// overall time complexity is : (C*n*log(m))    where C is constant.
int getMedian(matrix arr){
    int n = arr.size(), m = arr[0].size();

    int fixedLimit = (n*m+1)/2;

    int lo = 0, hi = 1e9;   // we can store max value in hi but that will take extra o(n*m) time/
    while(lo <= hi){
        int mid = lo + (hi - lo)/2;     // mid is the possible median value

        int smallerNumbers = 0;
        for(int i=0;i<n;i++){
            // smallerNumbers += upper_bound(arr[i].begin(),arr[i].end(),mid);
            smallerNumbers += getUpperBound(arr[i],mid);
        }

        if(smallerNumbers >= fixedLimit)    hi = mid - 1;
        else    lo = mid + 1;
    }

    return hi + 1;
}



int main(){
    matrix arr = {{1, 3, 6}, {2, 6, 9}, {3, 6, 9}};
    int ans = getMedian(arr);
    cout<<ans;
    return 0;
}