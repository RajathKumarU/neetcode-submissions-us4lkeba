class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rowSet = new ArrayList<>(9);
        List<HashSet<Integer>> colSet = new ArrayList<>(9);
        List<HashSet<Integer>> boxSet = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rowSet.add(new HashSet<>());
            colSet.add(new HashSet<>());
            boxSet.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '0';

                    if(rowSet.get(i).contains(val)) return false;
                    else rowSet.get(i).add(val);
                    
                    if(colSet.get(j).contains(val)) return false;
                    else colSet.get(j).add(val);
                    
                    if(boxSet.get((i/3)*3 + (j/3)).contains(val)) return false;
                    else boxSet.get((i/3)*3 + (j/3)).add(val);
                }
            }
        }
        
        return true;
    }
}
