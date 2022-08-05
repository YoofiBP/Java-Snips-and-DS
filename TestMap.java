import java.util.List;

class TestMap {
    public static void main(String[] args) {
        int foundIndex = binarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10);
        System.out.println(foundIndex);
    }

    public static int binarySearch(List<Integer> arr, Integer needle) {
        int midPoint = (int) Math.floor(Double.valueOf(arr.size()) / 2);
        if (arr.get(midPoint) == needle) {
            return midPoint;
        } else if (arr.get(midPoint) < needle) {
            int lastIndex = binarySearch(arr.subList(midPoint + 1, arr.size()), needle);
            return lastIndex == -1 ? lastIndex : lastIndex + midPoint + 1;
        } else {
            return binarySearch(arr.subList(0, midPoint), needle);
        }
    }
}