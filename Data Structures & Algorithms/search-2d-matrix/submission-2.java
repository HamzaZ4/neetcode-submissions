class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int l=0, r=matrix[0].length-1;
        int mid = (l+r)/2;

        while(l<=r){
            if(target > matrix[row][r] && row < matrix.length-1){
                row +=1;
                continue;
            }
            mid = (l+r)/2;
            if(matrix[row][mid] < target){
                l=mid+1;
            }
            else if(matrix[row][mid] > target){
                r = mid -1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
