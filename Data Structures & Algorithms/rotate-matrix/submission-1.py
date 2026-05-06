class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        l, r = 0, len(matrix)-1

        while l < r:
            for i in range(r - l):
                top, bot = l, r
                topLeft = matrix[top][i+l]

                matrix[top][i+l] = matrix[r-i][top]
                matrix[r-i][top] = matrix[bot][r-i]
                matrix[bot][r-i] = matrix[l+i][bot]
                matrix[l+i][bot] = topLeft

            l+=1
            r-=1
        


    
