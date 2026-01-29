package ro.alexil.codingchallange.a20260120;

public class Solution{

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){
        return invertNode(root);
    }

    public static TreeNode<Integer> invertNode(TreeNode<Integer> node) {
        if((node == null) || (node.left == null && node.right == null)) {
            return node;
        }
        TreeNode<Integer> inverted = new TreeNode<>(node.data) ;
        inverted.left = invertNode(node.right);
        inverted.right = invertNode(node.left);
        return inverted;
    }



}

