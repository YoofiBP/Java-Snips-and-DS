import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> input = List.of(5, 8, 3, 1, 19, 2, 7, 4, 12, 17);
        List<Integer> output = mergeSort(input);
        System.out.println(output);

    }

    static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() <= 1)
            return arr;
        int midPoint = arr.size() / 2;
        List<Integer> left = mergeSort(arr.subList(0, midPoint));
        List<Integer> right = mergeSort(arr.subList(midPoint, arr.size()));
        List<Integer> output = merge(left, right);
        return output;
    }

    // Merge two sorted arrays
    static List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> output = new ArrayList<Integer>();
        int p1 = 0;
        int p2 = 0;
        while ((p1 + p2) < arr1.size() + arr2.size()) {
            if (p2 == arr2.size()) { // weve reached the end of second array and its empty
                output.addAll(arr1.subList(p1, arr1.size()));
                break;
            } else if (p1 == arr1.size()) {
                output.addAll(arr2.subList(p2, arr2.size()));
                break;
            } else if (arr1.get(p1) < arr2.get(p2)) {
                output.add(arr1.get(p1));
                p1++;
            } else {
                output.add(arr2.get(p2));
                p2++;
            }
        }
        return output;
    }
}

// 5,8,3,1,19,2,7,5
// 5,8,3,1 19,2,7,5
// 5,8 3,1 19,2 7,5
// 5 8 3 1 19 2 7 5