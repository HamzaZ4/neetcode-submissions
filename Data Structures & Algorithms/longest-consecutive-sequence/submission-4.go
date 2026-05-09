func longestConsecutive(nums []int) int {

    seen := make(map[int]struct{})
    longest := 0
    for _, num := range nums {
        seen[num] = struct{}{}
    }


    for _, num := range nums {
        _, hasPrev := seen[num-1]
        if !hasPrev {
            curNum := num
            curStr := 1

            _, hasNext := seen[num+1]
            for hasNext {
                curNum++
                curStr++
                _, hasNext = seen[curNum + 1] 
            }
            if longest < curStr {
                longest = curStr
            }
        }
    }

    return longest

}