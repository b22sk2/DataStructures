/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colliding.circles;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class CollidingCircles implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static double Sum(List<Integer> list) {
        
        double pi = (double) 3.14159265;
        if(list.size() == 2)return  (Math.PI)*(list.get(0) + list.get(1))*(list.get(0) + list.get(1));
        double res = 0;
        double sum = 0;
        for(int i = 0;i<list.size();i++)sum+=list.get(i) * list.get(i);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    double temp = (list.get(i) + list.get(j)) * (list.get(i) + list.get(j));
                           double bla = sum - list.get(i) * list.get(i) - list.get(j) * list.get(j);
                    res = res + 2*list.get(i)*list.get(j) + sum ;
                }
            }
        }
        
        return ((Math.PI) * res / list.size()/2);
    }

    public static double Sol(List<Integer> list, int k) {
        if (k == 1) {
            return Sum(list);
        } else {
            int bla = list.remove(0);
            bla = bla + list.remove(0);
            list.add(bla);
            
            return Sol(list, k - 1);
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> r = new ArrayList<>();
        for (int r_i = 0; r_i < n; r_i++) {
            r.add(in.nextInt());
        }
        System.out.printf("%.9f",Sol(r, k));
    }

}
