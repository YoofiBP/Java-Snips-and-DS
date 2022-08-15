public class CommonPrefix {
    public static void main(String[] args) {
        System.out.println("flow".indexOf("flower"));
        String[] input = { "flower", "flow", "flight" };
        String[] input2 = { "dog", "racecar", "car" };
        String[] input3 = { "", "" };
        String[] input4 = { "flower", "flower", "flower", "flower" };
        String commonPrefix = longestCommonPrefix2(input);
        System.out.println(commonPrefix);
    }

    static public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;

        String first = strs[0];
        while (true && p1 < first.length()) {
            if (first.length() == 0) {
                break;
            }
            char current = first.charAt(p1);
            boolean isEqual = true;
            boolean shouldEnd = false;
            for (String str : strs) {
                if (p1 == str.length()) {
                    shouldEnd = true;
                    break;
                }
                if (str.charAt(p1) != current) {
                    isEqual = false;
                    break;
                }
            }

            if (shouldEnd)
                break;

            if (isEqual) {
                sb.append(current);
                p1++;
            } else {
                break;
            }

        }
        return sb.toString();
    }

    static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}