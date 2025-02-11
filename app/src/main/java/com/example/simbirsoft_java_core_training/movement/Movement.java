package com.example.simbirsoft_java_core_training.movement;

public class Movement {
    public static int[] move(int x, int y, Directions direction) {
        switch (direction) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        return new int[]{x, y};
    }

    public static int[] executeMovements() {
        int[] location = {0, 0};
        Directions[] moves = {
                Directions.UP, Directions.UP, Directions.LEFT, Directions.DOWN, Directions.LEFT,
                Directions.DOWN, Directions.DOWN, Directions.RIGHT, Directions.RIGHT, Directions.DOWN, Directions.RIGHT
        };

        for (Directions move : moves) {
            location = move(location[0], location[1], move);
            System.out.println("Текущая локация: (" + location[0] + ", " + location[1] + ")");
        }
        return location;
    }
}
