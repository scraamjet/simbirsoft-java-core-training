package com.example.simbirsoft_java_core_training.classes.Task5;

/**
 * Доступна проверка тестированием @see SubscriberManagerTest.
 */
public class Subscriber {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private int cityCallTime;
    private int longDistanceCallTime;

    public Subscriber(int id, String lastName, String firstName, String middleName, String address,
                      String creditCardNumber, double debit, double credit, int cityCallTime, int longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.cityCallTime = cityCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getCityCallTime() {
        return cityCallTime;
    }

    public void setCityCallTime(int cityCallTime) {
        this.cityCallTime = cityCallTime;
    }

    public int getLongDistanceCallTime() {
        return longDistanceCallTime;
    }

    public void setLongDistanceCallTime(int longDistanceCallTime) {
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public void display() {
        System.out.printf("ID: %d, %s %s %s, Адрес: %s, Кредитная карта: %s, Дебет: %.2f, Кредит: %.2f, Городские звонки: %d мин, Междугородные звонки: %d мин\n",
                id, lastName, firstName, middleName, address, creditCardNumber, debit, credit, cityCallTime, longDistanceCallTime);
    }
}
