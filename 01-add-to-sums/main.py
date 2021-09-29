def twoSum(nums, target: int):
    diffs = {}
    for idx, num in enumerate(nums):
        pair = target - num
        if pair in diffs:
            pairIdx = diffs[pair]
            return [idx,pairIdx] 
        else:
            diffs[num] = idx
    return [-1, -1]