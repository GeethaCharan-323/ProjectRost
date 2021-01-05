import java.util.Scanner;

public class knapsack {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter No.of Items:");
        int n= input.nextInt();
        int[] weights = new int[n];
        int[] values= new int[n];
        System.out.println("Enter the weights:");
        for (int i = 0; i <n ; i++) {
            weights[i]=input.nextInt();
        }
        System.out.println("Enter the values:");
        for (int i = 0; i <n ; i++) {
            values[i]=input.nextInt();
        }
        System.out.println("Enter the Capacity of Knapsack:");
        int cap=input.nextInt();

        int [][]dp = new int[n+1][cap+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(j>=weights[i-1]){
                    int reCap=j-weights[i-1];
                    if(dp[i-1][reCap]+values[i-1]>dp[i-1][j]){
                        dp[i][j]=dp[i-1][reCap]+values[i-1];
                    }
                    else dp[i][j]=dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j];

            }
        }
        System.out.println("Max Cap:"+dp[n][cap]);

    }
}
