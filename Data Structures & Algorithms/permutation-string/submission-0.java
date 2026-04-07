class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        
        for(int i=0; i<(s2.length()-s1.length()); i++) {
            if(isAnagram(s1, s2.substring(i, i+s1.length())))
                return true;
        }

        return false;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMapS = new HashMap<>();
        Map<Character, Integer> countMapT = new HashMap<>();
        if(s==null || t==null|| s.length()==0 || t.length()==0
            || s.length() != t.length())
            return false;
        
        for(int i=0;i<s.length();i++) {
            countMapS.put(s.charAt(i), countMapS.getOrDefault(s.charAt(i), 0) + 1);
            countMapT.put(t.charAt(i), countMapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return countMapS.equals(countMapT);
    }
}
