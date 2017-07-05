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

        int[] a = new int[dim];
        // створюєм масив
        for (int i = 0; i < dim ; i++){
            a[i] = Integer.parseInt((line[i].trim()));
        }

        // знаходимо мінімальне, максимальне число та кількість повторів числа 5 в одному циклі
        getMinMax5(a);

        // виводимо відсортований масив
        sortBubble(a);
    }

    public static void getMinMax5(int[] a){
        int min = a[0];
        int max = a[0];
        int count_5 = 0;
        for (int i = 1; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
            }
            if (a[i] > max){
                max = a[i];
            }
            if (a[i] == 5){
                count_5++;
            }
        }
        System.out.println();
        System.out.println("Мінімальне число в масиві: " + min);
        System.out.println("Максимальне число в масиві: " + max);
        System.out.println("Кількість повторів числа 5: " + count_5);
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

        System.out.print("Відсортований бульбашкою масив: ");
        for(int i = 0; i < a.length; i++) {
            String end = i == (a.length - 1)?"":",";
            System.out.print(a[i] + end);
        }
    }
}
