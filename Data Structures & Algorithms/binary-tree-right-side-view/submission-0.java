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


// at each level there is only one visible.
// Everytime we get to a level we need to set the 'visible' to the left most node
//then as we keep going we set the rightest one we CAN see evertime.


//first let's setup a bfs
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> fromRight = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode righty = null;
            int qlen = q.size();

            for(int i =0;i<qlen;i++){
                TreeNode node = q.poll();
                if(node != null){
                    righty = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            System.out.println(righty);
            if(righty != null ){
                fromRight.add(righty.val);
            }
        }
        return fromRight;
    }
}
