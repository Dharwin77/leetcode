class Solution {
    public List<List<String>> solveNQueens(int n) {
         boolean[][] board = new boolean[n][n];
            List<List<String>> list = new ArrayList<>();
            queen(board,0,list);
            return list;
    }
    static void queen(boolean[][] board , int row,List<List<String>> list) {
        if (row == board.length) {
            list.add(AddList(board));
            return;
        }
        for(int col = 0; col < board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                queen(board,row+1,list);
                board[row][col] = false;
            }
        }
    }
    private static List<String> AddList(boolean[][] board) {
        List<String> list = new ArrayList<>();
        StringBuilder str;
        for(boolean[] row : board){
            str = new StringBuilder();
            for(Boolean element : row){
                if(element){
                    str.append("Q");
                }
                else{
                    str.append(".");
                }
            }
            list.add(String.valueOf(str));
        }
        return list;
    }
    static boolean isSafe(boolean[][] board, int row, int col) {
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int maxRight = Math.min(row,board.length - col -1);
        for(int i=1;i<=maxRight;i++){
            if(board[row - i][col+i]){
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row -i][col-i]){
                return false;
            }
        }
        return true;
    }
}