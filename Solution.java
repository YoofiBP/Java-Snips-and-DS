import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4 };

        reverseArrayTwo(input, 4);

        int[] newinput = { 12, 20, 23, 45, 55, 23, 66, 99, 1, 2 };
        System.out.println(absoluteCount(newinput));

    }

    public static int absoluteCount(int[] arr) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) { // even
                even++;
            } else {
                odd++;
            }
        }

        return getAbsoluteDifference(odd, even);
    }

    public static int getAbsoluteDifference(int num1, int num2) {
        return Math.abs(num1 - num2);
    }

    public static void duplicateZeros(int[] arr) {
        int[] positions = new int[arr.length];
        int p2 = 0;

        for (int p1 = 0; p1 < arr.length; p1++) {
            if (p2 > positions.length - 1) {
                break;
            }
            if (arr[p1] != 0) {
                positions[p2] = arr[p1];
                p2++;
            } else {
                if (p2 == positions.length - 1) {
                    positions[p2] = arr[p1];
                    p2 += 1;
                } else {
                    positions[p2] = arr[p1];
                    positions[p2 + 1] = arr[p1];
                    p2 += 2;
                }

            }
        }

        System.out.println(Arrays.toString(positions));
        for (int i = 0; i < positions.length; i++) {
            arr[i] = positions[i];
        }
    }

    public static int[] reverseArray(int[] arr, int arraySize) {
        int[] reversedArray = new int[arraySize];
        for (int i = arraySize - 1; i >= 0; i++) {
            int reverseArrayIndex = (arraySize - 1) - i;
            System.out.println(reverseArrayIndex);
            reversedArray[reverseArrayIndex] = arr[i];
        }
        System.out.println(Arrays.toString(reversedArray));
        return reversedArray;
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static int[] reverseArrayTwo(int[] arr, int arraySize) {
        int p1 = 0;
        int p2 = arraySize - 1;
        while (p1 != p2 && p1 < p2) {
            swap(arr, p1, p2);
            p1++;
            p2--;
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] dummy = new int[nums.length];
        int newIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                dummy[newIndex] = nums[i];
                newIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                dummy[newIndex] = nums[i];
                newIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                dummy[newIndex] = nums[i];
                newIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = dummy[i];
        }

        return nums;
    }

}