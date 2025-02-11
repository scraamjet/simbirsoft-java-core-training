package com.example.simbirsoft_java_core_training;

import static org.junit.Assert.assertEquals;

import com.example.simbirsoft_java_core_training.lambda.LambdaExample;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LambdaExampleTest {

    @Test
    public void testRepeatTask() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outputStream));

        try {
            LambdaExample lambdaExample = new LambdaExample();

            lambdaExample.repeatTask(10, () -> System.out.println("I love Java"));

            String expectedOutput = ("I love Java\n").repeat(10);
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }

        System.out.println(outputStream);
    }
}


