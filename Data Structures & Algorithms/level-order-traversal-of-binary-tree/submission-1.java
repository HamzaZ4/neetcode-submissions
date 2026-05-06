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

 //bfs we like keep a stack right and then keep going
 //visit root, add left and right child to stack
 // do something to root, hten pop from stack and continue
 // until visited everything

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        

        List<List<Integer>> theList = new ArrayList<>();
        if(root == null){
            return theList;
        }


        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            List<Integer> miniList = new ArrayList<>();

            for(int i = q.size(); i >0;i--){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                miniList.add(q.remove().val);
            }
            if(miniList.size()>0){
                theList.add(miniList);
            }
        }

        return theList;



    }
}
