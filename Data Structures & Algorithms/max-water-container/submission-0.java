class Solution {
    public int maxArea(int[] heights) {
        int r = heights.length -1;
        int l = 0;
        int max = 0;
        int area = 0;
        while(r>l){
            area = (r-l)*Math.min(heights[r], heights[l]);
            max = Math.max(max, area);
            if(heights[r]>heights[l]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
