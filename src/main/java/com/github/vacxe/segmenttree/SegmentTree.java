package com.github.vacxe.segmenttree;

public class SegmentTree {
    final int[] tree;
    private int n = 0;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        makeTree(nums);
    }

    int size() {
        return this.n;
    }

    private void makeTree(int[] nums) {
        for (int i = 0; i < n; i++) {
            tree[i + n] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    int rangeSum(int i, int j) {
        int sum = 0;
        i += n;
        j += n;
        for (; i <= j; ) {
            if (i % 2 == 1) {
                sum += tree[i++];
            }
            if (j % 2 == 0) {
                sum += tree[j--];
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }

    void update(int idx, int val) {
        idx += n;
        tree[idx] = val;
        idx /= 2;
        for (; idx >= 1; idx /= 2) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        }
    }
}
