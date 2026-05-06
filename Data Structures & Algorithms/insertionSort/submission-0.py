# Definition for a pair.
# class Pair:
#     def __init__(self, key: int, value: str):
#         self.key = key
#         self.value = value
class Solution:
    def insertionSort(self, pairs: List[Pair]) -> List[List[Pair]]:
        
        res=[] #intermediate states
        for i in range(0,len(pairs)):
            j=i-1

            while j>=0 and pairs[j+1].key<pairs[j].key:
                tmp = pairs[j+1]
                pairs[j+1] = pairs[j]
                pairs[j]=tmp
                j-=1
            res.append(pairs[:])

        return res
            

