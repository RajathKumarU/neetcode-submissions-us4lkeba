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
            if(s.isEmpty()) {
                s.push(time);
            }
            else if (time > s.peek()) {
                s.push(time);
            }
        }

        return s.size();
    }
}
