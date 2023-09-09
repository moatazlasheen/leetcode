package leetcode.problems.tree;


/**
 * 968. Binary Tree Cameras
Hard

You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:

Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

Example 2:

Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

 

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    Node.val == 0


 * 
 * @author Moataz Lasheen
 *
 */
public class MonitoringCameras {
	int camerasCount = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null && root.right == null)) return 1;
        
        int x = traverseTree(root);
        if (x == -1) {
          camerasCount++;  
        } 
        return camerasCount;
    }

    private int traverseTree(TreeNode root) {
        if (root == null) return 0;

        int left = traverseTree(root.left);
        int right = traverseTree(root.right);

        if (left == -1 || right == -1) {
            camerasCount++;
            // root has camera installed
            return 1;
        } else if (left == 0 && right == 0) {
            // both subtrees are monitored, no camera is needed here, root will be monitored by its parent
            return -1;
        } else {
            // one of the sub trees has camera installed, then root is monitored
            return 0;
        }
    }
}
