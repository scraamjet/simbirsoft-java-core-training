package com.example.simbirsoft_java_core_training.training;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < text.length(); i += 2) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {
        if (text.isEmpty()) {
            return new int[]{};
        }

        int lengthWithoutLastSymbol = text.length() - 1;
        char lastChar = text.charAt(lengthWithoutLastSymbol);
        int count = 0;

        for (int i = 0; i < lengthWithoutLastSymbol; i++) {
            if (text.charAt(i) == lastChar) {
                count++;
            }
        }

        int[] indices = new int[count];
        int index = 0;

        for (int i = 0; i < lengthWithoutLastSymbol; i++) {
            if (text.charAt(i) == lastChar) {
                indices[index++] = i;
            }
        }
        return indices;
    }



    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {
        int count = 0;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(words[c - '0']);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            switch (Character.getType(c)) {
                case Character.UPPERCASE_LETTER:
                    result.append(Character.toLowerCase(c));
                    break;
                case Character.LOWERCASE_LETTER:
                    result.append(Character.toUpperCase(c));
                    break;
                default:
                    result.append(c);
            }
        }
        return result.toString();
    }
}
