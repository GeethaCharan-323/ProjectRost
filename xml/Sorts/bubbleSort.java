package Sorts;

import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=input.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                if (array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println("Sorted Array of Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
