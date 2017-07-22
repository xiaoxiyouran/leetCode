package cookie.com;

import java.util.Arrays;

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
public class Solution {
     public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            
            if (strs!= null && strs.length > 0){
                // 先排序，只用比较第一个和最后一个即可
                Arrays.sort(strs);
                
                System.out.println(strs[0]+strs[1]+strs[2]);
                
                char [] a = strs[0].toCharArray();
                char [] b = strs[strs.length-1].toCharArray();
                
                for (int i = 0; i < a.length; i ++){
                    if (b.length > i && b[i] == a[i]){
                        result.append(b[i]);
                    }
                    else {
                        return result.toString();
                    }
                }
            }
            return result.toString();
        }

    
    public static void main( String[] args ){
        // int[] array = {1,2,3,4,5};
        // 匿名对象：
        // 1.匿名对象是没有别其它对象所引用
        // 2.使用一次就变成垃圾了，被垃圾回收器收回了
        // System.out.println("结果是:"+new Solution().maxArea(array));
        String [] arr = {"abc","abcd","abe"};
         System.out.println("结果是:"+new Solution().longestCommonPrefix(arr));

    }

};

