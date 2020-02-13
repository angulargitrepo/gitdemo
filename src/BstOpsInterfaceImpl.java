import inter.BstOpsInterface;

import java.util.ArrayList;
import java.util.List;

class BstOpsInterfaceImpl implements BstOpsInterface {

    public Node root;

    @Override
    public void init(int[] values) {
        root = generateArrayToBST(values, 0, values.length - 1);
    }

    public Node generateArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.index = mid;
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = generateArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = generateArrayToBST(arr, mid + 1, end);

        return node;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public List<Integer> search(int value) {
        List<Integer> matchIndex=new ArrayList<>();
        checkDupUtil(root,value,matchIndex);
        return matchIndex.size()>0?matchIndex:null;
    }
    public boolean checkDupUtil(Node root, int key,List<Integer> matchIndex)
    {
        // If tree is empty, there are no
        // duplicates.
        if (root == null)
            return false;

        // If current node's data is already present.
        if (key == root.data) {
            matchIndex.add(root.index);
           // return true;
        }

        // Recursively check in left and right
        // subtrees.
        return checkDupUtil(root.left, key,matchIndex) || checkDupUtil(root.right, key,matchIndex);
    }
    int iterativeSearch(Node root, int key,List<Integer> matchIndex)
    {
        while (root != null) {
            // pass right subtree as new tree
            if (key > root.data)
                root = root.right;
            else if (key < root.data)
                root = root.left;
            else {// if the key is found return 1
                matchIndex.add(root.index);
                return 0;
            }
        }
        return -1;
    }

    @Override
    public List<Integer> getBstValues() {
        List<Integer> inOrderList=new ArrayList<>();
        preOrder(root,inOrderList);
        return inOrderList;
    }
    public void preOrder(Node node,List<Integer> preOrderList) {
        if (node == null) {
            return;
        }
        //System.out.print(node.data + " ");
        preOrderList.add(node.data);
        preOrder(node.left,preOrderList);
        preOrder(node.right,preOrderList);
    }

    @Override
    public List<Integer> getBstValuesInOrder() {
        List<Integer> inOrderList=new ArrayList<>();
        inOrder(root,inOrderList);
        return inOrderList;
    }
    public void inOrder(Node root,List<Integer> inOrderList)
    {
        if (root != null) {
            inOrder(root.left,inOrderList);
            //System.out.print(root.data + " ");
            inOrderList.add(root.data);
            inOrder(root.right,inOrderList);
        }
    }
}


class Node {
    int data;
    Node left, right;
    int index;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

