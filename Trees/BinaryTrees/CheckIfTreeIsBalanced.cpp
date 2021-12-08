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

    static int height(TreeNode* root){
        if(root == NULL)    return -1;

        int lh = height(root->left);
        int rh = height(root->right);

        return max(lh,rh) + 1;
    }

    static bool isBalanced(TreeNode* root){
        if(root == nullptr) return true;

        bool isLeft = isBalanced(root->left);
        bool isRight = isBalanced(root->right);
        
        if(!isLeft || !isRight) return false;

        int lh = height(root->left);
        int rh = height(root->right);

        bool isReallyBalanced = (abs(lh - rh) < 2);

        return isLeft && isRight && isReallyBalanced;
    }

    static pair<bool,int> isBalancedOptimal(TreeNode* root){
        if(root == nullptr) return {true,-1};

        pair<bool,int> leftHeight = isBalancedOptimal(root->left);
        pair<bool,int> rightHeight = isBalancedOptimal(root->right);
        
        if(!leftHeight.first || !rightHeight.first) return {false,-1};

        int currentNodeHeight = max(rightHeight.second,leftHeight.second) + 1;
        bool isCurrentNodeBalanced = abs(leftHeight.second - rightHeight.second) < 2;

        return {isCurrentNodeBalanced,currentNodeHeight};
    }

};

int main(){
    TreeNode* root = Util::getTree();
    cout<<Util::isBalancedOptimal(root);
    return 0;
}
