class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ind = 0
        ans = []

        while ind < len(nums)-2:
            if ind and nums[ind] == nums[ind-1]: 
                ind += 1
                continue
            
            l, r = ind+1, len(nums)-1
            start = nums[ind]
            while l < r:
                left = nums[l]
                right = nums[r]
                sum_ = left + right + start
                if sum_ == 0:
                    ans.append([start, left, right])
                    l += 1
                    while l < r and nums[l] == nums[l-1]: l += 1
                elif sum_ > 0:
                    r -= 1
                else: l += 1
            ind += 1
        return ans