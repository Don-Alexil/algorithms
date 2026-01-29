package ro.alexil.codingchallange.a01;

public class MonitorCameras {

    public int minCameraCover(TreeNode<Integer> root) {
        int height = getHeight(root);
        if(height <= 2) {
            return 1;
        }
        boolean installCamera = height % 2 == 0;
        int sum = 0;
        return getSum(root, installCamera, sum);

    }

    public int getSum(TreeNode<Integer> node, boolean installCamera, int sum) {
        int sumIncrement = installCamera ? 1 : 0;
        if (node == null) {
            return sumIncrement;
        }
        node.data = sumIncrement;
        sum += sumIncrement;
        if(node.left != null) {
            sum = getSum(node.left, !installCamera, sum) ;

        }
        if(node.right != null) {
            sum = getSum(node.right, !installCamera, sum);
        }
        return sum;
    }

    public  <T> int getHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static void main(String[] args) {
        MonitorCameras monitorCameras = new MonitorCameras();
        TreeNode<Integer> root = new TreeNode<>(0);
        int result = monitorCameras.minCameraCover(root);
        System.out.println("Minimum number of cameras needed: " + result);

        root.left = new TreeNode<>(0);
        root.right = new TreeNode<>(0);
        root.left.left = new TreeNode<>(0);
        root.left.right = new TreeNode<>(0);

        result = monitorCameras.minCameraCover(root);
        System.out.println("Minimum number of cameras needed: " + result);


/*
       var root1 = buildTree(new Integer[]{0,0,0,0,0,0,0,0,0,null,0,null,0, null, 0});
       var root2 = buildTree(new Integer[]{0,0,null,0,0 });
       var root3 = buildTree(new Integer[]{0,0,null,null,0,0,null,null,0});

 */

    }

    public static TreeNode<Integer> buildTree(Integer[] nodes){
        if(nodes == null || nodes.length == 0){
            return null;
        }

        TreeNode<Integer> root = new TreeNode<>(nodes[0]);
        getNextLevel(root, nodes, 1);
        return root;

    }

    public static void getNextLevel(TreeNode<Integer> parent, Integer[] nodes, int index){
        if(index >= nodes.length){
            return;
        }
        if(nodes[index] != null) {
            parent.left = new TreeNode<>(nodes[index]);
            getNextLevel(parent.left, nodes, index * 2 + 1);
        }
        if(nodes[index+1]  != null){
            parent.right = new TreeNode<>(nodes[index+1]);
            getNextLevel(parent.right, nodes, index*2 + 2);
        }

    }

}
