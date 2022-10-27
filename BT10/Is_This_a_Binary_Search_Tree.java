package BT10;

import java.util.ArrayList;
import java.util.List;

public class Is_This_a_Binary_Search_Tree {
    /*
     * Hidden stub code will pass a root argument to the function below. Complete
     * the function to solve the challenge. Hint: you may want to write one or more
     * helper functions.
     * 
     * The Node class is defined as follows:
     * class Node {
     * int data;
     * Node left;
     * Node right;
     * }
     */

    List<Node> listNode(Node root) {
        if (root == null)
            return null;
        List<Node> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root);
            return result;
        }
        result.addAll(listNode(root.left));
        result.add(root);
        result.addAll(listNode(root.right));
        return result;
    }

    boolean checkBST(Node root) {
        List<Node> nodeList = listNode(root);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            if (nodeList.get(i).data >= nodeList.get(i + 1).data)
                return false;
        }
        return true;
    }
}
