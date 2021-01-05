import java.util.Scanner;

public class prims {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter No.of Vertices:");
        int n= input.nextInt();
        int [][]matrix = new int[n][n];
        int []visited = new int[n];
        System.out.println("Enter Adjacency Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]= input.nextInt();
                if(matrix[i][j]==0)
                    matrix[i][j]=Integer.MAX_VALUE;
            }
            visited[i]=0;
        }
        //visited[0]=1;
        int u=0,v=0,total=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(min>matrix[i][j]) {
                    min=matrix[i][j];
                    u=i;
                    v=j;
                }
            }
        }
        visited[u]=1;
        visited[v]=1;
        total+=min;
        System.out.println("EDGE: "+u+" -- "+v+" WEIGHT: "+min);


        for (int k = 1; k < n-1; k++) {
            min=Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(visited[i]==1){
                    for (int j = 0; j < n; j++) {
                        if(visited[j]!=1){
                            if(min>matrix[i][j]){
                                min=matrix[i][j];
                                u=i;
                                v=j;
                            }
                        }
                    }
                }
            }
            visited[u]=1;
            visited[v]=1;
            total+=min;
            System.out.println("EDGE: "+u+" -- "+v+" WEIGHT: "+min);
        }
        System.out.println("Total Cost: "+total);
    }
}
