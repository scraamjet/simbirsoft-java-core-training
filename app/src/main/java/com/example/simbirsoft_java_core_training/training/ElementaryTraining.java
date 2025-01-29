package com.example.simbirsoft_java_core_training.training;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        return (firstValue + secondValue) / 2.0;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        int newFirstValue = firstValue * 2;
        int newSecondValue = secondValue - 3;
        int newThirdValue = thirdValue * thirdValue;
        return newFirstValue + newSecondValue + newThirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        return value > 3 ? value + 10 : value - 10;
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers(int value) {
        if (value < 10) return value;

        String number = Integer.toString(value);
        if (number.length() > 5) throw new IllegalArgumentException("Максимум пятизначное число.");

        char[] digits = number.toCharArray();
        char temp = digits[0];
        digits[0] = digits[digits.length - 1];
        digits[digits.length - 1] = temp;

        return Integer.parseInt(new String(digits));
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {
        if (value < 10) return value;

        String number = String.valueOf(value);
        StringBuilder result = new StringBuilder();

        for (char digit : number.toCharArray()) {
            if (Character.getNumericValue(digit) % 2 == 0) {
                result.append("0");
            } else {
                result.append(digit);
            }
        }
        return Integer.parseInt(result.toString());
    }
}
