package com.github.vacxe.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    private final boolean directed;

    Graph(boolean directed) {
        this.directed = directed;
    }

    private final HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    void addEdge(int from, int to) {
        if (!map.containsKey(from)) map.put(from, new HashSet<>());
        map.get(from).add(to);
        if (!directed) {
            if (!map.containsKey(to)) map.put(to, new HashSet<>());
            map.get(to).add(from);
        }
    }

    int distance(int origin, int dest) {
        int res = dfs(origin, dest, new HashSet<>());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int origin, int dest, HashSet<Integer> visited) {
        if (origin == dest) return 0;
        if (visited.contains(origin)) return Integer.MAX_VALUE;
        if (!map.containsKey(origin)) return Integer.MAX_VALUE;
        visited.add(origin);
        int min = Integer.MAX_VALUE;
        for (int next : map.get(origin)) {
            min = Math.min(min, dfs(next, dest, visited));
        }
        visited.remove(origin);
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }
}
