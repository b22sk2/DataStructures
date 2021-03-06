/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeroonegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class ZeroOneGame {

    /**
     * @param a
     * @param args the command line arguments
     * @return
     */
    public static int Sol(List<Integer> a) {
        if (a.size() <= 2) {
            return 0;
        }

        if (a.get(0) == 1) {
            a.remove(0);

        }

        if (a.get(a.size() - 1) == 1) {
            a.remove(a.size() - 1);

        }
        Sol(a);
        if (a.size() == 3) {
            boolean flag = a.get(0) == 0 && a.get(1) == 1 && a.get(2) == 0;
            if (flag) {
                flag = a.get(0) == 0 && a.get(1) == 0 && a.get(2) == 0;
                return 1;
            }
            return 0;
        }
        return Sol(a.subList(0, a.size()));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            List<Integer> seq = new ArrayList<>();
            int first, last;
            for (int sequence_i = 0; sequence_i < n; sequence_i++) {
                seq.add(in.nextInt());
            }

            if (Sol(seq) == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }// If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
        }
    }

}
