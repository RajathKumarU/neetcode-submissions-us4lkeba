class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            if(str.isEmpty()) {
                String key = "";
                List<String> list = new ArrayList();
                list.add("");
                map.put("", list);
            } else {
                int[] freq = getFreq(str);
                String key = Arrays.toString(freq);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
        }
        
        return new ArrayList<>(map.values());
    }
    
    public int[] getFreq(String s) {
        int[] freq = new int[26];

        for(int i=0; i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }

        return freq;
    }
}
