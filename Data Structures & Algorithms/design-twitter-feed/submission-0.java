class Twitter {

    private int count;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followers;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        
        List<int[]> tweets = tweetMap.get(userId);
        tweets.add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        // For getting tweets of current user itself
        followers.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for(int followeeId: followers.get(userId)) {
            if(tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size()-1;
                int[] tweet = tweets.get(index);

                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }

        return res;


    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());

        Set<Integer> set = followers.get(followerId);
        set.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)) {
            Set<Integer> set = followers.get(followerId);
            if(set.contains(followeeId)) {
                set.remove(followeeId);
            }
        }
    }
}
