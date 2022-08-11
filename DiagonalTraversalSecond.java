import java.util.Arrays;

class DiagonalTraversalSecond {
    public static void main(String[] args) {
        int[][] input = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
        traverse(input);
    }

    static int[] traverse(int[][] mat) {
        int totalNumberOfRows = mat.length;
        int totalNumberOfCols = mat[0].length;
        int[] output = new int[totalNumberOfRows * totalNumberOfCols];
        int row = 0;
        int col = 0;
        int newColStart = 0;
        int newRowStart = 0;
        int diagonal = 1;
        int iteration = 0;

        while (row + col <= (totalNumberOfCols - 1 + totalNumberOfRows - 1)) {
            col = newColStart;
            row = newRowStart;
            if (diagonal % 2 != 0) { // going up
                System.out.println(diagonal);
                while (row >= 0 && col <= totalNumberOfCols - 1) {
                    System.out.printf("row: %d, col: %d, value: %d\n", row, col, mat[row][col]);
                    output[iteration] = mat[row][col];
                    iteration++;
                    col++;
                    row--;
                }
                row++;
                if (col == totalNumberOfCols) {
                    newColStart = totalNumberOfCols - 1;
                }

                if (col != totalNumberOfCols) {
                    newColStart = col;
                    newRowStart = 0;
                } else {
                    newRowStart = row + 1;
                }
            } else {
                System.out.println(diagonal);
                // going down
                while (col >= 0 && row <= totalNumberOfRows - 1) {
                    System.out.printf("row: %d, col: %d, value: %d\n", row, col, mat[row][col]);
                    output[iteration] = mat[row][col];
                    iteration++;
                    row++;
                    col--;
                }
                col++; // reset col

                if (row == totalNumberOfRows) {
                    newRowStart = totalNumberOfRows - 1;
                }

                if (row != totalNumberOfRows) {
                    newRowStart = row;
                    newColStart = 0;
                } else {
                    newColStart = col + 1;
                }
            }
            diagonal++;

        }

        System.out.println(Arrays.toString(output));
        return output;
    }
}