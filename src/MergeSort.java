import java.io.*;
import java.util.*;


public class MergeSort {
    public static void main(String[] args) {
        List<int[]> list = readAllDataSets("test_data.txt");

        mergeSort(list.get(0));
        for (int x : list.get(0)) {
            System.out.println(x);
        }
    }

    public static void mergeSort(int[] array) {
        int length  = array.length;
        if (length <= 1) return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];


        int j = 0;
        for (int i = 0; i < length; ++i) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, array);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int l = 0, r = 0, i = 0;
        while (l < leftLength && r < rightLength) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }

        while (l < leftLength) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightLength) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static List<int[]> readAllDataSets(String filename) {
        List<int[]> allDataSets = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] numbersStr = line.trim().split("\\s+");
                int[] numbers = new int[numbersStr.length];

                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Integer.parseInt(numbersStr[i]);
                }

                allDataSets.add(numbers);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return allDataSets;
    }
}
