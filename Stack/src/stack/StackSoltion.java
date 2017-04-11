/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class StackSoltion {

    /**
     * @param a
     * @param curmax
     * @param args the command line arguments
     * @return
     */
    public static int max(Stack a, int curmax) {
        if (a.rest == null) {
            return curmax;
        }
        int k = a.pull();
        if (k > curmax) {
            return max(a, k);
        }
        return 0;

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack a;
        a = new Stack();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                a.push(sc.nextInt());
            }
            if (k == 2) {
                a.pull();
            }
            if (k == 3) {
                System.out.println(a.getMax());
            }
        }

    }

    static class Stack {

        private int data;
        private Stack rest = null;
        private int max = 0;

        public int getMax() {
            if(rest != null && data>rest.max)max=data;
            return max;
        }

        public void push(int insertion) {
            Stack temp = new Stack();
            temp.data = data;
            temp.rest = rest;
            
              
              
              
              

            this.data = insertion;
            this.rest = temp;
            if(data<rest.getMax())max=this.rest.getMax();
            else
                this.max = this.data;
          
        }

        public int pull() {
            int res = this.data;
            if (rest == null) {
                return 0;
            } else {
                  this.max = rest.max;
                this.data = rest.data;
              
                this.rest = rest.rest;

                return res;
            }

        }

    }

}
