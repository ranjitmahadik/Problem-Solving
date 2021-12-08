#include <bits/stdc++.h>
using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left,*right,*next;

    TreeNode(){
    }

    TreeNode(int val){
        this->val = val;
        left = right = next NULL;
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

    static void populateNextPointer(TreeNode* root){
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode* currentNode = q.front();
                q.pop();

                if(currentNode->left != nullptr)    q.push(currentNode->left);
                if(currentNode->right != nullptr)    q.push(currentNode->right);
                if(i == size - 1)   continue;


                TreeNode* nextNode = q.front();
                currentNode->next = nextNode;
            }
        }
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    static void populateNextPointerSpaceOptimized(TreeNode* root){
        TreeNode* rootIterator = root;
        while (rootIterator != nullptr){
            TreeNode* childIterator = rootIterator;
            while(childIterator != nullptr){
                if(childIterator->left != nullptr)  childIterator->left->next = childIterator->right;
                if(childIterator->right != nullptr && childIterator->next != nullptr)   childIterator->right->next = childIterator->next->left;

                childIterator = childIterator->next;
            }
            rootIterator = rootIterator->left;
        }
    }

    static void populateNextPointerSpaceOptimized2(TreeNode* root){
        TreeNode* rootIterator = root;
        TreeNode* prev = nullptr;

        while (rootIterator != nullptr){
            TreeNode* childIterator = rootIterator;
            while(childIterator != nullptr){

            }
            rootIterator = rootIterator->left;
            prev = nullptr;
        }
    }
};

int main(){

    return 0;
}