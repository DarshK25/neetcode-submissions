class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char val = board[r][c];
                if(val == '.') continue;
                int boxIdx = (r/3) * 3 + (c/3);
                if(!row[r].add(val) || !col[c].add(val) 
                    || !boxes[boxIdx].add(val)) return false;
            }
        }
        return true;
    }
}
