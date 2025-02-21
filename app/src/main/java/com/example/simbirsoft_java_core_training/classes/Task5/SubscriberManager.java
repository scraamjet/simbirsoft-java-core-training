package com.example.simbirsoft_java_core_training.classes.Task5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberManager {

    private List<Subscriber> subscribers;

    public SubscriberManager(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public List<Subscriber> getSubscribersWithCityCallTimeAbove(int threshold) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getCityCallTime() > threshold)
                .collect(Collectors.toList());
    }

    public List<Subscriber> getSubscribersWithLongDistanceCalls() {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getLongDistanceCallTime() > 0)
                .collect(Collectors.toList());
    }

    public List<Subscriber> getSubscribersInAlphabeticalOrder() {
        return subscribers.stream()
                .sorted(Comparator.comparing(Subscriber::getLastName)
                        .thenComparing(Subscriber::getFirstName)
                        .thenComparing(Subscriber::getMiddleName))
                .collect(Collectors.toList());
    }
}
