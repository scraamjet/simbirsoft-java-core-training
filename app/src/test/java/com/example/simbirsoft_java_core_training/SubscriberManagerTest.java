package com.example.simbirsoft_java_core_training;

import com.example.simbirsoft_java_core_training.classes.Task5.Subscriber;
import com.example.simbirsoft_java_core_training.classes.Task5.SubscriberManager;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SubscriberManagerTest {

    private static SubscriberManager manager;

    @BeforeClass
    public static void init() {
        List<Subscriber> subscribers = Arrays.asList(
                new Subscriber(1, "Иванов", "Иван", "Иванович", "ул. Ленина, 10", "1234-5678-9101", 500, 100, 150, 30),
                new Subscriber(2, "Петров", "Петр", "Петрович", "ул. Гагарина, 5", "9876-5432-1098", 200, 50, 80, 0),
                new Subscriber(3, "Сидоров", "Алексей", "Владимирович", "ул. Кирова, 3", "3456-7890-1234", 100, 70, 200, 20),
                new Subscriber(4, "Кузнецов", "Сергей", "Олегович", "ул. Победы, 15", "6789-0123-4567", 300, 90, 120, 50),
                new Subscriber(5, "Морозов", "Дмитрий", "Игоревич", "ул. Чехова, 7", "1122-3344-5566", 400, 60, 50, 10)
        );

        manager = new SubscriberManager(subscribers);
    }

    @Test
    public void testGetSubscribersWithCityCallTimeAbove() {
        List<Subscriber> result = manager.getSubscribersWithCityCallTimeAbove(100);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());

        System.out.println("\nАбоненты, у которых время городских переговоров превышает 100 минут:");
        result.forEach(Subscriber::display);

        List<Integer> expectedIds = Arrays.asList(1, 3, 4);
        List<Integer> actualIds = result.stream().map(Subscriber::getId).collect(Collectors.toList());

        assertTrue(actualIds.containsAll(expectedIds));
    }

    @Test
    public void testGetSubscribersWithLongDistanceCalls() {
        List<Subscriber> result = manager.getSubscribersWithLongDistanceCalls();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(4, result.size());

        System.out.println("\nАбоненты, которые пользовались междугородней связью:");
        result.forEach(Subscriber::display);

        List<Integer> expectedIds = Arrays.asList(1, 3, 4, 5);
        List<Integer> actualIds = result.stream().map(Subscriber::getId).collect(Collectors.toList());

        assertTrue(actualIds.containsAll(expectedIds));
    }

    @Test
    public void testGetSubscribersInAlphabeticalOrder() {
        List<Subscriber> result = manager.getSubscribersInAlphabeticalOrder();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(5, result.size());

        System.out.println("\nАбоненты в алфавитном порядке:");
        result.forEach(Subscriber::display);

        List<Integer> expectedOrder = Arrays.asList(1, 4, 5, 2, 3);
        List<Integer> actualOrder = result.stream().map(Subscriber::getId).collect(Collectors.toList());

        assertEquals(expectedOrder, actualOrder);
    }
}