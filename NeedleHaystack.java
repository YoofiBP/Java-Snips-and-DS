public class NeedleHaystack {
    public static void main(String[] args) {
        // strStr("babba", "bbb");
        // strStr("mississippi", "pi");
        // strStr("hello", "ll");
        strStr("mississippi", "issip");
        // strStr("aaa", "a");
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        int foundIndex = -1;
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length()) {
            if (haystack.charAt(p1) == needle.charAt(p2)) {
                foundIndex = p1;
                while (foundIndex != -1 && p2 < needle.length()) {
                    if (p1 >= haystack.length()) {
                        foundIndex = -1;
                        break;
                    }
                    if (haystack.charAt(p1) == needle.charAt(p2)) {
                        p1++;
                        p2++;
                    } else {
                        p1 = foundIndex + 1;
                        foundIndex = -1;
                        p2 = 0;
                        break;
                    }
                }

                if (foundIndex != -1) {
                    break;
                }
            } else {
                p1++;
            }

        }
        System.out.println(foundIndex);
        return foundIndex;
    }

    static int strStr2(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }
}