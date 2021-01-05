import java.util.Scanner;

public class dijkstra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Vertices:");
        int n= input.nextInt();
        System.out.println("Enter the Adjacency Cost Matrix:");
        int [][]matrix = new int[n][n];
        int []distance = new int[n];
        int [] visited = new int[n];
        int [] preD =new int[n];
        for (int i = 0; i < n; i++) {
            visited[i]=0;
            preD[i]=0;
            for (int j = 0; j < n; j++) {
                matrix[i][j]=input.nextInt();
                if(matrix[i][j]==0) matrix[i][j]=999;
            }
        }

        for (int i = 0; i < n; i++) {
            distance[i]=matrix[0][i];
        }
        visited[0]=1;
        distance[0]=0;
        int u=0;
        for (int k = 0; k < n; k++) {
            int min=999;
            for (int i = 0; i < n; i++) {
                if(min>distance[i] && visited[i]!=1){
                    min=distance[i];
                    u=i;
                }
            }
            visited[u]=1;
            for (int i = 0; i < n; i++) {
                if (distance[i]>min+matrix[u][i] && visited[i]!=1){
                    distance[i]=min+matrix[u][i];
                    preD[i]=u;
                }
            }
        }

        int j=0;
        System.out.println("Shortest Paths:");
        for (int i = 0; i < n; i++) {
            if(i!=0){
                System.out.print(i+" = "+i);
                j=i;
                do{
                    j=preD[j];
                    System.out.print("<-"+j);
                }while(j!=0);
            }
            if(i!=0){
                System.out.println(" Distance "+distance[i]);
            }
        }
    }
}

