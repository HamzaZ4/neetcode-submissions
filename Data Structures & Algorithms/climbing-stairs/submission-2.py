class Solution:
    def climbStairs(self, n: int) -> int:
        if(n <= 3):
            return n
        
        numWays = self.climbStairs(n-1) + self.climbStairs(n-2)

        return numWays;