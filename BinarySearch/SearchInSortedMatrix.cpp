#include<bits/stdc++.h>
#define db(X)   cout<<#X<<" "<<X<<endl; 

using namespace std;


void searchInMatrix(vector<vector<int>>& mat, int target){
    int i = 0, j = mat[0].size()-1;
    while(i < mat.size() && j >= 0){
        if(mat[i][j] == target){
            cout<<i<<" "<<j<<endl;
            return;
        }else if(mat[i][j] > target)  j--;
        else    i++;
    }
}


int main(){
    vector<vector<int>> mat = {{10,20,30,40},
                               {15,25,35,45},
                               {27,29,37,48},
                               {32,33,39,50}};
    searchInMatrix(mat,29);
    return 0;
}