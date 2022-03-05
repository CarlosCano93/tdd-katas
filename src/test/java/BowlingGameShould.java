import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingGameShould {

    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void a_game_with_all_rolls_0() {
        rollMany(0, 20);

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void a_game_with_all_rolls_1() {
        rollMany(1, 20);

        assertThat(bowlingGame.score()).isEqualTo(20);
    }

    @Test
    public void a_game_with_a_spare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(0, 17);

        assertThat(bowlingGame.score()).isEqualTo(16);

    }

    @Test
    public void a_game_without_spare() {
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        rollMany(0, 16);

        assertThat(bowlingGame.score()).isEqualTo(13);
    }

    @Test
    public void a_game_with_a_strike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(6);
        rollMany(0, 16);

        assertThat(bowlingGame.score()).isEqualTo(28);
    }

    @Test
    public void a_game_with_all_strike() {
        rollMany(10, 12);

        assertThat(bowlingGame.score()).isEqualTo(300);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }

    private void rollSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollMany(int pins, int times) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll(pins);
        }
    }
}
