package ru.geekbrains.java_one.lesson_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lesson_2 {

/* 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0; */

private static int[] arr1 = {0,1,1,1,0,1,1,0,0,0,0,0,1};
private static void convertArray_0_1(@NotNull int[] arr){
    if(arr.length > 0)
      for (int j = 0; j < arr.length; j++) {
        if (arr[j]==0 || arr[j]==1) arr[j] = arr[j]==1 ? 0 : 1;
      }
    /* или можно такой цикл применить
    int i=0;
    if(arr.length > 0)
    do {
        if (arr[i]==0 || arr[i]==1) arr[i] = arr[i]==1 ? 0 : 1;
    } while(++i < arr.length);
    */
}

/* 2 Задать пустой целочисленный массив размером 8.
Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22; */

private static int[] arr2=new int[8];
private static void fillArray(){
    arr2[0]=1;
    for (int i = 1; i < arr2.length; i++) arr2[i]=arr2[i-1]+3;

    /*
    или можно такой цикл применить
    int[] arr = {1,4,7,10,13,16,19,22};
    for (int i = 0; i < arr2.length; i++) arr2[i]=arr[i]
     */
}

/* 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2; */

private static int[] arr3 = {1,5,3,2,11,4,5,2,4,8,9,1};
private static int[] calcArray62(@NotNull int[] arr){
    for (int i = 0; i < arr.length; i++) if (arr[i] < 6) arr[i] *= 2; // или так arr[i] = arr[i] < 6 ? arr[i]*2 : arr[i];
    return arr; //скучно, решил вернуть массив
}

/* 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;*/

private static int[] arr4 = {2,5,7,24,15,-7,0,8,4,18,1};
private static int arrayMin(@NotNull int[] arr){
        int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = arr[i] > min ? min : arr[i];
        }
return min;
}
private static int arrayMax(@NotNull int[] arr){
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
}

/* 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы); */
private static void fillDiagArray(int x){
    int[][] arr = new int[x][x];
    for (int i = 0; i < x; i++){
        for (int j = 0; j < x; j++){
            if (j==i || j==(x-i-1)) arr[i][j] = 1;
            System.out.printf("%3d",arr[i][j]);
        }
        System.out.println();
    }
}

/* 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
Абстрактная граница показана символами ||, эти символы в массив не входят. */

private static int[] arr5 = {2,5,1,3,3,2};
private static boolean partsArray(@NotNull int[] arr){
int leftsum=0, rightsum;
    for (int i = 0; i < arr.length; i++){
        rightsum=0;
        leftsum+=arr[i];
        for (int j = arr.length-1; j > i; j--) rightsum+=arr[j];
        if (leftsum==rightsum) return true;
    }
    return false;
}

/*
7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен циклически сместить все элементы массива на n позиций.
 */
private static int[] arr6 = {1,2,3,4,5,6};
@NotNull
@Contract(pure = true)
public static int[] arrayOffset(@NotNull int[] arr, int n){
    int[] arr1 = new int[arr.length];
    int preOffSet = n % arr.length; // если n > кол-ва элементов в массиве
    if (preOffSet != 0) n = preOffSet; // если n > кол-ва элементов в массиве
    int offSet = (n>=0) ? n : arr.length+n; //вычисляем сдвиг
        for (int i = 0; i < arr.length; i++) { //заполняем второй массив
            if ((i + offSet) == arr.length) offSet =  - i;
            arr1[i] = arr[i + offSet];
        }
    return arr1;
}

/*
8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
 */
private static int[] arr7 = {1,2,3,4,5,6};
    @NotNull
    @Contract("_, _ -> param1")
    public static int[] arrayOffset2(@NotNull int[] arr, int n){
        int preOffSet = n % arr.length; // если n > кол-ва элементов в массиве
        if (preOffSet != 0) n = preOffSet; // если n > кол-ва элементов в массиве
        int offSet = (n>=0) ? n : arr.length + n; //вычисляем сдвиг
        int k;
        for (int i = 0; i < offSet; i++) {
            if ((i + offSet) == arr.length) offSet =  - i;
            k = arr[i];
            arr[i] = arr[i + offSet];
            arr[i + offSet]=k;
        }
        return arr;
    }


public static void main(String[] args){
    //Выводим на экран массив до и после работы метода convertArray_0_1
    System.out.print("Задание 1: до работы метода " + Arrays.toString(arr1));
    convertArray_0_1(arr1);
    System.out.println(" -> после работы метода " + Arrays.toString(arr1));

    //Выводим на экран массив до и после работы метода fillArray
    System.out.print("Задание 2: до работы метода " + Arrays.toString(arr2));
    fillArray();
    System.out.println(" -> после работы метода " + Arrays.toString(arr2));

    //Выводим на экран массив до и после работы метода fillArray
    System.out.println("Задание 3: до работы метода " + Arrays.toString(arr3) + " -> результат работы метода " + Arrays.toString(calcArray62(arr3)));

    //Выводим на экран результат работы arrayMin и arrayMax
    System.out.println("Задание 4: Ищем в массиве " + Arrays.toString(arr4) + " Min: " + arrayMin(arr4) + " Max: " + arrayMax(arr4));

    //Выводим на экран результат работы fillDiagArray
    System.out.println("Задание 5:");
    fillDiagArray(9);

    //Выводим на экран результат работы partsArray
    System.out.println("Задание 6: Передаем массив" + Arrays.toString(arr5) + " -> результат работы метода -> " + partsArray(arr5));

    //Выводим на экран массив до и после работы метода arrayOffset
    int n=-21;
    System.out.println("Задание 7: до работы метода " + Arrays.toString(arr6) + " -> после работы метода " + Arrays.toString(arrayOffset(arr6,n))+" осуществлен сдвиг на "+ n);

    //Выводим на экран массив до и после работы метода arrayOffset2
    n=-21;
    System.out.println("Задание 8: до работы метода " + Arrays.toString(arr7) + " -> после работы метода " + Arrays.toString(arrayOffset2(arr7,n))+" осуществлен сдвиг на "+ n);
}

}
