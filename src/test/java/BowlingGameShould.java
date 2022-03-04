import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlingGameShould {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void a_game_with_all_rolls_0() {
        rollMany(0, 20);

        assertThat(bowlingGame.score(), is(0));
    }

    @Test
    public void a_game_with_all_rolls_1() {
        rollMany(1, 20);

        assertThat(bowlingGame.score(), is(20));
    }

    @Test
    public void a_game_with_a_spare() {
        rollSpare();
        bowlingGame.roll(3);
        rollMany(0, 17);

        assertThat(bowlingGame.score(), is(16));

    }

    @Test
    public void a_game_without_spare() {
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        rollMany(0, 16);

        assertThat(bowlingGame.score(), is(13));
    }

    @Test
    public void a_game_with_a_strike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(6);
        rollMany(0, 16);

        assertThat(bowlingGame.score(), is(28));
    }

    @Test
    public void a_game_with_all_strike() {
        rollMany(10, 12);

        assertThat(bowlingGame.score(), is(300));
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
