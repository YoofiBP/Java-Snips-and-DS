import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
        int[][] input2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        List<Integer> result = traverse(input2);
        System.out.println(result);
    }

    static List<Integer> traverse(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        int numCols = matrix[0].length;
        int numRows = matrix.length;
        int overMax = 101;

        result.add(matrix[row][col]);
        matrix[row][col] = overMax;

        while (result.size() < numCols * numRows) {
            // go all the way right
            while (col < numCols - 1 && matrix[row][col + 1] != overMax) {
                col++;
                result.add(matrix[row][col]);
                matrix[row][col] = overMax;
            }

            // go down
            while (row < numRows - 1 && matrix[row + 1][col] != overMax) {
                row++;
                result.add(matrix[row][col]);
                matrix[row][col] = overMax;
            }

            // go left
            while (col > 0 && matrix[row][col - 1] != overMax) {
                col--;
                result.add(matrix[row][col]);
                matrix[row][col] = overMax;
            }

            // go up
            while (row > 0 && matrix[row - 1][col] != overMax) {
                row--;
                result.add(matrix[row][col]);
                matrix[row][col] = overMax;
            }
        }
        return result;
    }
}