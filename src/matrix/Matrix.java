package matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Matrix {
    private static void printMatrixByRow(int [][] matrix) {
        System.out.println("Imprimir por file");
        for (int row = 0; row < matrix.length; row ++) {
            for (int column = 0; column < matrix[row].length; column ++) {
                System.out.println(matrix[row][column]);
            }
        }
    }

    private static void printByColumn(int [][] matrix) {
        for (int col = 0; col < matrix[0].length; col ++) {
            for (int row = 0; row < matrix.length; row ++) {
                System.out.println(matrix[row][col]);
            }
        }
    }

    private static void printByColumnJagged(int[][] matrix) {
        int maxColumns = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length > maxColumns) {
                maxColumns = matrix[row].length;
            }
        }

        for (int col = 0; col < maxColumns; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (col < matrix[row].length) {
                    System.out.println(matrix[row][col]);
                }
            }
        }
    }

    private static void printByFirstDiagonal(int [][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            System.out.println(matrix[i][i]);
        }
    }

    private static void printBySecondDiagonal(int [][] matrix) {
        //int col = matrix[0].length - 1;
        //for (int row = 0; row < matrix.length; row ++) {
        //    System.out.println(matrix[row][col]);
        //    col --;
        //}

        /*
        [0, 3] = 3 (n-1)
        [1, 2] = 3 (n-1)
        [2, 1] = 3 (n-1)
        [3, 0] = 3 (n-1)

        raw + col = n - 1
        col = n - 1 - row
        */

        for (int row = 0; row < matrix.length; row ++) {
            int col = matrix.length - 1 - row;
            System.out.println(matrix[row][col]);
        }
    }

    private static void printExcludingDiagonals(int [][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                if (!(col == row || col == matrix.length - 1 - row)) {
                    System.out.println(matrix[row][col]);
                }
            }
        }
    }

    private static void printBorderNumbers(int [][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                if (row > 0
                        && col > 0
                        && row < matrix.length - 1
                        && col < matrix[row].length - 1) {
                    continue;
                }
                System.out.println(matrix[row][col]);
            }
        }
    }

    private static void printBorderNumbers2(int [][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                if (row == 0
                        || col == 0
                        || row == matrix.length - 1
                        || col == matrix[row].length - 1) {
                    System.out.println(matrix[row][col]);
                }

            }
        }
    }

    private static void printClock(int [][] matrix) {
        int row = 0;
        int col = 0;
        while (col < matrix[0].length) {
            System.out.println(matrix[row][col]);
            col ++;
        }
        row ++;
        col --;
        while (row < matrix.length) {
            System.out.println(matrix[row][col]);
            row ++;
        }
        row --;
        col --;
        while (col >= 0) {
            System.out.println(matrix[row][col]);
            col --;
        }
        row --;
        col ++;
        while (row > 0) {
            System.out.println(matrix[row][col]);
            row --;
        }
    }

    private static void printAround(int [][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        for (int col = left; col <= right; col ++) {
            System.out.println(matrix[top][col]);
        }
        for (int row = top + 1; row <= bottom; row ++) {
            System.out.println(matrix[row][right]);
        }
        for (int col = right; col >= left; col --) {
            System.out.println(matrix[bottom][col]);
        }
        for (int row = bottom - 1; row > top; row -- ) {
            System.out.println(matrix[row][left]);
        }
    }

    private static void printSpiral(int [][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col ++) {
                System.out.println(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row ++) {
                System.out.println(matrix[row][right]);
            }
            if (top < bottom) {
                for (int col = right - 1; col >= left; col --) {
                    System.out.println(matrix[bottom][col]);
                }
            }

            if (left < right) {
                for (int row = bottom - 1; row > top; row -- ) {
                    System.out.println(matrix[row][left]);
                }
            }

            top ++;
            bottom --;
            right --;
            left ++;
        }
    }

    private static void printNeighbor (int [][] matrix, int row, int col) {
        System.out.println(matrix[row - 1][col]);
        System.out.println(matrix[row + 1][col]);
        System.out.println(matrix[row][col + 1]);
        System.out.println(matrix[row][col - 1]);
    }

    private static void printNeighbor2(int [][] matrix, int row, int col) {
        int top = row - 1;
        int bottom = row + 1;
        int left = col - 1;
        int right = col + 1;
        int topBorder = 0;
        int bottomBorder = matrix.length - 1;
        int rightBorder = matrix[0].length - 1;
        int leftBorder = 0;

        if (top >= topBorder) {
            System.out.println(matrix[top][col]);
        }
        if (bottom <= bottomBorder) {
            System.out.println(matrix[bottom][col]);
        }
        if (right <= rightBorder) {
            System.out.println(matrix[row][right]);
        }
        if (left >= leftBorder) {
            System.out.println(matrix[row][left]);
        }
    }

    private static void printNeighbor3(int [][] matrix, int row, int col){
        int [][] directions = {
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };
        for (int [] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if ((newRow >= 0 && newRow < matrix.length)
            && (newCol >= 0 && newCol < matrix[0].length)) {
                System.out.println(matrix[newRow][newCol]);
            }

        }
    }

    private static void printDirection(int [][] matrix, int row, int col, int [] direction) {
        row += direction[0];
        col += direction[1];
        while (row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length) {
            System.out.println(matrix[row][col]);
            row += direction[0];
            col += direction[1];
        }
    }

    private static void printDirections(int [][] matrix, int row, int col) {
        int [][] directions = {
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };
        for (int [] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            while (newRow >= 0 && newRow < matrix.length
            && newCol >= 0 && newCol < matrix[newRow].length) {
                System.out.println(matrix[newRow][newCol]);
                newRow += direction[0];
                newCol += direction[1];
            }
        }
    }

    private static int[][] transpose(int [][] matrix) {
        int [][] newMatrix = new int [matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                newMatrix[col][row] = matrix[row][col];
            }
        }
        return newMatrix;
    }

    private static void transposeInPlace (int [][] matrix) {
        int temp;
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = row + 1; col < matrix[row].length; col ++) {
                temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }

    private static void reflectHorizontally (int [][] matrix) {
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length / 2; col ++) {
                int newCol = matrix[row].length - 1 - col;
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][newCol];
                matrix[row][newCol] = temp;
            }
        }
        System.out.println("Done");
    }

    private static void rotate90ClockWise (int [][] matrix) {
        int temp;
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = row + 1; col < matrix[row].length; col ++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length / 2; col ++) {
                int newCol = matrix[row].length - 1 - col;
                temp = matrix[row][col];
                matrix[row][col] = matrix[row][newCol];
                matrix[row][newCol] = temp;
            }
        }
    }

    private static void setMatrixZeroes(int [][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[row].length; col ++) {
                if (rows.contains(row) || cols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private static void setMatrixZeroes2(int [][] matrix) {
        boolean firstRowContainsZeroes = false;
        boolean firstColumnContainsZeroes = false;
        for (int num: matrix[0]) {
            if (num == 0) {
                firstRowContainsZeroes = true;
            }
        }

        for (int [] row: matrix) {
            if (row[0] == 0) {
                firstColumnContainsZeroes = true;
            }
        }

        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row ++) {
            for (int col = 1; col < matrix[0].length; col ++){
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRowContainsZeroes) {
            for (int col = 0; col < matrix[0].length; col ++) {
                matrix[0][col] = 0;
            }
        }

        if (firstColumnContainsZeroes) {
            for (int row = 0; row < matrix.length; row ++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int [][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int [][] matrix2 = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int [][] matrix3 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        int[][] matrix4 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int [][] matrix5 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int [][] matrix6 = {
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int [][] matrix7 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int [][] matrix8 = {
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int [][] matrix9 = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };

        //printSpiral(matrix2);
        //printDirection(matrix4, 2, 2, new int []{0, 1});
        //printDirection(matrix4, 2, 2, new int[]{-1, 0});
        //printDirection(matrix4, 2, 2, new int[]{1, 1});
        setMatrixZeroes2(matrix9);
    }
}
