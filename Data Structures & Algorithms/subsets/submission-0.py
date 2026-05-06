class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        sub = []
        def dfs(i):
            if i >= len(nums):
                ans.append(sub.copy())
                return
            
            #decision to include nums[i]
            sub.append(nums[i])
            dfs(i+1) #will include a subset including nums[i]

            #decision not to include nums[i]
            sub.pop()
            dfs(i+1)#subset wont include nums[i]

        dfs(0)
        return ans
            
            
            
         
