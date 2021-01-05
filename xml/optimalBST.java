import java.util.Scanner;

public class optimalBST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No.of nodes:");
        int n=input.nextInt();
        int[] keys =new int[n];
        int[] freq =new int[n];

        System.out.println("Enter Keys:");
        for (int i = 0; i < n; i++) {
            keys[i]=input.nextInt();
        }
        System.out.println("Enter Frequencies:");
        for (int i = 0; i < n; i++) {
            freq[i]=input.nextInt();
        }
        System.out.println("Optimal Cost: "+optimal(freq,0,n-1));
    }

    public static int optimal(int[] freq, int i, int j) {
        if(j<i) return 0;
        if(j==i) return freq[i];
        int sum=0;
        for (int k = i; k <=j; k++) {
            sum+=freq[k];
        }
        int min=Integer.MAX_VALUE;
        for (int k = i; k <=j ; k++) {
            int cost=optimal(freq,i,k-1)+optimal(freq,k+1,j);
            if(cost<min) min=cost;
        }
        return min+sum;
    }
}
