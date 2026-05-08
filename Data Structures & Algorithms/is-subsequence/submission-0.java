class Solution {
    public boolean isSubsequence(String s, String t) {

        int si = 0, ti=0;
        char[] sc = s.toCharArray(), tc = t.toCharArray();

        while (ti < t.length()) {
            if(si < s.length() && sc[si] == tc[ti])
                si++;
            ti++;
        }

        return si >= s.length()? true: false;
        
    }
}