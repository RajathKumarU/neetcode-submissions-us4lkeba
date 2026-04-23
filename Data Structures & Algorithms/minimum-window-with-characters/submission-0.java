class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> winCount = new HashMap<>();
        for(char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char r_char = s.charAt(r);
            winCount.put(r_char, winCount.getOrDefault(r_char, 0) + 1);

            if(countT.containsKey(r_char) && 
                    winCount.get(r_char).equals(countT.get(r_char))) {
                have++;
            }

            while (have == need) {
                if((r-l+1) < resLen) {
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char l_char = s.charAt(l);
                winCount.put(l_char, winCount.get(l_char) - 1);

                if(countT.containsKey(l_char) && 
                        winCount.get(l_char) < countT.get(l_char)) {
                    have--;
                }

                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
