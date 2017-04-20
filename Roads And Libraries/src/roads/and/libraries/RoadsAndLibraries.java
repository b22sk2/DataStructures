/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roads.and.libraries;

import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class RoadsAndLibraries {

    /**
     * @param arr
     * @param x
     * @param y
     * @param m
     * @param n
     * @return
     */
    public static int sol(int arr[][], int x, int y, int n, int m) {

        int libC = 0;
        int roadC = 0;
        if (x >= y) {
            return n * y;
        }
        int start = 0;
        int vis[] = new int[n];
        while (start < n) {
            if (vis[start] == 1) {
                start++;
                continue;
            }
            else{
                 vis[start] = 1;
                 for (int i = 0; i < n; i++) {
                if(arr[start][i]==1){vis[i]=1;roadC+=x;}
            }
            start++;
               libC+=y;  
            }
           
           
            
        }

        return libC + roadC;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int arr[][] = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[n];
            }
            for (int a1 = 0; a1 < m; a1++) {
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                arr[city_1-1][city_2-1] = 1;
                arr[city_2-1][city_1-1] = 1;
            }
            System.out.println(sol(arr,x,y,n,m));
        }
    }
}


