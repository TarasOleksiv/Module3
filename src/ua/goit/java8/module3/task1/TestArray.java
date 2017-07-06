package ua.goit.java8.module3.task1;

import java.util.Scanner;

/**
 * Created by Taras on 05.07.2017.
 */
public class TestArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть розмір масиву: ");
        int dim = sc.nextInt();
        sc.nextLine();

        String delims = "[,]+";
        String[] line;
        while(true){
            System.out.print("Введіть " + dim + " чисел через кому: ");
            line = sc.nextLine().split(delims);
            if (line.length == dim) {
                break;
            }
            System.out.println("Введена кількість чисел не дорівнює " + dim);
        }

        // створюєм масив
        int[] a = new int[dim];
        for (int i = 0; i < dim ; i++){
            a[i] = Integer.parseInt((line[i].trim()));
        }

        // створюєм ще один масив, ідентичний першому, для демонстрації іншого методу сортування
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++){
            b[i] = a[i];
        }

        // знаходимо мінімальне та максимальне число
        getMinMax(a);

        // знаходимо кількість повторів числа 5
        getElementCount(a,5);

        // виводимо відсортований масив методом бульбашки
        sortBubble(a);

        // виводимо відсортований масив другим методом
        sortMaxToEnd(b);
    }

    public static void getMinMax(int[] a){
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
            }
            if (a[i] > max){
                max = a[i];
            }
        }
        System.out.println();
        System.out.println("Мінімальне число в масиві: " + min);
        System.out.println("Максимальне число в масиві: " + max);
    }

    public static void getElementCount(int[] a, int n){
        // Знаходимо кількість повторів елемента n в масиві a[]
        int count_n = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] == n){
                count_n++;
            }
        }
        System.out.println("Кількість повторів числа " + n + ": " + count_n);
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
