package BT10;

public class Self_Balancing_Tree {
    	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int getBalance(Node root) {
        return height(root.left) - height(root.right);
    }

	static Node insert(Node root,int val)
    {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = height(root);
            return root;
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        else if (val < root.val) {
            root.left = insert(root.left, val);
        }
        
        int balance = getBalance(root);
        
        if (balance > 1) { // lech trai -> quay phai
            if (getBalance(root.left) < 0) { // lech trai phai
                // quay trai
                root.left = leftRotate(root.left);
            }
            root = rightRotate(root); // quay phai
        }
        else if (balance < -1) { // lech phai -> quay trai
            if (getBalance(root.right) > 0) { // lech phai trai
                root.right = rightRotate(root.right);
            }
            root = leftRotate(root); // quay trai
        }
        else {
            root.ht = height(root);
        }
        return root;
    }

    static Node leftRotate(Node root) {
        Node rightNode = root.right;
        Node rightLeftNode = rightNode.left;
        rightNode.left = root;
        root.right = rightLeftNode;
        root.ht = height(root);
        rightNode.ht = height(rightNode);
        return rightNode;
    }

    static Node rightRotate(Node root) {
        Node leftNode = root.left;
        Node leftRightNode = leftNode.right;
        leftNode.right = root;
        root.left = leftRightNode;
        root.ht = height(root);
        leftNode.ht = height(leftNode);
        return leftNode;
    }

    

}
