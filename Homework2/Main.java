package CSA.Homework2;

import java.awt.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        //第一题
        Monkey monkey = new Monkey("a");
        System.out.println(monkey.name);
        monkey.speak();
        People people = new People("xiao A");
        System.out.println(people.name);
        people.speak();
        people.think();



        System.out.println("<-------第二题------->");
        //第二题
        Car car1 = new Car(3);
        car1.speak();
        car1.sayLoader();
        Truck truck1 = new Truck(1,3000.0);
        truck1.speak();
        truck1.sayLoader();
        truck1.sayPayload();
        Car car2 = new Car(6);
        car2.speak();
        car2.sayLoader();
        Truck truck2 = new Truck(1,7000.0);
        truck2.speak();
        truck2.sayLoader();
        truck2.sayPayload();



        System.out.println("<-------第三题------->");
        //第三题
        String a,b,c;
        a = "88888888888888888";
        b = "25461213124533465";
        System.out.println("a=" + "88888888888888888" + ",B=" + "25461213124533465");
        c = getSum(a,b);
        System.out.println("c=" + c);
        a = "13829579081298345918257";
        b = "438823897418920918472193";
        System.out.println("a=" + "13829579081298345918257" + ",B=" + "438823897418920918472193");
        c = getSum(a,b);
        System.out.println("c=" + c);



        System.out.println("<-------第四题------->");
        //第四题
        int m = 3;
        int n = 7;
        uniquePaths(m,n);


        System.out.println("<-------第五题------->");
        //第五题
        String[] strs = new String[]{"f1ower","f1ow","f1ight"};
        String ans = longestCommonPrefix(strs);
        if (ans == ""){
            System.out.println("输入不存在公共前缀。");
        }
        else
            System.out.println(ans);

        strs = new String[]{"dog","racecar'","car"};
        ans = longestCommonPrefix(strs);
        if (ans.equals("")){
            System.out.println("输入不存在公共前缀。");
        }
        else
            System.out.println(ans);

    }

    //第三题格式要求,在TODO部分实现代码
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c="";
        for(int i=a.length()-1;i>=0;--i){
            la.add(a.charAt(i)-'0');
        }
        for(int i=b.length()-1;i>=0;--i){
            lb.add(b.charAt(i)-'0');
        }
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        int len = Math.max(a.length(),b.length());
        if(a.length() < len){
            for (int i = 1; i <=len-a.length() ; i++) {
                la.add(0);
            }
        }
        if(b.length() < len){
            for (int i = 1; i <=len-b.length() ; i++) {
                lb .add(0);
            }
        }
        int lc[] = new int[len+1];
        for(int i = 0;i<len;i++){
            lc[i] = la.get(i) + lb.get(i);
        }
        for(int i = 0;i<len;i++){
            lc[i+1] = lc[i+1] + lc[i]/10;
            lc[i] = lc[i]%10;
        }
        for(int i = 0; i < lc.length/2; i++) {
            // 把数组中的元素收尾交换
            int temp = lc[i];
            lc[i] = lc[lc.length - i - 1];
            lc[lc.length - i - 1] = temp;
        }


        if(lc[0]==0) {
            for (int i = 1; i < lc.length; i++) {
                c += lc[i];
            }
        }else {
            for (int i = 0; i < lc.length; i++) {
                c += lc[i];
            }
        }
        return c;
    }

    public static int uniquePaths(int m, int n) {
    //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        int[] sum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0){
                    sum[j]+=1;
                }
                if(i != 0&&j != 0){
                    sum[j] += sum[j-1];
                }
            }
        }
        System.out.println(sum[sum.length-1]);
        return 0;
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        //TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        if(strs.length == 0){
            return "";
        }
        ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (;j < ans.length()&&j < strs[i].length();j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if(ans.equals("")){
                return ans;
            }
        }
        return ans;
    }


}


class Monkey{
    public String name;
    Monkey(String s){
        name = s;
    }

    Monkey() {
    }

    public void speak(){
        System.out.println("咿咿呀呀......");
    }
}

class People extends Monkey{
    People(String s){
        name = s;
    }
    public void speak(){
        System.out.println(" 小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println(" 别说话！认真思考！");
    }
}

class Vehicle{
    int wheels;
    double weight;
    Vehicle(){}
}

class Car extends Vehicle{
    int loader;
    Car(int num){
        loader = num;
        wheels = 4;
        weight = 1150.0;
    }
    public void speak(){
        System.out.println("车轮的个数是: " + wheels +" 车重: " + weight);
    }
    public void sayLoader(){
        if(loader >= 6 ){
            System.out.println("这是一辆小车,能载6人,实载" + loader + "人,你超员了！！！");
        }
        else
            System.out.println("这是一辆小车,能载6人,实载" + loader + "人");
    }
}

class Truck extends Vehicle{
    int loader;
    double payload;
    Truck(int num, double w){
        wheels = 6;
        weight = 15000.0;
        loader = num;
        payload = w;
    }
    public void speak(){
        System.out.println("车轮的个数是: " + wheels +" 车重: " + weight);
    }
    public void sayLoader(){
        if(loader >= 3 ){
            System.out.println("这是一辆卡车,能载3人,实载" + loader + "人,你超员了！！！");
        }
        else
            System.out.println("这是一辆卡车,能载3人,实载" + loader + "人");
    }
    public void sayPayload(){
        if(payload >= 5000 ){
            System.out.println("这是一辆卡车,核载5000kg,你已装载" + payload + "kg,你超载了！！！");
        }
        else
            System.out.println("这是一辆卡车,核载5000kg,你已装载" + payload + "kg");
    }
}
