package com.github.vacxe.dsu;

public class DSU {
    int[] p;

    DSU(int size) {
        p = new int[size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
    }

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int x, int y) {
        p[find(x)] = find(y);
    }
}
