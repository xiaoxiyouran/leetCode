package cookie.com;

import java.util.Arrays;
import java.util.LinkedList;

//import java.lang.Math;   // Math.max()方法
// ----------------------------------------------------
// Java 使用数组的几种方式
// 1-声明数组
/*int[] a;  // 或 int a[];  String[] name; // 字符串
 * a = new int[10];  // name = new String[30];
 * 2-初始化
 * int[] score={89,79,76};
 * int[] score=new int[]{89,79,76};   // 注：第2个int不能指定数组长度
 * 
 * ------------------------
 * 错误的初始化
 * 错误-1
 * int []score;
 * score={89,79,76};  // 这个只能在一行写
 * 
 * 错误-2
 * int[] score=new int[];  // 没有指明数组长度
 * 
 * 3-动态从键盘获取，并给数组赋初值
 * Scanner input = new Scanner(System.in);
 * for(int i=0; i<30;i++ )
 * {
 *      score[i] = input.nextInt();
 * }
 */

import java.util.List;
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();  // LinkedList 是List 接口链表的实现，在插入和删除优于ArrayList
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }

    
    public static void main( String[] args ){
        // int[] array = {1,2,3,4,5};
        // 匿名对象：
        // 1.匿名对象是没有别其它对象所引用
        // 2.使用一次就变成垃圾了，被垃圾回收器收回了
        // System.out.println("结果是:"+new Solution().maxArea(array));
        // String [] arr = {"abc","abcd","abe"};
        
            int [] input = {-5, -3, -2, 1, 2, 4, 5, 5, 6, 7, 7, 8};
            List<List<Integer>> res = new Solution().threeSum(input);
            
//          for (Iterator<List<Integer>> iterator = res.iterator(); iterator.hasNext();) {
//              List list1 = iterator.next();
            
            for(List list1: res)
            {
                for(Object list2: list1) // 最底下的一层必须是Object对象输出
                    System.out.print(list2 + " ");
                
                System.out.println(" ");   // 输出一个换行符
            }
//          System.out.println("结果是:"+longestCommonPrefix(arr));
            System.out.println("List的长度是："+res.size());

    }

};

