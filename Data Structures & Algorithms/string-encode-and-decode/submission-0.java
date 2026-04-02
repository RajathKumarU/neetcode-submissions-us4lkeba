class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty())
            return "";

        StringBuilder encodedStr = new StringBuilder();
        for (String str: strs) {
            encodedStr.append(str.length()).append("#").append(str);
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        if(str == null || str.isEmpty())
            return new ArrayList<>();
        
        List<String> finalList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            finalList.add(str.substring(i, j));
            i = j;
        }

        return finalList;
    }
}
