#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;

double getMultiplied(double n, int rootVal){
    double ans = 1.0;
    for(int i=0;i<rootVal;i++)  ans *= n;
    return ans;
}

double nThRoot(double number, int rootVal){
    double lo = 1.0, hi = number, eps = 1e-8;

    while ((hi - lo) > eps){
        double mid = lo + (hi - lo)/2.0;

        if(getMultiplied(mid,rootVal) <= number)    lo = mid;
        else hi = mid;
    }
    
}


int main(){
    db(nThRoot(2,2));
    return 0;
}