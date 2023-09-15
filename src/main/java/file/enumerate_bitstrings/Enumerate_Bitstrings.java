/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package file.enumerate_bitstrings;

import java.util.Scanner;
/**
 *
 * @author huypd
 */
public class Enumerate_Bitstrings {
    private static boolean nextBinaryString(int[] arr) {
        int i = arr.length - 1;
        while (i >= 0 && arr[i] != 0) {
            arr[i] = 0;
            i--;
        }
        if (i >= 0) {
            arr[i] = 1;
            return false;
        } else {
            return true;
        }
    }

    public static void generate(int[] arr) {
        boolean isFinal = false;
        while (!isFinal) {
            output(arr);
            isFinal = nextBinaryString(arr);
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.println("Nhập n: ");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[] arr = new int[n];
        generate(arr);
    }

    private static void output(int[] arr) {
        for (var e : arr) {
            System.out.printf("%5d", e);
        }
        System.out.println();
    }
}
