public class TicTacToe {
    enum State {NONE, X, O}

    private State winner = null;
    private final State[][] board = new State[][]{
            {State.NONE, State.NONE, State.NONE},
            {State.NONE, State.NONE, State.NONE},
            {State.NONE, State.NONE, State.NONE}};

    public void play(int x, int y, State state) {
        if (board[x][y] == State.NONE)
            board[x][y] = state;

        checkWinner();
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != State.NONE
                    && board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])) {
                setWinner(board[i][0]);
            }

            if (board[0][i] != State.NONE
                    && board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])) {
                setWinner(board[0][i]);
            }
        }

        if (board[0][0] != State.NONE
                && board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])) {
            setWinner(board[0][0]);
        }

        if (board[0][2] != State.NONE
                && board[0][2].equals(board[1][1])
                && board[0][0].equals(board[2][0])) {
            setWinner(board[0][2]);
        }
    }

    public State[][] getBoard() {
        return board;
    }

    public State getWinner() {
        return winner;
    }

    public void setWinner(State winner) {
        this.winner = winner;
    }
}
