func productExceptSelf(nums []int) []int {
    n := len(nums)
    res := make([] int, n)

    pref := 1
    for i := 0; i < n; i++ {
        res[i] = pref
        pref *= nums[i]
    }
    
    suff := 1
    for i:= n-1; i > -1; i-- {
        res[i] *= suff
        suff *= nums[i]
    }

    return res

}
