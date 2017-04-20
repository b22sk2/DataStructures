/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixlayerrotation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class MatrixLayerRotation {

    /**
     * @param mat
     * @param n
     * @param cnt
     * @return
     */
    public static int[][] Rotate(int mat[][], int n, int m,int cnt) {

        if (cnt == 0) {
            return mat;
        }
        int ret[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            ret[i] = new int[m];
        }
        int left = 0;
        int top = 0;
        int right = m - 1;
        int bottom = n - 1;

        while (true) {
            if (left >= right || top >= bottom) {
                break;
            }

            //TOP
            for (int i = left; i < right; i++) {
                ret[top][i] = mat[top][i + 1];
            }
             /* for (int i = left; i < right; i++) {
                System.out.printf("%d ", ret[top][i]);
            }*/
            //LEFT
            for (int i = top; i < bottom; i++) {
                ret[i + 1][left] = mat[i][left];
            }
                //RIGHT
            for (int i = bottom; i > top; i--) {
                ret[i - 1][right] = mat[i][right];
            }
            //BOTTOM
            for (int i = left + 1; i <= right; i++) {
                ret[bottom][i] = mat[bottom][i - 1];
            }

        

            left++;
            right--;
            top++;
            bottom--;
        }
            if(cnt == 1 )return ret;
        return Rotate(ret, n, m,cnt - 1);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = sc.nextInt();
        int mat[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            mat[i] = new int[m];
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }

        }
        int bla[][];
        bla = Rotate(mat, n,m, cnt);
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", bla[i][j]);
            }
            System.out.println();
        }

    }

}
