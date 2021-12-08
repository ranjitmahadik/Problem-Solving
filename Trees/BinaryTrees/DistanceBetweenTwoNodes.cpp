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

    static TreeNode* getLCA(TreeNode* root,int t1,int t2){
        if(root == nullptr) return root;

        if(root->val == t1 || root->val == t2)  return root->val;

        int left = getLCA(root->left,t1,t2);
        int right = getLCA(root->right,t1,t2);

        if(left == nullptr || right == nullptr) return left != nullptr ? left : right;

        if((left == t1 && right == t2) || (left == t2 && right == t1))  return root->val;

        return left != nullptr ? left : right;
    }

    static int getDistanceFromRoot(TreeNode* root,int target){
        if(root == nullptr) return -1;

        if(root->val == target) return 0;

        int left = getDistanceFromRoot(root->left,target);
        int right = getDistanceFromRoot(root->right,target);

        if(left != -1)  return left + 1;
        if(right != -1) return right + 1;

        return left;
    }

};
int main(){
    TreeNode* root = Util::getTree();
    TreeNode* lca = Util::getLCA(root,70,30);
    int dist1 = Util::getDistanceFromRoot(lca,70);
    int dist2 = Util::getDistanceFromRoot(lca,30);

    cout<<(dist1 + dist2);

    return 0;
}