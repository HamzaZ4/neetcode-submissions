class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hmap = {}

        for i in range(len(numbers)):
            if target-numbers[i] in hmap:
                return [hmap[target-numbers[i]]+1, i+1]
            hmap[numbers[i]] = i

        return []