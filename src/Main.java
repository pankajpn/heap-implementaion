import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*
        *
        *
        * You are given an array A of integers that represent the lengths of ropes.
        * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
        * Find and return the minimum cost to connect these ropes into one rope.
        *
        */

        Solution sol = new Solution();

        ArrayList<Integer> ropes = new ArrayList<>();

        for(int i = 1; i<6; i++) {
            ropes.add(i);
        }

        int cost = sol.solve(ropes);

        System.out.println(cost);


    }

    public static class Solution {
        public int solve(ArrayList<Integer> A) {

            // we can create heap array and every time we take two min length ropes and join them, and add to the cost,
            // and again add the joined rope to the array

            // Edge case: If there's 0 or 1 rope, no cost is incurred
            if (A == null || A.size() <= 1) {
                return 0;
            }

            ArrayList<Integer> heap = new ArrayList<>(A);
            int n = heap.size();

            // 1. Build the Min-Heap from the first non-leaf node
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(heap, i, heap.size());
            }

            int totalCost = 0;

            // 2. Extract the two smallest ropes, combine them, and push back
            while (heap.size() > 1) {
                // Extract the smallest element (root)
                int first = extractMin(heap);
                // Extract the second smallest element
                int second = extractMin(heap);

                int combined = first + second;
                totalCost += combined;

                // Insert the combined rope back into the heap
                insert(heap, combined);
            }

            return totalCost;
        }

        // Helper to extract the minimum element (root) from the heap
        private int extractMin(ArrayList<Integer> heap) {
            int min = heap.get(0);
            int last = heap.remove(heap.size() - 1); // Remove the last element

            if (!heap.isEmpty()) {
                heap.set(0, last); // Move last element to root
                heapify(heap, 0, heap.size()); // Restore min-heap property downwards
            }
            return min;
        }

        // Helper to insert a new element into the heap (Sift-Up)
        private void insert(ArrayList<Integer> heap, int val) {
            heap.add(val); // Add to the end
            int i = heap.size() - 1;

            // Bubble up while child is smaller than its parent
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(i) < heap.get(parent)) {
                    swap(heap, i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        // Standard Sift-Down heapify with boundary limit 'n'
        private void heapify(ArrayList<Integer> heap, int i, int n) {
            while (2 * i + 1 < n) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < n && heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }
                if (right < n && heap.get(right) < heap.get(smallest)) {
                    smallest = right;
                }

                if (smallest != i) {
                    swap(heap, i, smallest);
                    i = smallest;
                } else {
                    break;
                }
            }
        }

        private void swap(ArrayList<Integer> heap, int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}