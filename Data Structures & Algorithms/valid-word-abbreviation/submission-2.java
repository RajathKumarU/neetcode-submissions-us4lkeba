class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        int i=0, j=0;

        while (i<word.length() && j<abbr.length()) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (Character.isDigit(abbr.charAt(j)) && abbr.charAt(j)=='0') {
                return false;
            } else if(Character.isDigit(abbr.charAt(j))) {
                String num = "";
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num += abbr.charAt(j);
                    j++;
                }

                int n = Integer.parseInt(num);
                while(n > 0) {
                    i++;
                    n--;
                }
            } else {
                return false;
            }
        }

        return i==word.length() && j==abbr.length()? true: false;
        
    }
}