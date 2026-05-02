class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0;i<m || j<n; i++, j++) {
            if(i<m) 
                sb.append(word1.charAt(i));
            
            if(j<n)
                sb.append(word2.charAt(j));
        }

        return sb.toString();
    }
}