import java.io.*;
import java.util.*;

public class DataGenerator {

    private static final int NUM_SETS = 60;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        generateTestData("test_data.txt");
        System.out.println("Файл с тестовыми данными успешно создан!");
    }

    public static void generateTestData(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int setNum = 0; setNum < NUM_SETS; setNum++) {
                // Генерируем случайный размер набора (от 10 до 1000 элементов)
                int size = 10 + random.nextInt(991);

                // Создаем список с числами
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    numbers.add(MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE + 1));
                }

                // Записываем числа в строку через пробел
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < numbers.size(); i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(numbers.get(i));
                }

                writer.write(sb.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
