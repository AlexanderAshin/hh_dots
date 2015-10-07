package com.hh_dots;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int n = 0,i,j;
        double distance;
        Scanner in = new Scanner(System.in);
        while (n < 1) {// если значение N меньше 1 - вводим ещё раз
            System.out.print("Enter N ");
            n = in.nextInt();//ввод N
        }
        double [][] dotsData= new double[n][4]; //инициализация массива
        for(i = 0; i < n; i++)
            dotsData[i] = new double[4];
        for(i = 0; i < n; i++){ //вод XY и форматирование массива
            System.out.printf("X(%d)= ", i+1);
            dotsData[i][0] = in.nextDouble(); //X
            System.out.printf("Y(%d)= ", i+1);
            dotsData[i][1] = in.nextDouble(); //Y
            dotsData[i][2] = (n == 1) ? 0 : Double.MAX_VALUE; //«радиус»
            dotsData[i][3]=0;//счетчик «соседей»
        }
        for (i = 0; i<n-1; i++) //расчет «радиусов»
            for(j = i+1; j<n; j++){
                distance = Math.sqrt(Math.pow(dotsData[j][0] - dotsData[i][0], 2) + Math.pow(dotsData[j][1] - dotsData[i][1], 2));
                if(dotsData[i][2] > distance)dotsData[i][2] = distance;
                if(dotsData[j][2] > distance)dotsData[j][2] = distance;
            }
        for (i = 0;i < n-1; i++) //расчет количества «соседей»
            for(j = i+1; j<n; j++){
                distance = Math.sqrt(Math.pow(dotsData[j][0] - dotsData[i][0], 2) + Math.pow(dotsData[j][1] - dotsData[i][1], 2));
                if(dotsData[i][2]*2 >= distance)dotsData[i][3]++;
                if(dotsData[j][2]*2 >= distance)dotsData[j][3]++;
            }
        for (i = 0; i<n; i++) //вывод результатов
            System.out.printf("X(%.0f,%.0f) Rad: %.5f CON: %.0f\n",dotsData[i][0], dotsData[i][1], dotsData[i][2], dotsData[i][3]);
    }
}