/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.array.ds;

import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class ArrayDS {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 6;
        int array[][] = new int[size][];
        for(int i = 0;i<size;i++)array[i] = new int[size];
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int i = 1; i < size - 1; i++) {

            for (int j = 1; j < size - 1; j++) {
                int sum = array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1] + array[i][j] + array[i + 1][j - 1] + array[i + 1][j] + array[i + 1][j + 1];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.print(max);
    }

}
