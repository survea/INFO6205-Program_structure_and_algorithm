package edu.neu.coe.info6205.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class UFClient {
    public static void main(String args[]) throws IOException {
        int i=0;
        System.out.println("----------Please enter -1 to EXIT or Positive Value to continue----------");
        while(i!=-1) {
            int init=100;
            System.out.print("Enter Number of objects (n): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            i = Integer.parseInt(reader.readLine());
            if (i == -1) {
                System.exit(1);
            }
            int totalConnections=0; // total of all connection and take there average
            for (int j = 0; j < init; j++) {
                totalConnections += count(i);
            }
            System.out.println(totalConnections/init + " Random Pairs (m) generated for " + i + " objects (n). ");
        }
    }

    private static int count(int i) {
        int pair=0;

        UF_HWQUPC uf = new UF_HWQUPC(i,true);
        Random r = new Random();

        while(uf.components() > 1) {
            int a = r.nextInt(i);
            int b = r.nextInt(i);
            if(!uf.connected(a,b)) {
                uf.union(a,b);
            }
            pair++;
        }
        return pair;
    }
}
