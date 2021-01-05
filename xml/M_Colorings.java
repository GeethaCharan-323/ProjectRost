import java.util.*;
import java.lang.*;

public class M_Colorings{
    static int n;
    static int nc;
    static int[][]matrix;
    static int[] result;

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter No.of Vertices:");
        n= input.nextInt();
        System.out.print("Enter No.of Colors:");
        nc= input.nextInt();
        System.out.println("Enter the Adjacency Matrix:");
        matrix=new int[n][n];
        result= new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=input.nextInt();
            }
        }
        System.out.println("Solution:");
        if(solve(0,1)){
            for(int i=0;i<n;i++){
                if(result[i]==0){
                    System.out.println("NOT POSSIBLE");
                    System.exit(0);
                }
            }
            for(int i=0;i<n;i++)
                System.out.println("Vertex "+i+"-- Color "+result[i]);
        }
    }

    public static boolean solve(int index,int color){
        if(index==n-1){
            result[index]=color;
            return true;
        }
        result[index]=color;
        for(int i=0;i<n;i++){
            if(matrix[index][i]==1 && result[i]==0){
                int tempC=1;
                while(!isValidColor(i,tempC)) tempC++;
                if(tempC<=nc){
                    if(!solve(i,tempC)) result[index]=0;
                    else return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidColor(int index,int color){
        for(int i=0;i<n;i++){
            if(matrix[index][i]==1 && result[i]==color){
                return false;
            }
        }
        return true;
    }
}