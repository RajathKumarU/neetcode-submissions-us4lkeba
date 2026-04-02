
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMapS = new HashMap<>();
        Map<Character, Integer> countMapT = new HashMap<>();
        if(s==null || t==null|| s.length()==0 || t.length()==0
            || s.length() != t.length())
            return false;
        
        for(int i=0;i<s.length();i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(countMapS.containsKey(charS))
                countMapS.put(charS, countMapS.get(charS) + 1);
            else 
                countMapS.put(charS, 1);

            if(countMapT.containsKey(charT))
                countMapT.put(charT, countMapT.get(charT) + 1);
            else 
                countMapT.put(charT, 1);
        }

        for (Character key: countMapS.keySet()) {
            if(!countMapT.containsKey(key))
                return false;
            if (!countMapS.get(key).equals(countMapT.get(key)))
                return false;
        }
        
        return true;
    }
}
