package ua.goit.java8.module3.task3;

import java.util.Scanner;

/**
 * Created by Taras on 05.07.2017.
 */
public class TestArray3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String delims = "[,]+";
        System.out.print("Введіть декілька чисел через кому: ");
        String[] line = sc.nextLine().split(delims);

        // створюєм масив
        int[] a = new int[line.length];
        for (int i = 0; i < line.length ; i++){
            a[i] = Integer.parseInt((line[i].trim()));
        }

        // створюєм ще один масив, ідентичний першому, для демонстрації іншого методу сортування
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++){
            b[i] = a[i];
        }

        // знаходимо мінімальне число
        System.out.println();
        System.out.println("Мінімальне число в масиві: " + getMin(a));

        // знаходимо максимальне число
        System.out.println("Максимальне число в масиві: " + getMax(a));

        // знаходимо кількість повторів числа 5
        System.out.println("Кількість повторів числа 5: " + getElementCount(a,5));

        // виводимо відсортований масив методом бульбашки
        sortBubble(a);

        // виводимо відсортований масив другим методом
        sortMaxToEnd(b);

        // шукаєм максимальну та мінімальну кількість повторів
        // для цього спершу створюєм масив count[], в якому в якості елементів зберігаєм кількість повторів елементів вихідного масиву
        int[] count = new int[a.length];
        for (int i = 0; i < a.length; i++){
            count[i] = getElementCount(a, a[i]);
        }

        // шукаєм мінімальний та максимальний елементи в масиві count[]
        System.out.println("Максимальне число повторів у масиві: " + getMax(count));
        System.out.println("Мінімальне число повторів у масиві: " + getMin(count));

    }

    public static int getMin(int[] a){
        int min = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static int getMax(int[] a){
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public static int getElementCount(int[] a, int n){
        // Знаходимо кількість повторів елемента n в масиві a[]
        int count_n = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] == n){
                count_n++;
            }
        }
        return count_n;
    }

    public static void sortBubble(int[] a) {
        // Сортування бульбашкою: порівнюєм 2 сусідні елементи і якщо треба, міняєм місцями. Рухаємось зліва направо.
        for(int j = 0; j < a.length; j++) {
            for(int i = 1; i < a.length - j; i++) {
                int n = a[i];
                int p = a[i - 1];
                if(n < p) {
                    a[i - 1] = n;
                    a[i] = p;
                }
            }
        }

        printArray("Масив, відсортований бульбашкою: ",a);
    }

    public static void sortMaxToEnd(int[] a) {
        // Сортування :
        // Вибираєм максимальний з n і ставим в кінець.
        // Далі вибираєм максимальний з n-1 і ставим в кінець на місце n-1. І т.д....

        for(int j = 0; j < a.length; j++) {
            int max = a[0];
            int i_max = 0;

            for(int i = 0; i < a.length - j; i++) {
                if(a[i] > max) {
                    max = a[i];
                    i_max = i;
                }
            }

            // запихаєм максимальний елемент в кінець, а останній елемент ставим на місце знайденого максимального;
            a[i_max] = a[a.length - 1 - j];
            a[a.length - 1 - j] = max;
        }

        printArray("Масив, відсортований методом ітеративної перестановки максимального елемента в кінець: ",a);
    }

    public static void printArray(String text,int[] a){
        // Вивід масиву на друк
        System.out.print(text);
        for(int i = 0; i < a.length; i++) {
            String end = i == (a.length - 1)?"\n":",";
            System.out.print(a[i] + end);
        }
    }

}
