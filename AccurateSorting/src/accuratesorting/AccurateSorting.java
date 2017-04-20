/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accuratesorting;

import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class AccurateSorting {

    /**
     * @param a
     * @param max
     * @param min
     * @return 
     */
    public static String Solution(int a[], int max, int min) {
        if (max - min == 0) {
            
         return "Yes";
        }
        if(a[max] == max) return Solution(a,max-1,min);
        if(a[max-1]==max && a[max] ==max-1){ a[max] = max;a[max-1] = max-1; return Solution(a,max-1,min);} 
        return "No";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
                 
            }
          System.out.println( Solution(a,n-1,0));
            // Write Your Code Here
        }
    }

}
