import java.util.Arrays;

public class Leet {
    public static void main(String[] args) {
        int[] input = { 9, 9, 9 };
        System.out.println(Arrays.toString(plusOne(input)));
    }

    public static int[] plusOne(int[] digits) {
        int start = digits.length - 1, carry = Integer.MAX_VALUE;

        while (carry != 0 && start >= 0) {
            int incremented = digits[start] + 1;
            if (incremented > 9) {
                carry = incremented - 9;
                digits[start] = incremented % 10;
                start--;
            } else {
                digits[start] = incremented;
                carry = 0;
            }
        }

        if (carry > 0) {
            int[] output = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                output[i + 1] = digits[i];
            }
            output[0] = carry;
            return output;
        }

        return digits;
    }

    public static int dominantIndex(int[] nums) {
        int largestIndex = -1;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                largestIndex = i;
            }

        }

        System.out.println(largestIndex);

        for (int i = 0; i < nums.length; i++) {
            if (i == largestIndex)
                continue;
            if (nums[i] * 2 > nums[largestIndex])
                return -1;
        }

        return largestIndex;
    }

}