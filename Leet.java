import java.util.Arrays;

public class Leet {
    public static void main(String[] args) {
        int[] input = { -1, -1, 1, 1, 1 };
        int[] input2 = { 2, 7, 11, 15 };
        int[] input3 = { 2, 3, 4 };
        int[] input4 = { -1, 0 };
        System.out.println(Arrays.toString(twoSum(input, -2)));
        System.out.println(Arrays.toString(twoSum(input2, 9)));
        System.out.println(Arrays.toString(twoSum(input3, 6)));
        System.out.println(Arrays.toString(twoSum(input4, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int currMax = 0, idx1 = -1, idx2 = -1, tempSecond = 0;
        int[] output = new int[2];
        if (numbers[numbers.length - 1] <= target) {
            currMax = numbers[numbers.length - 1];
            idx2 = numbers.length - 1;
        } else {
            if (target < 0) {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] >= 0) {
                        currMax = numbers[i];
                        idx2 = i;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] >= target) {
                        currMax = numbers[i];
                        idx2 = i;
                        break;
                    }
                }
            }

        }

        tempSecond = target - currMax;

        while (idx1 == -1) {
            for (int i = 0; i < idx2; i++) {
                if (numbers[i] == tempSecond) {
                    idx1 = i;
                    break;
                }
            }
            if (idx1 == -1) {
                idx2--;
                currMax = numbers[idx2];
                tempSecond = target - currMax;
            }
        }
        output[0] = idx1 + 1;
        output[1] = idx2 + 1;
        return output;
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