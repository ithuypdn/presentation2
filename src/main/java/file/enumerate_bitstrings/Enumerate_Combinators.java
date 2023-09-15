/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file.enumerate_bitstrings;

import java.util.Scanner;

/**
 *
 * @author huypd
 */
public class Enumerate_Combinators {
    // thuật toán sinh tổ hợp kế tiếp
    public static boolean nextCombination(int[] arr, int n) { // arr: chứa cấu hình hiện tại
        int i = arr.length - 1; // xuất phát từ phần tử cuối của tổ hợp
        int k = arr.length; // lấy số phần tử của mảng
        while (i >= 0 && arr[i] == n - k + i + 1) { // tìm phần tử arr[i] đầu tiên khác n-k+i+1
            i--; // giảm i
        }
        if (i >= 0) { // nếu i chưa vượt quá phần tử trái cùng
            arr[i] = arr[i] + 1; // thay x[i] = x[i]+1
            for (int j = i + 1; j < k; j++) { // cập nhật các phần tử từ vị trí i+1 đến k
                arr[j] = arr[i] + j - i; // gán arr[j] = arr[i] + j - i
            }
            return false; // thông báo cho nơi gọi biết đây chưa phải cấu hình cuối
        } else {
            return true; // thông báo cho nơi gọi biết đây là cấu hình cuối cùng
        }
    }

    // thuật toán sinh tổ hợp chập k của n
    public static void generate(int[] arr, int n) {
        boolean isFinalConfig = false; // biến đánh dấu cấu hình cuối
        while (!isFinalConfig) { // lặp chừng nào chưa đến cấu hình cuối
            output(arr); // hiển thị cấu hình hiện tại
            isFinalConfig = nextCombination(arr, n); // sinh cấu hình tiếp theo
        }
    }

    private static void output(int[] arr) {
        for (var e : arr) {
            System.out.printf("%5d", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = i + 1;
        }
        System.out.printf("Các tổ hợp C(%d, %d): \n", k, n);
        generate(arr, n);
    }
}
