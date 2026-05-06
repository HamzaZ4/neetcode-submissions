class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int top =0, bot = matrix.length-1;


        int l=0, r= matrix[0].length-1;
        int mid = (l+r)/2;

        while(top<=bot){
            row = (top+bot)/2;
            if(matrix[row][matrix[0].length-1] < target){
                top=row+1;
            }
            else if(matrix[row][0] > target){
                bot = row -1;
            }
            else{
                break;
            }
        }
        if(!(top<= bot)){
            return false;
        }

        row = (top + bot)/2;

        while(l<=r){
            mid = (l+r)/2;
            if(matrix[row][mid] < target){
                l=mid+1;
            }
            else if(matrix[row][mid] > target){
                r = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
