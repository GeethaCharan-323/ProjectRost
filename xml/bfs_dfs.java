import java.util.*;

public class bfs_dfs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of vertices:");
        int n=input.nextInt();
        int[][]matrix= new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j]= input.nextInt();
            }
        }
        System.out.println("Enter Source vertex:");
        int source = input.nextInt();
        bfs(matrix,source);
        dfs(matrix,source);
    }

    private static void bfs(int[][] matrix, int source) {
        boolean [] visited = new boolean[matrix.length];
        visited[source]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        System.out.print("BFS: ");
        while(queue.isEmpty()==false){
            System.out.print(queue.peek()+" ");
            int x = queue.poll();
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[x][i]==1&&visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    private static void dfs(int[][] matrix, int source) {
        boolean [] visited= new boolean[matrix.length];
        visited[source]=true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        System.out.print("DFS:");
        System.out.print(source+" ");
        while (stack.isEmpty()==false){
            int x = stack.pop();
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[x][i]==1 && visited[i]==false){
                    stack.push(x);
                    visited[i]=true;
                    System.out.print(i+" ");
                    x=i;
                    i=-1;
                }
            }
        }
    }
}
