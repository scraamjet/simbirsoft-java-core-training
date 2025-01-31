package com.example.simbirsoft_java_core_training.classes.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberManager {

    private List<Subscriber> subscribers;

    public SubscriberManager() {
        this.subscribers = new ArrayList<>();
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
                .sorted((s1, s2) -> {
                    int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
                    if (lastNameComparison != 0) {
                        return lastNameComparison;
                    }
                    int firstNameComparison = s1.getFirstName().compareTo(s2.getFirstName());
                    if (firstNameComparison != 0) {
                        return firstNameComparison;
                    }
                    return s1.getMiddleName().compareTo(s2.getMiddleName());
                })
                .collect(Collectors.toList());
    }
}
