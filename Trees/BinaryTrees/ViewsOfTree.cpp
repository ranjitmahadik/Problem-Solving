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

    static void leftViewOfTree(TreeNode* root){
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                if(i == 0)  cout<<(q.front())->val<<" ";
                TreeNode* currentNode = q.front();
                q.pop();
                if(currentNode->left != nullptr)    q.push(currentNode->left);
                if(currentNode->right != nullptr)   q.push(currentNode->right);
            }
        }
    }

    static void rightViewOfTree(TreeNode* root){
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                if(i == (size - 1))  cout<<(q.front())->val<<" ";
                TreeNode* currentNode = q.front();
                q.pop();
                if(currentNode->left != nullptr)    q.push(currentNode->left);
                if(currentNode->right != nullptr)   q.push(currentNode->right);
            }
        }
    }

    static void topViewOfTree(TreeNode* root){
        map<int,int> lookup;
        queue<pair<TreeNode*,int> > q;
        q.push({root,0});

        while(!q.empty()){
            TreeNode* currentNode = q.front().first;
            int currentIndicator = q.front().second;
            q.pop();
            
            if(lookup.find(currentIndicator) == lookup.end())
                lookup[currentIndicator] = currentNode->val;

            if(currentNode->left != nullptr)    q.push({currentNode->left,currentIndicator-1});
            if(currentNode->right != nullptr)    q.push({currentNode->right,currentIndicator+1}); 
        }

        for(pair<int,int> p : lookup){
            cout<<p.second<<" ";
        }
    }

    static void bottomViewOfTree(TreeNode* root){
        map<int,int> lookup;
        queue<pair<TreeNode*,int> > q;
        q.push({root,0});

        while(!q.empty()){
            TreeNode* currentNode = q.front().first;
            int currentIndicator = q.front().second;
			q.pop();
			
            lookup[currentIndicator] = currentNode->val;

            if(currentNode->left != nullptr)    q.push({currentNode->left,currentIndicator-1});
            if(currentNode->right != nullptr)    q.push({currentNode->right,currentIndicator+1}); 
        }

        for(pair<int,int> p : lookup){
            cout<<p.second<<" ";
        }
    }

};

int main(){
    TreeNode* root = Util::getTree();
    Util::bottomViewOfTree(root);
    
    return 0;
}
