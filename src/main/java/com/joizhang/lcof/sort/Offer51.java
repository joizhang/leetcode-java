package com.joizhang.lcof.sort;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class Offer51 {
    private int count;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        count = 0;
        int[] aux = new int[n];
        mergeSort(nums, aux, 0, n - 1);
        return count;
    }

    private void mergeSort(int[] nums, int[] aux, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, aux, l, mid);
        mergeSort(nums, aux, mid + 1, r);
        merge(nums, aux, l, mid, r);
    }

    private void merge(int[] nums, int[] aux, int l, int mid, int r) {
        if (r + 1 - l >= 0) System.arraycopy(nums, l, aux, l, r + 1 - l);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j];
                j++;
            } else if (j > r) {
                nums[k] = aux[i];
                i++;
            } else if (aux[i] <= aux[j]) {
                nums[k] = aux[i];
                i++;
            } else {
                nums[k] = aux[j];
                j++;
                // 表示 nums[i, mid] 均大于 nums[j]
                count += (mid - i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Offer51 test = new Offer51();
        System.out.println(test.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(test.reversePairs(new int[]{7, 3, 2, 6, 0, 1, 5, 4}));
    }
}
