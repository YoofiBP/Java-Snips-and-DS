import java.util.Arrays;

class TurnTabl {
    public static void main(String[] args) throws java.lang.Exception {
        int[] input = null;
        System.out.println(Arrays.toString(input));
        input = new int[5];

    }

    static int[] reverseArray(int[] arr, int arraySize) {
        if (arraySize == 1) {
            return arr;
        }
        int p1 = 0;
        int p2 = arraySize - 1;
        while (p1 != p2 && p1 < p2) {
            swap(arr, p1, p2);
            p1++;
            p2--;
        }

        return arr;
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    static int[] createArrayFromInput(String input, int size) {
        char[] charArray = input.toCharArray();
        int[] output = new int[size];
        int index = 0;
        for (char c : charArray) {
            if (c != ' ') {
                output[index] = c;
                index++;
            }
        }
        return output;
    }
}