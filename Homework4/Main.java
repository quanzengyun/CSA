package CSA.Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("<-------第一题------->");
        System.out.println("见源代码reverse函数");

        System.out.println("<-------第二题------->");
        int  n = in.nextInt();
        int sum = climbStairs(n);
        System.out.println("共有" + sum + "钟方法可以爬到楼顶");


        System.out.println("<-------第三题------->");
        int[] nums = {1,2,3};
        Solution solution = new Solution();

        List<List<Integer>> res = new ArrayList<>();
        res = solution.subsets(nums);
        System.out.println(res);


    }

//    第一题
    public static int reverse(int x){
        try{
            StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
            x = x>0 ? Integer.valueOf(String.valueOf(sb.reverse())) : -1*Integer.valueOf(String.valueOf(sb.reverse()));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
        return x;
    }

//    第二题
    public static int climbStairs(int n){
        int numMax = 0;
        int num1 = 1;
        int num2 = 2;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //类似为斐波那契数列
        for (int i =3; i<=n; i++){
            numMax = num1 + num2;
            num1 = num2;
            num2 = numMax;
        }
        return numMax;
    }



}
//    回溯算法求子集
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        int pos = 0;
        List<Integer> list = new ArrayList<>();
        huisu(nums, pos, list);
        return res;
    }

    public void huisu(int[] nums, int pos, List<Integer> list) {
        if (pos == nums.length && !list.isEmpty()) {
            res.add(new ArrayList(list));
        }
        if (pos < nums.length) {
            //将pos元素放入
            list.add(nums[pos]);
            //对pos后的元素进行选择
            huisu(nums, pos + 1, list);
            //不将pos元素放入,除去pos对应的元素
            list.remove(list.indexOf(nums[pos]));
            //对pos后的元素进行选择
            huisu(nums, pos + 1, list);
        }
    }
}