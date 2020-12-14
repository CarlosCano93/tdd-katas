class BowlingGame {
    private final int[] rolls = new int[21];
    private int roll = 0;

    int score() {
        int score = 0;
        int roll = 0;


        for(int frame = 0; frame < 10; frame++) {
            if (isStrike(roll)){
                score += 10 + strikeBonus(roll);
                roll += 1;
            } else if (isSpare(roll)) {
                score += 10 + spareBonus(roll);
                roll += 2;
            } else {
                score += frameScore(roll);
                roll += 2;
            }
        }

        return score;
    }

    private int frameScore(int roll) {
        return rolls[roll] + rolls[roll+1];
    }

    private int spareBonus(int i) {
        return rolls[i+2];
    }

    private int strikeBonus(int i) {
        return rolls[i + 1] + rolls[i + 2];
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }

    private boolean isSpare(int i) {
        return frameScore(i) == 10;
    }

    void roll(int pins) {
        rolls[roll++] = pins;
    }
}
