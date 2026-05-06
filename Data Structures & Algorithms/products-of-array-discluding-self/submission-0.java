class Solution {
    //using division makes this problem too easy
    public int[] productExceptSelf(int[] nums) {
       //using a pre and post technique

       //I want to traverse this array only once so i need to find a way to do that
       // here is what we are going to do
       //keep another array where i compute the pre and the post

       int[] prod = new int[nums.length];

       //now we do the pre for each index
       int pre = 1;
       for(int i = 0;i<nums.length;i++){
            prod[i] = pre; // this will ensure that pre is taking the product of all numbers before
            pre *= nums[i];// this ensures pre is correct for the next index
       }

       int post = 1;

       for(int j = nums.length-1; j>=0;j--){
        prod[j] *=post;
        post*=nums[j];
       }
       return prod;
    }
}  
