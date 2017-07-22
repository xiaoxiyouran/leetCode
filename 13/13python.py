#! /usr/bin/env python
#-*- coding:UTF-8 -*-   #或 # coding:UTF-8
'''
    问题描述：leetcode12题
        将一个数字转换成罗马数字
'''


'''
C++ 标准库<vector>
#------------------------------------
# 列表的用法
create_list=['a','b',0,1,2]
list_start=create_list[0]   # 列表的第一个值
list_end=create_list[-1]    # 列表的最后一个值

del create_list[0]                  # 删除列表的第一个值
create_list[0:0] = ['sample value'] #在列表头部插入一个值
list_length = len(create_list)      # 返回实际元素个数

# 列表的遍历
for element in create_list:
    print(element)


#-----------------------------------------
# 列表的高级操作

# 产生一个数值递增列表
num_inc_list = range(30)    # [0,1,2,3,...,29]

# 用某个固定值初始化列表
# 1-
initial_value = 0
sample_list = [initial_value for i in range(10)] # [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]


# 2-
list_length = 5 
sample_list = [initial_value]*list_length        # [0, 0, 0, 0, 0]

# List 类型可为任意类型
# 0:第一个     -1:最后一个 #-len:第一个 len-1：最后一个
# len(list) 返回列表的长度,实际该方法是调用了此对象的__len__(self) 方法
L = range(1,5)      # [1,2,3,4]
L = range(1,10,2)   # [1,3,5,7,9]

#-----------------------------------------
# 列表的方法
L.append(var)   #追加一个元素
L.insert(index,var) # 在index之前添加var
L.pop(var)      # 返回最后一个元素，并从list删除之
L.remove(var)   # 删除第一次出现的该元素
L.count(var)    # 该元素在列表中出现的个数
L.index(var)    # 该元素的位置，无则抛异常
L.extend(list)  # 追加list，即合并list到L上
L.sort()        # 排序
L.reverse()     # 倒序

# list 操作符
L[1:]           # 片段操作符，用于子list的提取
[1,2]+[3,4]     # [1,2,3,4] <=> extend
[2]*4           # [2,2,2,2]

del L[1]        # 删除指定下标的元素
del L[1:3]      # 删除指定下标范围的元素

L1 = L          # L1 是L 的别名，地址相同，函数参数就是这样传递的
L1 = L[:]       # L1 是 L的克隆，即另一个拷贝  或 L1 = list(L), 可用id(L1) 或id(L) 来判断是引用还是拷贝


# 列表可以支持生成器
LL = list(k for k in range(100) if k%2==0 ) # [0,2,...98]
# <===> 等价如下：
generator = (x*3 for x in range(4))         # <generator object <genexpr> at 0x101b47f50>
print list(generator)                       # [0, 3, 6, 9]

#----------------------
# 列表的5种复制方式
import copy
a = [[10], 20]
# 方法一
b = a[:]
# 方法二
c = list(a)
# 方法三：
d = a * 1
# 方法四：
e = copy.copy(a)
# 方法五：
f = copy.deepcopy(a)     # 含有列表的列表，只有这种方式能够完全复制，其它的，内部列表只是引用
a.append(21)
a[0].append(11)
>>> print id(a), a
30553152 [[10, 11], 20, 21]
>>> print id(b), b
44969816 [[10, 11], 20]
>>> print id(c), c
44855664 [[10, 11], 20]
>>> print id(d), d
44971832 [[10, 11], 20]
>>> print id(e), e
44833088 [[10, 11], 20]
>>> print id(f), f
44834648 [[10], 20]

'''


class Solution(object):
    def romanToInt(self, s):
        """
        :type num: string
        :rtype: integer
        """
        roman = { 'M':1000, 'D':500, 'C':100 , 'L':50, 'X':10,'V':5,'I':1 }     # 字典存储每个罗马数字的值
        z = 0
        for i in range(0,len(s)-1): #到它的前一个，剩最后一个，没人和它比
            if roman[s[i]] < roman[s[i+1]]: # 如果前面的小于后面的，需要减掉
                z -= roman[s[i]]
            else:
                z += roman[s[i]]

        return z+roman[s[-1]]   # 需要加上最后一个
        

# 实例化一个类
sol = Solution()

# array = range(6)

print sol.romanToInt('VI')
