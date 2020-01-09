package com.ford.fs.powerup.bowling.score;

import com.ford.fs.powerup.bowling.game.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void test_calculateScoreWhenZeroIsRolled() {
        int value = game.calculateScore(0);
        assertThat(value).isEqualTo(0);
    }

    @Test
    void test_calculateScoreWhenNonZeroAndNonSpecial() {
        int value = game.calculateScore(7);
        assertThat(value).isEqualTo(0);
    }

    @Test
    void test_calculateScoreFor1Frame_withTwoRolls() {
        game.calculateScore(1);
        int value = game.calculateScore(2);
        assertThat(value).isEqualTo(3);
    }

    @Test
    void test_calculateScoreFor1Frame_withThreeRolls() {
        game.calculateScore(1);
        game.calculateScore(2);
        int value = game.calculateScore(5);
        assertThat(value).isEqualTo(3);
    }

    @Test
    void test_calculateScoreFor2Frames(){
        game.calculateScore(1);
        game.calculateScore(2);
        game.calculateScore(5);
        int value = game.calculateScore(3);
        assertThat(value).isEqualTo(11);
    }

    @Test
    void test_calculateScoreFor3Frames(){
        game.calculateScore(1);
        game.calculateScore(2);
        game.calculateScore(3);
        game.calculateScore(4);
        game.calculateScore(5);
        int value = game.calculateScore(3);
        assertThat(value).isEqualTo(18);
    }

   /* @Test
    void test_calculateScoreForSpare() {
        game.calculateScore(1);
        int value = game.calculateScore(9);
        assertThat(value).isEqualTo(0);
        value = game.calculateScore(2);
        assertThat(value).isEqualTo(12);
    }*/

//    @Test
//    void test_calculateScoreForSpare_2CompleteFrames() {
//        game.calculateScore(1);
//        int value = game.calculateScore(9);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(2);
//        assertThat(value).isEqualTo(12);
//        value = game.calculateScore(2);
//        assertThat(value).isEqualTo(16);
//    }
//
//    @Test
//    void test_calculateScoreForStrikeCase(){
//        int value = game.calculateScore(10);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(3);
//        assertThat(value).isEqualTo(26);
//    }
//
//    @Test
//    void test_calculateScoreForStrikeAndSpareCase(){
//        int value = game.calculateScore(10);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(20);
//    }
//
//    @Test
//    void test_calculateScoreForStrikeAndSpareAndRegularCase(){
//        int value = game.calculateScore(10);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(0);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(20);
//        value = game.calculateScore(5);
//        assertThat(value).isEqualTo(35);
//        value = game.calculateScore(3);
//        assertThat(value).isEqualTo(43);
//    }


}