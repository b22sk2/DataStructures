/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author baasankhuu.d
 */
public class Contacts {

    /**
     * @param args the command line arguments
     */
    public static int count(List<String> list, String s) {
        int cnt = 0;
        for (String ss : list) {
            if(ss.startsWith(s))cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        List<String> list;
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
     
        for (int i = 0; i < n; i++) {
            String s = sc.next();
           if (s.equals("add")) {
                list.add(sc.next());
            }
            else
                System.out.println(count(list,sc.next()));
       
        }
        sc.close();

    }

}
