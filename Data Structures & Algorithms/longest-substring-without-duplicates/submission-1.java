class Solution {
    public int lengthOfLongestSubstring(String s) {

        int window = s.length();

        while (window > 0) {
            for(int i=0; i<= s.length()-window;i++) {
                if(isUnique(s.substring(i, i+window)))
                    return window;
            }

            window--;
        }

        return window;
        
    }

    public boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++) {
            if(set.contains(str.charAt(i))) {
                return false;
            } else {
                set.add(str.charAt(i));
            }
        }

        return true;
    }
}
