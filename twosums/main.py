def twoSum(nums, target: int):
    diffs = {}
    for idx, num in enumerate(nums):
        # TODO:  corner cases!
        pair = target - num
        if pair in diffs:
            pairIdx = diffs[pair]
            return [idx,pairIdx] 
        else:
            diffs[num] = idx
    return [-1, -1]
    
res = twoSum([11, 2, 15, 7], target = 9)
res2 = twoSum([4, 2, 4, 2], target = 8)
print(res)
print(res2)