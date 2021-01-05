package Sorts;

import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=input.nextInt();
        }
        mergesort(array,0,n-1);
        System.out.println("Sorted Array of Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void mergesort(int[] array,int lower,int upper){
        if(lower>=upper)
            return;
        int m=(lower+upper)/2;
        mergesort(array,lower,m);
        mergesort(array,m+1,upper);
        merge(array,lower,upper);
    }
    public static void merge(int[] array,int lower,int upper){
        int m=(lower+upper)/2;
        int n1=m-lower+1; //left subarray size
        int n2=upper-m;   //right subarray size
        int left[]=new  int[n1+1];
        int right[]=new int[n2+1];

        for (int i = 0; i <n1 ; i++) {
            left[i]=array[lower+i];
        }
        left[n1]=Integer.MAX_VALUE; //one extra element in left subarray with maximum value
        for (int i = 0; i <n2 ; i++) {
            right [i]=array[m+1+i];
        }
        right[n2]=Integer.MAX_VALUE; //similarly in the right sub array
        int i=0,j=0;
        for (int k = lower; k <=upper ; k++) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
        }
    }
}
