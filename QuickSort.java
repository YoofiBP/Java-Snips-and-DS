import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        int[] output = new int[arr.length];
        System.out.println(arr.length);
        System.out.println(output.length);
        int[] myArray = new int[] { 5, 2, 1, 8, 9, 4, 7, 6, 3 };
        quickSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = pivot(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
        return arr;
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    static int pivot(int[] arr, int start, int end) {
        int pivot = start;
        int swapIdx = start;
        for (int p1 = start + 1; p1 <= end; p1++) {
            if (arr[p1] < arr[pivot]) {
                swapIdx++;
                swap(arr, p1, swapIdx);
            }
        }

        swap(arr, pivot, swapIdx);
        return swapIdx;
    }
}