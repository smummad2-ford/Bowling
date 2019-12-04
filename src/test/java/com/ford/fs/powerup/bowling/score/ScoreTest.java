package com.ford.fs.powerup.bowling.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScoreTest {

    @Autowired
    private Score score;

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateScore() {
        int value = score.calculateScore(0);
        assertEquals(0,value);
        value = score.calculateScore(7);
        assertEquals(7,value);
    }
}