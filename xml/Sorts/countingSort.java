package Sorts;

import java.util.Scanner;

public class countingSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n = input.nextInt();
        System.out.println("Enter " + n + " Elements:");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int [] count = new int[10];//for counting
        int [] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i]+=count[i-1];
        }
        for (int i = n-1; i>=0; i--) {
            output[count[array[i]]-1]=array[i];
            count[array[i]]--;
        }
        System.out.println("Sorted Values:");
        for (int i = 0; i < n; i++) {
            array[i]=output[i];
            System.out.println(array[i]+" ");
        }
    }
}
