#include <bits/stdc++.h>
using namespace std;

typedef struct TreeNode
{
    int val;
    TreeNode *left, *right;

    TreeNode()
    {
    }

    TreeNode(int val)
    {
        this->val = val;
        left = right = NULL;
    }
} TreeNode;

TreeNode *constructTreeFromInoderAndPreOrder(int inOrder[], int preOder[], int inStart, int inEnd, int preStart, int preEnd)
{
    if (inEnd < inStart || preStart > preEnd)
        return NULL;

    int val = preOder[preStart];
    TreeNode *root = new TreeNode(val);
    int currentNodePositionInOrder = 0;
    for (currentNodePositionInOrder = inStart; currentNodePositionInOrder <= inEnd; currentNodePositionInOrder++)
    {
        if (inOrder[i] == val)
            break;
    }

    int nodesInLeftSubtree = currentNodePositionInOrder - inStart;

    root->left = constructTreeFromInoderAndPreOrder(inOrder, preOder, inStart, currentNodePositionInOrder - 1, preStart + 1, preStart + nodesInLeftSubtree);
    root->right = constructTreeFromInoderAndPreOrder(inOrder, preOder, currentNodePositionInOrder + 1, inEnd, preStart + nodesInLeftSubtree + 1, preEnd);

    return root;
}

int preIndex = 0;
TreeNode *constructTreeFromInoderAndPreOrder(int inOrder[], int preOder[], int inStart, int inEnd){
    if (inEnd < inStart)
        return NULL;

    int val = preOder[preIndex++];
    TreeNode *root = new TreeNode(val);
    int currentNodePositionInOrder = 0;
    for (currentNodePositionInOrder = inStart; currentNodePositionInOrder <= inEnd; currentNodePositionInOrder++)
    {
        if (inOrder[i] == val)
            break;
    }

    root->left = constructTreeFromInoderAndPreOrder(inOrder, preOder, inStart, currentNodePositionInOrder - 1);
    root->right = constructTreeFromInoderAndPreOrder(inOrder, preOder, currentNodePositionInOrder + 1, inEnd);

    return root;
}

int main()
{

    return 0;
}