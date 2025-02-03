package com.example.simbirsoft_java_core_training;

import static org.junit.Assert.assertArrayEquals;

import com.example.simbirsoft_java_core_training.movement.Directions;
import com.example.simbirsoft_java_core_training.movement.Movement;

import org.junit.Test;

public class MovementTest {

    @Test
    public void testMoveUp() {
        int[] result = Movement.move(0, 0, Directions.UP);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testMoveDown() {
        int[] result = Movement.move(0, 0, Directions.DOWN);
        assertArrayEquals(new int[]{0, -1}, result);
    }

    @Test
    public void testMoveLeft() {
        int[] result = Movement.move(0, 0, Directions.LEFT);
        assertArrayEquals(new int[]{-1, 0}, result);
    }

    @Test
    public void testMoveRight() {
        int[] result = Movement.move(0, 0, Directions.RIGHT);
        assertArrayEquals(new int[]{1, 0}, result);
    }

    @Test
    public void testExecuteMovements() {
        int[] finalLocation = Movement.executeMovements();
        assertArrayEquals(new int[]{1, -2}, finalLocation);
    }
}
