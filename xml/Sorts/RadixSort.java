package Sorts;

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=input.nextInt();
        }
        //first find max value
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<array[i]) {
                max=array[i];
            }
        }

        for (int d = 1; (max/d)>0; d=d*10) {
            cSort(array,d);
        }

        System.out.println("Sorted Array of Elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }

    }
    public static void cSort(int[] array,int d){
        int[] count= new int[10];
        int[] output= new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[(array[i]/d)%10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i]+=count[i-1];
        }
        for (int i = array.length-1; i>=0; i--) {
            output[count[(array[i]/d)%10]-1]=array[i];
            count[(array[i]/d)%10]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=output[i];
        }
    }
}
