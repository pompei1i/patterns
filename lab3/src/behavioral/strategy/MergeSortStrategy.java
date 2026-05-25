package behavioral.strategy;

public class MergeSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] data) { mergeSort(data, 0, data.length - 1); }

    private void mergeSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(int[] a, int lo, int mid, int hi) {
        int[] left  = java.util.Arrays.copyOfRange(a, lo, mid + 1);
        int[] right = java.util.Arrays.copyOfRange(a, mid + 1, hi + 1);
        int i = 0, j = 0, k = lo;
        while (i < left.length && j < right.length)
            a[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < left.length)  a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }

    @Override public String name() { return "MergeSort"; }
}
