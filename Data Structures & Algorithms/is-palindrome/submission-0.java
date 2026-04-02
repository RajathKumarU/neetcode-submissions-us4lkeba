class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int i=0, j=s.length()-1;

        while(i<j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if(Character.isLetterOrDigit(l) && Character.isLetterOrDigit(r)) {
                if(l != r) {
                    return false;
                }
                i++;
                j--;
            } else if (!Character.isLetterOrDigit(l)) {
                i++;
            } else if (!Character.isLetterOrDigit(r)) {
                j--;
            }
            
        }

        return true;
    }
}
