import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> output = generate(7);
        System.out.println(output);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                result.add(List.of(1));
            } else if (i == 1) {
                result.add(List.of(1, 1));
            } else {
                List<Integer> nextResult = Arrays.asList(new Integer[i + 1]);
                nextResult.set(0, 1);
                nextResult.set(nextResult.size() - 1, 1);
                List<Integer> prevResult = result.get(i - 1);
                int p1 = 0, p2 = 1;
                for (int j = 1; j < nextResult.size() - 1; j++) {
                    int sum = prevResult.get(p1) + prevResult.get(p2);
                    nextResult.set(j, sum);
                    p1++;
                    p2++;
                }
                result.add(nextResult);
            }
        }

        return result;
    }

}