#include<bits/stdc++.h>
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

class TreeTraversals{
	public:
    TreeNode* getTree(){
        TreeNode* root = new TreeNode(10);
        root->left = new TreeNode(20);
        root->right = new TreeNode(30);

        root->left->left = new TreeNode(40);
        root->left->right = new TreeNode(50);
        root->left->right->left = new TreeNode(60);
        root->left->right->right = new TreeNode(70);
        return root;
    }
    
    void preOrder(TreeNode* root){
        if(root == NULL)    return;
       
        cout<<root->val<<" ";
        preOrder(root->left);
        preOrder(root->right);
    }

    void inOrder(TreeNode* root){
        if(root == nullptr) return;

        inOrder(root->left);
        cout<<root->val<<" ";
        inOrder(root->right);
    }

    void postOrder(TreeNode* root){
        if(root == nullptr) return;

        postOrder(root->left);
        postOrder(root->right);
        cout<<root->val<<" ";
    }

    void interativeOrder(TreeNode* root){
        stack<pair<TreeNode*,int> > s;
        s.push({root,0});

        while (!s.empty()){
            TreeNode* root = s.top().first;
            int processingCount = s.top().second;
            s.pop();

            if(root == nullptr || processingCount == 3)  s.pop();

            s.push({root,processingCount + 1});
            if(processingCount == 0)    s.push({root->left,0});
            else if(processingCount == 1)   cout<<root->val<<" ";
            else if(processingCount == 2)   s.push({root->right,0});
        }
        cout<<"\n";
    }
};


int main(){
	TreeTraversals* root = new TreeTraversals();
	root->postOrder(root->getTree());

    return 0;
}