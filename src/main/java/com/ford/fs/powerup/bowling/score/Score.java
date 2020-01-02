package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;


@Component
public class Score {
    int totalScore = 0;
    int rollCount = 0;
    int frameScore = 0;
    boolean isPreviousRollSpare = false;
    boolean isPreviousRollStrike = false;


    public int calculateScore(int pins) {
        if (pins > 10) {
            throw new IllegalArgumentException("pin cannot be more than 10");
        }

        if(isPreviousRollStrike) {
            return handleAfterStrike(pins);
        }

        if (handleStrikeCase(pins)) return totalScore;

        if(isPreviousRollSpare) {
            return handleAfterSpareCase(pins);

        }
        if (isFirstRoll()) {
            frameScore = 0;
            setFrameScoreAndIncrementRollCount(pins);
            return totalScore;
        }

        frameScore += pins;
        totalScore += frameScore;
        rollCount++;

        if (handleSpareCase()) return 0;

        return totalScore;
    }

    private boolean handleSpareCase() {
        if (frameScore == 10) {
            isPreviousRollSpare = true;
            return true;
        }
        return false;
    }

    private boolean isFirstRoll() {
        return rollCount % 2 == 0;
    }

    private int handleAfterStrike(int pins) {
        if(isFirstRoll()) {
            setFrameScoreAndIncrementRollCount(pins);
            return totalScore;
        }
        isPreviousRollStrike = false;
        frameScore += pins;

        if(handleSpareCase()) {
            totalScore += frameScore + 10;
            return totalScore;
        }
        totalScore += (frameScore * 2) + 10;
        return totalScore;
    }

    private boolean handleStrikeCase(int pins) {
        if (pins == 10) {
            if (isFirstRoll()) {
                rollCount++;
            }
            isPreviousRollStrike = true;
            setFrameScoreAndIncrementRollCount(pins);
            return true;
        }
        return false;
    }

    private int handleAfterSpareCase(int pins) {
            totalScore += pins;
            isPreviousRollSpare = false;
            setFrameScoreAndIncrementRollCount(pins);
            return totalScore;
    }

    private void setFrameScoreAndIncrementRollCount(int pins) {
        frameScore = pins;
        rollCount++;
    }
}
