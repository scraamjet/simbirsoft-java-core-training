package com.example.simbirsoft_java_core_training.lambda;

public class LambdaExample {
    public void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }
}
