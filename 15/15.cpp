//
//  main.cpp
//  11
//
//  Created by Cookie on 2017/7/14.
//  Copyright © 2017年 Cookie. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// ---------------------------------------------------------------------------
// 获取数组长度的模板
template <class T>
int getArrayLen(T& array)  //使用模板定义一个函数getArrayLen,该函数将返回数组array的长度
{
    return (sizeof(array) / sizeof(array[0]));
}

// ---------------------------------------------------------------------------
// C++ <vector> 赋值的几种方法

// 1-
//vector<int>ivec1(10,42); // 内置方法，初始化的内容为10个42

// 2- 指定个数，依次赋值
/*
 vector<int>ivec2(10);
 
 vector<int>::size_type ix=0;
 
 for(ix;ix<10;++ix)
 
 {
 
 ivec2[ix]=42; //下标操作
 
 }
 */

// 3- 使用迭代器遍历
/*
 vector<int>ivec3(10);
 
 for(vector<int>::iterator iter=ivec3.begin();iter!=ivec3.end();++iter)
 
 {
 
 *iter=42; //迭代器
 
 }
 */

/////下面两种方法最佳，他们使用标准库定义的操作，无须再定义vector对象时指定容器的大小。比较灵活且不容易出错.
// 4- 在前面依次插在末尾的前面
/*
 vector<int>ivec4;
 
 vector<int>::iterator iter=ivec4.end();
 
 for(int i=0;i!=10;++i)
 
 {
 
 ivec4.insert(iter,42); //在指定位置iter前插入值为的元素,返回指向这个元素的迭代器,
 
 iter=ivec4.end();
 
 }
 */

// 5- 每次都是放在最后
/*
 vector<int>ivec5;
 
 vector<int>::size_type cnt=1;
 
 for(cnt;cnt<=10;++cnt)
 
 {
 
 ivec5.push_back(42); //push_back()添加值为42的元素到当前vector末尾
 
 }
 */

// 6- 通过数组复制（常用）
//int myarray[5] = {1,3,5,7,9};
//vector<int> myvector(myarray , myarray+sizeof(myarray)/sizeof(myarray[0]));





// ---------------------------------------------------------------------------
// unordered_map:
/*
 #include <unordered_map>
 int main(){
 unordered_map<string,int> months;
 //插入数据
 cout<<"insert data"<<endl;
 months["january"]=31;
 months["february"] = 28;
 months["march"] = 31;
 months["september"] = 30;
 
 //直接使用key值访问键值对，如果没有访问到，返回0
 cout<<"september->"<<months["september"]<<endl;
 cout<<"xx->"<<months["xx"]<<endl;
 
 typedef unordered_map<int,int> mymap;
 mymap mapping;
 mymap::iterator it;
 mapping[2]=110;
 mapping[5]=220;
 const int x=2;const int y=3;//const是一个C语言（ANSI C）的关键字，它限定一个变量不允许被改变,产生静态作用，提高安全性。
 
 //寻找是否存在键值对
 //方法一：
 cout<<"find data where key=2"<<endl;
 if( mapping.find(x)!=mapping.end() ){//找到key值为2的键值对
 cout<<"get data where key=2! and data="<<mapping[x]<<endl;
 }
 
 cout<<"find data where key=3"<<endl;
 if( mapping.find(y)!=mapping.end() ){//找到key值为3的键值对
 cout<<"get data where key=3!"<<endl;
 }
 //方法二：
 it=mapping.find(x);    // 返回一个迭代器
 printf("find data where key=2 ?  %d\n",(it==mapping.end()));
 it=mapping.find(y);
 printf("find data where key=3 ?  %d\n",(it==mapping.end()));
 
 //遍历hash table
 for( mymap::iterator iter=mapping.begin();iter!=mapping.end();iter++ ){
 cout<<"key="<<iter->first<<" and value="<<iter->second<<endl;
 }
 
 system("pause");
 }
 
 */

// ---------------------------------------------------------------------------
// 调试:
/*
 Xcode 调试用gdb的一种调试窗口
 po 对象 或 print 对象即可
 
 */



// ---------------------------------------------------------------------------
// Solution:
#include <unordered_map>
class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        
        vector<vector<int> > res;
        
        std::sort(num.begin(), num.end());
        
        for (int i = 0; i < num.size(); i++) {
            // 找出相反数
            int target = -num[i];
            int front = i + 1;
            int back = num.size() - 1;
            
            while (front < back) {
                
                int sum = num[front] + num[back];
                
                // Finding answer which start from number num[i]
                if (sum < target)
                    front++;
                
                else if (sum > target)
                    back--;
                
                else {
                    vector<int> triplet(3, 0);
                    triplet[0] = num[i];
                    triplet[1] = num[front];
                    triplet[2] = num[back];
                    res.push_back(triplet);
                    
                    // Processing duplicates of Number 2
                    // Rolling the front pointer to the next different number forwards
                    while (front < back && num[front] == triplet[1]) front++;
                    
                    // Processing duplicates of Number 3
                    // Rolling the back pointer to the next different number backwards
                    while (front < back && num[back] == triplet[2]) back--;
                }
                
            }
            
            // Processing duplicates of Number 1
            while (i + 1 < num.size() && num[i + 1] == num[i]) 
                i++;
            
        }
        
        return res;
        
    }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    
    int myarray[]= {1,-2,2,-3,4,5,-5,5,6,7,7,8};
    int len_myarray= sizeof(myarray)/sizeof(myarray[0]);
    vector<int> myvector(myarray , myarray+len_myarray);
//    cout << myvector[-1] << endl;  // zz 是有乱七八糟的值的
    
    std::cout << "结果为：\n";
    Solution sol;
    
    vector<vector<int>> res = sol.threeSum(myvector);
    
    for (int i=0; i<res.size() ; i++)
    {
        for (int j=0; j < res[i].size(); j++)
            cout << res[i][j] << " ";
        
        cout << endl;
    }
//    cout<<res.size()<<endl;
    
    return 0;
}
