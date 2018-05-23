package SortMerge;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here

        int n;
        int[] Arr;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        n = in.nextInt();

        Arr = Main.InputMass(n);
        String intArrayString = Arrays.toString(Arr);
        System.out.print("Исходный массив:        ");
        System.out.println(intArrayString);

        Main.MergeSort(Arr,0,n-1);

        intArrayString = Arrays.toString(Arr);
        System.out.print("Отсортированный массив: ");
        System.out.println(intArrayString);
    }

    public static int[] InputMass(int count) {
        int arr[];
        arr = new int [count];
        // заполнение массива случайными целыми числами из диапазона от -10 до 10
        Random rand = new Random();
        int a=-10;
        int b=10;

        for (int i=0; i<arr.length; i++)
            arr[i] = a +  rand.nextInt(b - a + 1);
        return arr;
    }

    public static void MergeSort(int A[], int p, int r)
    {
        if (p >= r) //>=, т.к. деление происходит до массивов длиной в один элемент
            return;
        {
            int q = (p + r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }

    public static void Merge(int A[], int p, int q, int r)
    {
        /* Создать L <- A[p..q] and M <- A[q+1..r] */
        int n1 = q - p + 1;
        int n2 =  r - q;

        int L[]; L = new int [n1];
        int M[]; M = new int [n2];

        for (int i = 0; i < n1; i++)
            L[i] = A[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = A[q + 1 + j];

        /* Сохранить текущий индекс подмассивов и основной массив */
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        /*Пока не будет достигнут конец L или M, выбираем те, что больше, среди элементов из L и M, и помещаем их в нужной позиции в A[p..r] */
        while (i < n1 && j < n2)
        {
            if (L[i] <= M[j])
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = M[j];
                j++;
            }
            k++;
        }

        /* Когда заканчиваются элементы в L или M, выбираем оставшиеся элементы и помещаем в A[p..r] */
        while (i < n1)
        {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            A[k] = M[j];
            j++;
            k++;
        }
    }
}
