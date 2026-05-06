/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //what do we need to do, we need to perform dfs 
        //kth smallest basically just means kth number if we start counting from leftmost node
        //so go from 
        if(root == null){
            return 0;
        }

        int[] arr = {k, root.val};
        dfs(root,arr);
        return arr[1];
    }

    public void dfs(TreeNode root, int[] arr){
        if(root == null){
            return;
        }
        dfs(root.left,arr);
        arr[0]--;
        if(arr[0]== 0){
            arr[1]=root.val;
            return;
        }
        dfs(root.right,arr);
    }

    
}
