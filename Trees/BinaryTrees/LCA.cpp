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
    static int LCA(TreeNode* root,int targetNode1,int targetNode2){
        if(root == nullptr) return -1;

        if(root->val == targetNode1 || root->val == targetNode2)    return root->val;

        int left = LCA(root->left,targetNode1,targetNode2);
        int right = LCA(root->right,targetNode1,targetNode2);

        if((left == targetNode1 && right == targetNode2) || (left == targetNode2 && right == targetNode1))  return root->val;

        return left != -1 ? left : right;
    }
};
int main(){
   return 0;
}