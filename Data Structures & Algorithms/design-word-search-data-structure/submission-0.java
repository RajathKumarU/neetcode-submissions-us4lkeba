class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    public boolean dfs(String word, TrieNode root) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(c == '.') {
                for(TrieNode child: curr.children.values()) {
                    if(child != null && dfs(word.substring(1), child)) {
                        return true;
                    }
                    return false;
                }
            } else {
                if(curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                } else {
                    return false;
                }
            }
        }
        return curr.endOfWord;
    }
}
