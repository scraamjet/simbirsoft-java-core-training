package com.example.simbirsoft_java_core_training;

import com.example.simbirsoft_java_core_training.classes.Task5.Subscriber;
import com.example.simbirsoft_java_core_training.classes.Task5.SubscriberManager;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;


public class SubscriberManagerTest {

    private static SubscriberManager manager;

    @BeforeClass
    public static void init() {
        manager = new SubscriberManager();

        Subscriber[] subscribers = {
                new Subscriber(1, "Иванов", "Иван", "Иванович", "ул. Ленина, 10", "1234-5678-9101", 500, 100, 150, 30),
                new Subscriber(2, "Петров", "Петр", "Петрович", "ул. Гагарина, 5", "9876-5432-1098", 200, 50, 80, 0),
                new Subscriber(3, "Сидоров", "Алексей", "Владимирович", "ул. Кирова, 3", "3456-7890-1234", 100, 70, 200, 20),
                new Subscriber(4, "Кузнецов", "Сергей", "Олегович", "ул. Победы, 15", "6789-0123-4567", 300, 90, 120, 50),
                new Subscriber(5, "Морозов", "Дмитрий", "Игоревич", "ул. Чехова, 7", "1122-3344-5566", 400, 60, 50, 10)
        };

        for (Subscriber subscriber : subscribers) {
            manager.addSubscriber(subscriber);
        }
    }

    @Test
    public void testGetSubscribersWithCityCallTimeAbove() {
        List<Subscriber> result = manager.getSubscribersWithCityCallTimeAbove(100);
        assertEquals(3, result.size());

        System.out.println("\nАбоненты, у которых время городских переговоров превышает 100 минут:");
        result.forEach(Subscriber::display);

        assertTrue(result.stream().anyMatch(subscriber -> subscriber.getId() == 1)); // Иванов
        assertTrue(result.stream().anyMatch(subscriber -> subscriber.getId() == 4)); // Кузнецов
    }

    @Test
    public void testGetSubscribersWithLongDistanceCalls() {
        List<Subscriber> result = manager.getSubscribersWithLongDistanceCalls();
        assertEquals(4, result.size());

        System.out.println("\nАбоненты, которые пользовались междугородней связью:");
        result.forEach(Subscriber::display);

        assertTrue(result.stream().anyMatch(subscriber -> subscriber.getId() == 3));
        assertTrue(result.stream().anyMatch(subscriber -> subscriber.getId() == 4));
        assertTrue(result.stream().anyMatch(subscriber -> subscriber.getId() == 5));
    }

    @Test
    public void testGetSubscribersInAlphabeticalOrder() {
        List<Subscriber> result = manager.getSubscribersInAlphabeticalOrder();

        System.out.println("\nАбоненты в алфавитном порядке:");
        result.forEach(Subscriber::display);

        assertEquals(1, result.get(0).getId());
        assertEquals(4, result.get(1).getId());
        assertEquals(5, result.get(2).getId());
        assertEquals(2, result.get(3).getId());
        assertEquals(3, result.get(4).getId());
    }
}