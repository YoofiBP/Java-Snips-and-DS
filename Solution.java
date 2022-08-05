import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] input = { 9, 12, 5, 10, 14, 3, 10 };
        System.out.println(Arrays.toString(pivotArray(input, 10)));
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