class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            TreeMap<Integer, String>treeMap = map.get(key);
            treeMap.put(timestamp, value);
        } else {
            TreeMap<Integer, String>treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tMap = map.getOrDefault(key, null);
        if(tMap == null) {
            return "";
        } else if (tMap.containsKey(timestamp)) {
            return tMap.get(timestamp);
        } else {
            Map.Entry<Integer, String> entry = 
                tMap.floorEntry(timestamp);

            return entry == null? "" : entry.getValue();
        }
    }
}
