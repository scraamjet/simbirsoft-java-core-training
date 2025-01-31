package com.example.simbirsoft_java_core_training.classes.Task2;

import java.util.Random;

public class DynamicArray {
    private int[] array;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля.");
        }

        this.array = new int[capacity];
        this.size = capacity;
    }

    public void fillRandom(int min, int max) {
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
    }

    public void shuffle() {
        Random rand = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }

    public int countUniqueElements() {
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public void display() {
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}


