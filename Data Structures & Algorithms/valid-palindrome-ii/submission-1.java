class Solution {
    public boolean validPalindrome(String s) {
        
        if(isPalindrome(s, -1)) return true;
        
        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s, i)) return true;
        }

        return false;
    }

    public boolean isPalindrome(String s, int skip) {
        s = s.toLowerCase();

        int i=0, j=s.length()-1;

        while(i<j) {
            char l = s.charAt(i);
            char r = s.charAt(j);

            if(skip >= 0 && skip == i) {
                i++;
                continue;
            } else if (skip >= 0 && skip == j) {
                j--;
                continue;
            }

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