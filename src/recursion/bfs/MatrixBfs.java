package recursion.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class MatrixBfs {
    public static void bfs(int[][] grid, int row, int col) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new ArrayDeque<>();

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };

        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int level = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            System.out.print("Level " + level + ": ");

            for (int i = 0; i < levelSize; i++) {

                int[] current = queue.poll();

                int currentRow = current[0];
                int currentCol = current[1];

                System.out.print(
                        "(" + currentRow + "," + currentCol + ") "
                );

                for (int[] direction : directions) {

                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if (newRow >= 0
                            && newRow < grid.length
                            && newCol >= 0
                            && newCol < grid[0].length
                            && !visited[newRow][newCol]) {

                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        bfs(matrix, 1, 1);
    }
}
