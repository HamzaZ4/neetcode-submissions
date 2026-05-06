class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l = 0;
        int[] ans = {0,0};
        while(r>l){
            if(numbers[r]+numbers[l]==target){
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
            else if(target-numbers[r]>numbers[l]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
