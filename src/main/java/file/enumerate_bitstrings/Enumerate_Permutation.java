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
public class Enumerate_Permutation { 
//   1 2 4 3
//     i   k
//   1 3 4 2
//       r s
//   1 3 2 4

    // thuật toán sinh hoán vị kế tiếp
    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2; // xuất phát từ phần tử trước phần tử cuối
        while (i >= 0 && arr[i] > arr[i + 1]) { // tìm i sao cho arr[i] < arr[i+1]
            i--;
        }
        if (i >= 0) { // nếu i chưa vượt quá phần tử trái cùng
            int k = arr.length - 1; // xuất phát từ phần tử phải cùng
            while (arr[i] > arr[k]) { // tìm k sao cho arr[k] > arr[i]
                k--;
            }
            // đổi chỗ hai phần tử tại vị trí i và k
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            int r = i + 1; // gán r = i + 1
            int s = arr.length - 1; // gán s = vị trí cuối mảng
            while (r < s) { // lật ngược đoạn từ j + 1 đến n
                int t = arr[r];
                arr[r] = arr[s];
                arr[s] = t;
                r++;
                s--;
            }
            return false; // trả về thông báo cấu hình chưa phải cuối cùng
        } else {
            return true; // trả về thông báo cấu hình cuối cùng
        }
    }

    // thuật toán sinh hoán vị chính tắc
    public static void generate(int[] arr) {
        boolean isFinalConfig = false;  // khởi tạo biến đánh dấu cấu hình cuối cùng
        while (!isFinalConfig) { // hiển thị tất cả các cấu hình hoán vị
            ouput(arr); // gọi hiển thị
            isFinalConfig = nextPermutation(arr); // sinh cấu hình kế tiếp
        }
    }

    private static void ouput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();
    }
    
//    private static void swap(int[] arr, int firstPos, int secondPos) {
//        int tmp = arr[firstPos];
//        arr[firstPos] = arr[secondPos];
//        arr[secondPos] = tmp;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = i+1;
        generate(arr);
    }
}
