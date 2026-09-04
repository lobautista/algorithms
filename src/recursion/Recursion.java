package recursion;

import java.util.Arrays;

public class Recursion {
    private static void printDown(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDown(n - 1);
    }

    private static void printUp(int n) {
        if (n == 0) {
            return;
        }
        printUp(n - 1);
        System.out.println(n);
    }

    private static int sum (int [] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        return nums[index] + sum(nums, index + 1);
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void dfs(int [][] matrix, boolean [][] visited, int row, int col) {
        if (row < 0
        || row >= matrix.length
        || col < 0
        || col >= matrix[0].length
        || visited[row][col]
        || matrix[row][col] != 1) {

            visited[row][col] = true;
            dfs(matrix, visited, row + 1, col);
            dfs(matrix, visited, row - 1, col);
            dfs(matrix, visited, row, col + 1);
            dfs(matrix, visited, row, col - 1);

        }
    }

    private static int [][] floodFill(int [][] image, int row, int col, int newColor) {
        int originalColor = image[row][col];
        if (originalColor == newColor) {
            return image;
        }
        floodFillDfs(image, row, col, originalColor, newColor);
        return image;
    }

    private static void floodFillDfs(int [][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0
                || row >= image.length
                || col < 0
                || col >= image[0].length
                || image[row][col] != originalColor) {
            return;
        }
        image[row][col] = newColor;
        floodFillDfs(image, row + 1, col, originalColor, newColor);
        floodFillDfs(image, row - 1, col, originalColor, newColor);
        floodFillDfs(image, row, col + 1, originalColor, newColor);
        floodFillDfs(image, row, col - 1, originalColor, newColor);
    }

    private static void numberOfIslandsDfs(char [][] grid, int row, int col) {
        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length
                || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        numberOfIslandsDfs(grid, row - 1, col);
        numberOfIslandsDfs(grid, row + 1, col);
        numberOfIslandsDfs(grid, row, col - 1);
        numberOfIslandsDfs(grid, row, col + 1);
    }

    private static int numberOfIslands(char [][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[row].length; col ++) {
                if (grid[row][col] == '1') {
                    islands ++;
                    numberOfIslandsDfs(grid, row, col);
                }

            }
        }
        return islands;
    }

    private static int maxArea(int [][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[row].length; col ++) {
                if (grid[row][col] == 1) {
                    max = Math.max(maxAreaDfs(grid, row, col), max);
                }
            }
        }
        return max;
    }

    private static int maxAreaDfs(int [][] grid, int row, int col) {
        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + maxAreaDfs(grid, row - 1, col)
                + maxAreaDfs(grid, row + 1, col)
                + maxAreaDfs(grid, row, col - 1)
                + maxAreaDfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        //printDown(5);
        //printUp(5);
        //int [] nums = { 2, 4, 6, 8 };
        //System.out.println(sum(nums, 0));
        //System.out.println(fibonacci(6));
        int [][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},

        };

        char [][] islands = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},

        };

        int [][] islands2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
        };
        //floodFill(image, 1, 1,  2);
        //System.out.println(numberOfIslands(islands));
        System.out.println(maxArea(islands2));
    }
}
