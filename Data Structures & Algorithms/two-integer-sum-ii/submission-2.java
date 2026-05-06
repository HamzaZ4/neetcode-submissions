class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l = 0;
        int[] ans = {0,0};
        while(r>l){
            int sum = numbers[r]+numbers[l];
            if(sum==target){
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
            else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
