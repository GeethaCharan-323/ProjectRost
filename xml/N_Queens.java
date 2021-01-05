import java.util.Scanner;

public class N_Queens {
    static int n;
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter N:");
        n=input.nextInt();
        int[][] board=new int[n][n];
        if(!theBoardSolver(board, 0)){
            System.out.println("Solution Not Found");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==1)
                    System.out.print("Q ");
                else System.out.print("_ ");
            }
            System.out.println();
        }
    }

    private static boolean theBoardSolver(int[][] board, int col) {
        if(col>=n) return true;
        for (int i = 0; i < n; i++) {
            if(toPlaceOrNotToPlace(board,i,col)){
                board[i][col]=1;
                if(theBoardSolver(board,col+1))
                    return true;
                board[i][col]=0;
            }
        }
        return false;
    }

    private static boolean toPlaceOrNotToPlace(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {        //if a queen is present in row
            if (board[row][i]==1) return false;
        }
        for (int i = 0; i < row; i++) {        //if a queen is present in column
            if(board[i][col]==1) return false;
        }
        for (int i = row,j=col; i>=0 && j>=0 ; i--,j--) {
            if (board[i][j]==1) return false;
        }
        for (int i = row,j=col; i<n && j>=0 ; i++,j--) {
            if (board[i][j]==1) return false;
        }
        return true;
    }
}
