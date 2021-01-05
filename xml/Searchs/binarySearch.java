package Searchs;

import java.util.Scanner;
import java.lang.*;

public class binarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]= input.nextInt();
        }
        System.out.println("Enter element to be searched:");
        int key = input.nextInt();
        binarySearch(array,key,0,n-1);
    }
    public static void binarySearch(int[] array,int key,int first,int last){
        int mid=(first+last)/2;
        while(first<=last){
            if(array[mid]==key) {
                System.out.println("Element found at index " + mid);
                System.exit(0);
            }
            else if(array[mid]<key)
                first=mid+1;
            else if(array[mid]>key)
                last=mid-1;
            mid=(first+last)/2;
        }
        System.out.println("Element Not Found");
    }
}
