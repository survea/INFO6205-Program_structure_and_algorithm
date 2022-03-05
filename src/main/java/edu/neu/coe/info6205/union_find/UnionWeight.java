package edu.neu.coe.info6205.union_find;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnionWeight {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // points 5
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int n = 5;
        System.out.print("points :"+n);
        // connections 3
        int m = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.print("connections :"+m);

        UnionFind uf = new UnionFind(n);
        for(int i=0;i<m;i++){
            String[] arr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            uf.union(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        // print result
        System.out.print("groups :"+uf.groups);
        bufferedReader.close();
    }

}

class UnionFind{
    int[] p;    // parent id
    int[] w;    // weight
    int n;      // size of points
    int groups; // how many groups

    public UnionFind(int n){
        this.n = n;
        p = new int[n];
        w = new int[n];

        // Set up parent id at initial stage
        for(int i=0; i<n; i++){
            // To Be Implemented
            p[i] = i;
            w[i] = 1;
        }
        groups = n;
    }

    public void union(int a, int b){
        int pa = find(p[a]);
        int pb = find(p[b]);
        if(pa==pb) return;

        // Union with weight
        if(w[pa] > w[pb]){
            // To Be Implemented
            p[pb] = pa;
        }
        else if(w[pa] < w[pb]){
            // To Be Implemented
            p[pa]= pb;
        }
        else{
            // To Be Implemented
            p[pb] = pa;
            w[pa] +=1;
        }
        groups--;
    }

    public boolean connected(int a, int b){
        // To Be Implemented
        return find(a) ==find(b);

    }

    public int find(int a){
        // To Be Implemented
        while(a != p[a]){
            a = p[a];
        }
        return a;
    }
}