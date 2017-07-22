package cookie.com;
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
    public int romanToInt(String s) {
        int nums[] = new int[s.length()];   //创建一个和字符串等长的一个整型数组
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
        
    }

    
    public static void main( String[] args ){
        // int[] array = {1,2,3,4,5};
        // 匿名对象：
        // 1.匿名对象是没有别其它对象所引用
        // 2.使用一次就变成垃圾了，被垃圾回收器收回了
        // System.out.println("结果是:"+new Solution().maxArea(array));
         System.out.println("结果是:"+new Solution().romanToInt("VI"));

    }
};

