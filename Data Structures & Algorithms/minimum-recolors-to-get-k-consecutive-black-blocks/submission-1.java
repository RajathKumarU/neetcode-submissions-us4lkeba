class Solution {
    public int minimumRecolors(String blocks, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) {
            char c = blocks.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = map.getOrDefault('W', 0);

        for(int i=k; i<blocks.length(); i++) {
            char w = 'W';
            if(blocks.charAt(i-k) == w) {
                map.put(w, map.get(w)-1);
            }
            if(blocks.charAt(i) == w) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }

            res = Math.min(res, map.get(w));
        }
        return res;
    }
}