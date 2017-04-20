/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.ds;

import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class ArrayDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int array[] = new int [n];
      for(int i = 0;i<n;i++)array[i]=sc.nextInt();
      for(int i = 0;i<n;i++)System.out.print(array[n-1-i] + " ");
    }
    
}
