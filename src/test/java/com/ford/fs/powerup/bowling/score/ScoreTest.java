package com.ford.fs.powerup.bowling.score;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void test_too_many_rolls(){
        IllegalArgumentException myException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            score.calculateScore(11);
        });
        assertTrue(myException.getMessage().contains("pin cannot be more than 10"));
    }

    @Test
    void test_calculateScoreFor1Frame_withThreeRolls() {
        score.calculateScore(1);
        score.calculateScore(2);
        int value = score.calculateScore(5);
        assertThat(value).isEqualTo(3);
    }

    @Test
    void test_calculateScoreFor2Frames(){
        score.calculateScore(1);
        score.calculateScore(2);
        score.calculateScore(5);
        int value = score.calculateScore(3);
        assertThat(value).isEqualTo(11);
    }

    @Test
    void test_calculateScoreForSpare() {
        score.calculateScore(1);
        int value = score.calculateScore(9);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(2);
        assertThat(value).isEqualTo(12);
    }

    @Test
    void test_calculateScoreForSpare_2CompleteFrames() {
        score.calculateScore(1);
        int value = score.calculateScore(9);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(2);
        assertThat(value).isEqualTo(12);
        value = score.calculateScore(2);
        assertThat(value).isEqualTo(16);
    }

    @Test
    void test_calculateScoreForStrikeCase(){
        int value = score.calculateScore(10);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(3);
        assertThat(value).isEqualTo(26);
    }

    @Test
    void test_calculateScoreForStrikeAndSpareCase(){
        int value = score.calculateScore(10);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(20);
    }

    @Test
    void test_calculateScoreForStrikeAndSpareAndRegularCase(){
        int value = score.calculateScore(10);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(0);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(20);
        value = score.calculateScore(5);
        assertThat(value).isEqualTo(35);
        value = score.calculateScore(3);
        assertThat(value).isEqualTo(43);
    }


}