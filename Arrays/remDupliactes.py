class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)==0 or len(nums)==1:
            return len(nums)
        start = 0
        end = 1
        siz = len(nums)
        while(end<siz):
            if nums[start]==nums[end]:
                end+=1
            else:
                nums[start+1] = nums[end]
                start+=1
                end+=1
        return start+1
