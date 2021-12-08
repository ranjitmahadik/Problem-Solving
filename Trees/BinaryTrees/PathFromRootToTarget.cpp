#include <bits/stdc++.h>
using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left,*right;

    TreeNode(){
    }

    TreeNode(int val){
        this->val = val;
        left = right = NULL;
    }
}TreeNode;

class Util{
	public:
    static TreeNode* getTree(){
        TreeNode* root = new TreeNode(10);
        root->left = new TreeNode(20);
        root->right = new TreeNode(30);

        root->left->left = new TreeNode(40);
        root->left->right = new TreeNode(50);
        root->left->right->left = new TreeNode(60);
        root->left->right->right = new TreeNode(70);
        return root;
    }
    static bool printPathFromRootToTarget(TreeNode* root,int target,vector<int>&path){
        if(root == nullptr) return false;
        path.push_back(root->val);
        if(root->val == target) return true;
        if(printPathFromRootToTarget(root->left,target,path) ||  printPathFromRootToTarget(root->right,target,path))  return true;
        path.pop_back();
        return false;
    }
};
int main(){
	vector<int> path;
    Util::printPathFromRootToTarget(Util::getTree(),70,path);
    for(int i : path)	cout<<i<<" ";
    return 0;
}