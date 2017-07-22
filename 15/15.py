#! /usr/bin/env python
#-*- coding:UTF-8 -*-   #或 # coding:UTF-8
'''
    问题描述：leetcode15题
        找出和为0的三个数组合
'''

#----------------------------
# 不同点就在于xrange生成的不是一个数组，而是一个生成器。

class Solution(object):
    def threeSum(self, nums):
        res = []
        nums.sort()
        print nums
        for i in xrange(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:  # 如果i和i-1一样，则找出的结果也是一样的，不用再找
                continue
            l, r = i+1, len(nums)-1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0:
                    l +=1 
                elif s > 0:
                    r -= 1
                else:
                    res.append((nums[i], nums[l], nums[r])) # 里面是添加一个元组
                    while l < r and nums[l] == nums[l+1]:   # 重复的数字向高位移动
                        l += 1
                    while l < r and nums[r] == nums[r-1]:   # 重复的高位数字向低位移动
                        r -= 1
                    l += 1; r -= 1
        return res

sol = Solution()
print sol.threeSum([1,-2,2,-3,4,5,-5,5,6,7,7,8])