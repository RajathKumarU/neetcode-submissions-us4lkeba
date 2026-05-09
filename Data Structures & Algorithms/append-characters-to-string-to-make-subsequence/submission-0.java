class Solution {
    public int appendCharacters(String s, String t) {

        int si = 0, ti = 0;
        while(si<s.length() && ti<t.length()) {
            if(s.charAt(si) == t.charAt(ti)) {
                si++; ti++;
            } else {
                si++;
            }
        }

        return ti<t.length()? t.substring(ti).length(): 0;
        
    }
}