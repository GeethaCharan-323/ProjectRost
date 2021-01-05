package Sorts;

import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=input.nextInt();
        }
        qSort(array,0,n-1);
        System.out.println("Sorted Array of Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void qSort(int[]array,int lower,int upper){
        if(lower>=upper) return;
        int p=partition(array,lower,upper);
        qSort(array,lower,p-1);
        qSort(array,p+1,upper);
    }
    public static int partition(int[] array,int lower,int upper){
        int pivot = array[upper];//upper value as pivot
        int j=lower;
        for (int i = lower; i <=upper; i++) {
            if(array[i]<pivot){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                j++;
            }
        }
        int temp = array[upper];
        array[upper]=array[j];
        array[j]=temp;
        return j;
    }
}
