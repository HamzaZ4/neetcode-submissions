class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        count = [0]*26

        for s in tasks:
            count[ord(s) - ord('A')]+=1
        
        count.sort()

        chunk = count[25]-1
        idle = chunk*n

        for i in range(24,-1,-1):
            idle-= min(count[i], chunk)

        return (len(tasks) if idle <= 0 else idle+len(tasks))

                