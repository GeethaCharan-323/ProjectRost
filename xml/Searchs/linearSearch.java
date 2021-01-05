package Searchs;

import java.util.Scanner;

public class linearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Elements:");
        int n= input.nextInt();
        System.out.println("Enter "+n+" Elements:");
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]= input.nextInt();
        }
        System.out.println("Enter the element to search:");
        int key=input.nextInt();
        for (int i = 0; i < n; i++) {
            if(key==array[i]){
                System.out.println("Element is found at array index "+i);
            }
            else
                System.out.println("Element not found");
        }
    }
}
