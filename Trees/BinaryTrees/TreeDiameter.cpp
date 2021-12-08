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

    static int getDiameterBruteForce(TreeNode* root){
        if(root == NULL)    return 0;

        int leftDia = getDiameterBruteForce(root->left);
        int rightDia = getDiameterBruteForce(root->right);

        int leftHeight = height(root->left);
        int rightHeight = height(root->right);

        int currentDia = 2 + leftHeight + rightHeight;

        return max({leftDia,rightDia,currentDia});
    }

    static pair<int,int> getDiamterOptimal(TreeNode* root){
        if(root == NULL)    return {0,-1};  // dia,height;

        pair<int,int> ld = getDiamterOptimal(root->left);
        pair<int,int> rd = getDiamterOptimal(root->right);

        int leftHeight = ld.second;
        int rightHeight = rd.second;

        int currentNodeDiameter = 2 + leftHeight + rightHeight;
        int currentNodeHeight = max(leftHeight,rightHeight) + 1;
        
        int finalDiam = max({currentNodeDiameter,ld.first,rd.first});

        return {finalDiam,currentNodeHeight};
    }

};

int main(){
    TreeNode* root = Util::getTree();
	cout<<Util::getDiameterBruteForce(root)<<" "<<Util::getDiamterOptimal(root).first;
    return 0;
}