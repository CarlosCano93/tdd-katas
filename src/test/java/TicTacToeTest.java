import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {

    private final TicTacToe.State[][] matrix = new TicTacToe.State[][]{
            {TicTacToe.State.NONE, TicTacToe.State.NONE, TicTacToe.State.NONE},
            {TicTacToe.State.NONE, TicTacToe.State.NONE, TicTacToe.State.NONE},
            {TicTacToe.State.NONE, TicTacToe.State.NONE, TicTacToe.State.NONE}};

    @Test
    void plays_and_save_positions_of_different_players() {
        var ticTacToe = new TicTacToe();

        matrix[0][0] = TicTacToe.State.X;
        matrix[0][1] = TicTacToe.State.X;
        matrix[0][2] = TicTacToe.State.X;

        matrix[1][0] = TicTacToe.State.O;
        matrix[1][1] = TicTacToe.State.O;
        matrix[1][2] = TicTacToe.State.O;

        ticTacToe.play(0, 0, TicTacToe.State.X);
        ticTacToe.play(0, 1, TicTacToe.State.X);
        ticTacToe.play(0, 2, TicTacToe.State.X);

        ticTacToe.play(1, 0, TicTacToe.State.O);
        ticTacToe.play(1, 1, TicTacToe.State.O);
        ticTacToe.play(1, 2, TicTacToe.State.O);

        assertTrue(Arrays.deepEquals(matrix, ticTacToe.getBoard()));
    }

    @Test
    void return_victory_if_three_x_or_y_are_lined_vertical() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(1, 0, TicTacToe.State.X);
        ticTacToe.play(1, 1, TicTacToe.State.X);
        ticTacToe.play(1, 2, TicTacToe.State.X);

        assertEquals(TicTacToe.State.X, ticTacToe.getWinner());
    }

    @Test
    void return_victory_if_three_x_or_y_are_lined_horizontal() {
        var ticTacToe = new TicTacToe();

        ticTacToe.play(0, 1, TicTacToe.State.O);
        ticTacToe.play(1, 1, TicTacToe.State.O);
        ticTacToe.play(2, 1, TicTacToe.State.O);

        assertEquals(TicTacToe.State.O, ticTacToe.getWinner());
    }

    @Test
    void return_victory_if_three_x_or_y_are_lined_diagonal() {
        var ticTacToeWinO = new TicTacToe();
        var ticTacToeWinX = new TicTacToe();

        ticTacToeWinO.play(0, 0, TicTacToe.State.O);
        ticTacToeWinO.play(1, 1, TicTacToe.State.O);
        ticTacToeWinO.play(2, 2, TicTacToe.State.O);

        ticTacToeWinX.play(0, 2, TicTacToe.State.X);
        ticTacToeWinX.play(1, 1, TicTacToe.State.X);
        ticTacToeWinX.play(2, 0, TicTacToe.State.X);

        assertEquals(TicTacToe.State.O, ticTacToeWinO.getWinner());
        assertEquals(TicTacToe.State.X, ticTacToeWinX.getWinner());
    }
}