package CSA.Homework3;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        Compute computer;
        computer = new Add();
        UseCompute.useCom(computer,20,5);
        computer = new Subtract();
        UseCompute.useCom(computer,20,5);
        computer = new Multiply();
        UseCompute.useCom(computer,20,5);
        computer = new Divide();
        UseCompute.useCom(computer,20,5);

        System.out.println("<-------第二题------->");
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("请输入一个分数");
            int n = in.nextInt();
            if (0 <= n&&n <= 100){
                System.out.println("分数是：" + n);
            }
            else
                throw new ScoreException("输入错误，分数必须在0-100之间");
        }
        catch(ScoreException e){
            System.out.println(e.getMessage());
        }

        System.out.println("<-------第三题------->");
        try {
            int n =in.nextInt();
            if(n < 0){
                throw new IllegalArgumentException();
            }
            System.out.println("你需要输入" + n + "个数");
            int a;
            double sum = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("请输入第" + (i + 1) + "个数");
                try {
                    a = in.nextInt();
                    if(a < 0){
                        throw new IllegalArgumentException();
                    }
                    sum += a;
                }
                catch (IllegalArgumentException e){
                    System.out.println("N 必须是正数或者 0,请重新输入");
                    i -= 1;
                }
            }
            System.out.println("平均数为：" + sum/n);
        }catch (IllegalArgumentException e) {
            System.out.println("请输入一个非负数");
        }finally {
            in.close();
        }


        System.out.println("<-------第四题------->");
        int year = 2003;
        int month = 8;
        int day = 12;
        Employee employee = new Employee();
        employee.setYear(year);
        employee.setMonth(month);
        employee.setDay(day);
        String name = "Xiao A";
        int salary = 5000;
        String number = "5201314";
        employee.setSalary(salary);
        employee.setName(name);
        employee.setNumber(number);
        employee.earnings();
        employee.toString();


        System.out.println("<-------第五题------->");
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        Test test = new Test();
        int sum = test.numMatch(S, words);
        System.out.println(sum);

    }

    public int numMatch(String S,String[] words){
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }
            else
                map.put(words[i], map.get(words[i]) + 1);
        }
        int sum = 0;
        for (String s : map.keySet()){
            int n = isSubsequence(S,s);
            if(n == 1){
                sum += map.get(s);
            }
        }
        return sum;
    }

    public int isSubsequence(String s,String t){
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        if(j == t.length()){
            return 1;
        }
        else return 0;
    }


}
interface Compute{
    int computer(int n, int m);
}

class Add implements Compute{
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}

class Subtract implements Compute{
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class Multiply implements Compute{
    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}

class Divide implements Compute{
    @Override
    public int computer(int n, int m) {
        return n / m;
    }
}

class UseCompute{
    public static void useCom(Compute com, int one, int two){
        System.out.println("调用的类是" + com.getClass().getName() + "，结果是" + com.computer(one, two));
    }
}


class ScoreException extends Exception{
    ScoreException(String message){
        super(message);
    }
}

class Employee extends MyDate{
    private String name;
    private String number;
    private int salary;
    MyDate birthday;


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void earnings(){
        System.out.println("我一个月工资为" + getSalary() + "rmb");
    }
    public String toString(){
        System.out.println("我的姓名是：" + getName() + "\n"
                        + "我的身份证号是：" + getNumber() + "\n"
                        + "我的生日是：" + getYear() +"年" + getMonth() + "月" + getDay() + "天");
        return null;
    }

}

abstract class MyDate{
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public abstract void earnings();
    public abstract String toString();

}


