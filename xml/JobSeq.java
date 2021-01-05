import java.util.Scanner;

public class JobSeq{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter No.of jobs:");
        int n=input.nextInt();
        int []profits=new int[n];
        int []deadlines=new int[n];
        int []jobs=new int[n];
        for (int i = 0; i <n ; i++) {
            System.out.print("Enter the profit and deadline of job "+i+" ");
            profits[i]=input.nextInt();
            deadlines[i]=input.nextInt();
            jobs[i]=i;
        }
        for (int i = 0; i <n-1; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                if(profits[j]<profits[j+1]){
                    int temp=profits[j];
                    profits[j]=profits[j+1];   //swapping profits, deadlines,jobs
                    profits[j+1]=temp;

                    temp=deadlines[j];
                    deadlines[j]=deadlines[j+1];
                    deadlines[j+1]=temp;

                    temp=jobs[j];
                    jobs[j]=jobs[j+1];
                    jobs[j+1]=temp;
                }
            }
        }

        int max=0;
        for (int i = 0; i < n ; i++) {
            if(max<deadlines[i]){
                max=deadlines[i];   //to find the limit of time slot
            }
        }

        int result[]=new int[max]; //one job in each slot of timeline

        for (int i = max-1; i>=0 ; i--) {
            for (int j = 0; j <n ; j++) {
                if(deadlines[j]>=i+1 && result[i]<profits[j]){
                    result[i]=profits[j];
                    profits[j]=0;
                    deadlines[j]=0;
                    System.out.println("TimeSlot "+i+"-- Job"+jobs[j]);
                }
            }
        }

        int total=0;
        for (int i = 0; i <max ; i++) {
            total+=result[i];      //total profit
        }
        System.out.println("Total Profit is "+total);
    }
}