package SJJG.Sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] number = { 13, 15, 24, 99, 4, 1 };
        System.out.println("排序前：");
        for (int val : number) { // 遍历数组元素
            System.out.print(val + " "); // 输出数组元素
        }
        int temp, j;
        for (int i = 1; i < number.length; i++) {
            temp = number[i];
            for (j = i - 1; j >= 0 && number[j] > temp; j--) {
                number[j + 1] = number[j];
            }
            number[j + 1] = temp;
        }
        System.out.println("\n排序后：");
        for (int val : number) { // 遍历数组元素
            System.out.print(val + " "); // 输出数组元素
        }
    }
}
