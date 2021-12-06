package mediumtasks;

public class BattleshipsInABoard {
    public static void main(String... args) {
        BattleshipsInABoard app = new BattleshipsInABoard();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
    System.out.println(app.countBattleships(board));
    }

    public int countBattleships(char[][] board) {

        int count = 0;
        int maxRows =  board.length;
        int maxCols = board[0].length;
        for (int i = 0; i<maxRows; i++) {
            for (int j = 0; j< maxCols; j++) {
                if (board[i][j] == 'X')  {
                    count++;
                    cleanX(board, i, j, maxRows, maxCols);
                }
            }
        }
        return count;
    }

    private void cleanX(char[][] board, int i, int j, int maxRows, int maxCols) {
        if (board[i][j] == '.') return;
        board[i][j] = '.';
        if (isInBoundaries(i+1, j, maxRows, maxCols)) {
            cleanX(board, i+1, j, maxRows, maxCols);
        }
        if (isInBoundaries(i, j+1, maxRows, maxCols)) {
            cleanX(board, i, j+1, maxRows, maxCols);
        }

    }

    private boolean isInBoundaries(int i, int j, int maxRows, int maxCols) {
        return i>=0 && j>=0 && i<maxRows && j<maxCols;
    }
}
