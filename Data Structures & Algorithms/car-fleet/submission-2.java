class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Map<Integer, Integer> posSpdMap = new HashMap();
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<position.length;i++) {
            posSpdMap.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        for (int i=position.length -1; i>=0; i--) {
            
            int time = (target - position[i]) / posSpdMap.get(position[i]);
            s.push(time);
            if (s.size() >= 2 &&
                s.peek() <= s.get(s.size() - 2)) {
                s.pop();
            }
        }

        return s.size();
    }
}
