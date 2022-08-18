import java.util.Arrays;

public class Leet {
    public static void main(String[] args) {
        int[] input = { 4, 10, 3, 2, 1, 7, -17 };
        countingSort(input);
    }

    public static void countingSort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        int[] count = new int[(max - min) + 2];

        for (int num : nums) {
            count[num - min]++;
        }

        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] = count[i + 1] + count[i];
        }

        for (int i = count.length - 1; i > 0; i--) {
            count[i] = count[i - 1];
        }

        count[0] = 0;

        int[] output = new int[nums.length];

        for (int num : nums) {
            output[count[num - min]] = num;
            count[num - min]++;
        }

        System.out.println(Arrays.toString(output));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    public static void reverseString(char[] s) {
        if (s.length >= 2) {
            int p1 = 0, p2 = s.length - 1;
            while (p1 < p2) {
                char temp = s[p2];
                s[p2] = s[p1];
                s[p1] = temp;
                p1++;
                p2--;
            }
        }

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