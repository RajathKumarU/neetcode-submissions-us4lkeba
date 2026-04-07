class LRUCache {

    Map<Integer, Integer> map = new LinkedHashMap();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(map.size() == this.capacity) {
            map.remove(map.size()-1);
            map.put(key, value);
        } else {
            map.put(key, value);
        }
    }
}
