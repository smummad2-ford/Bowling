package com.ford.fs.powerup.bowling.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score();
    }

    @Test
    void test_calculateScoreWhenZeroIsRolled() {
        int value = score.calculateScore(0);
        assertThat(value).isEqualTo(0);
    }

    @Test
    void test_calculateScoreWhenNonZeroAndNonSpecial() {
        int value = score.calculateScore(7);
        assertThat(value).isEqualTo(0);
    }

    @Test
    void test_calculateScoreFor1Frame_withTwoRolls() {
        score.calculateScore(1);
        int value = score.calculateScore(2);
        assertThat(value).isEqualTo(3);
    }

}