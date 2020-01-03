package com.ford.fs.powerup.bowling.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreWithArraysTest {

    private ScoreWithArrays score;

    @BeforeEach
    void setUp() {
        score = new ScoreWithArrays();
    }

    @Test
    void test_calculateScoreWhenZeroIsRolled() {
        int value = score.bowlingScore(0);
        assertThat(value).isEqualTo(0);
    }


    @Test
    void test_calculateScoreWhenNonZeroAndNonSpecial() {
        int value = score.bowlingScore(7);
        assertThat(value).isEqualTo(0);
    }

    @Test
    void test_calculateScoreFor1Frame_withTwoRolls() {
        assertThat(score.bowlingScore(1)).isEqualTo(0);
        int value = score.bowlingScore(2);
        assertThat(value).isEqualTo(3);
    }

//    @Test
//    void test_calculateScoreFor1Frame_withThreeRolls() {
//        score.bowlingScore(1);
//        score.bowlingScore(2);
//        int value = score.bowlingScore(5);
//        assertThat(value).isEqualTo(3);
//    }

}