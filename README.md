Step-by-Step Breakdown
Building the Heap (heapify):

Building a heap from an unsorted array of size N using bottom-up heapification takes O(N) time. Even though there are N elements, most nodes are near the bottom and have shorter heights to sift down, making the mathematical sum linear.

The While Loop Operations (Extract and Insert):

The while loop runs N−1 times because we extract two elements and insert one back until only a single element remains.

In each iteration of the loop:

Extracting the minimum (extractMin): This involves swapping the root with the last element and calling heapify (sift-down) from the top. The height of a heap with N elements is log 
2
​
 N, so this operation takes O(logN) time.

Inserting the combined rope (insert): This involves adding the new element to the end and bubbling it up (sift-up) to its correct position. The maximum distance it can travel up is also the height of the tree, taking O(logN) time.

Total Loop Cost:

Running both extractMin and insert (which each take O(logN) time) for roughly N iterations results in:

O(N×logN)
Summary of Complexities
Time Complexity: O(NlogN)

Dominated by the N iterations of extracting and inserting elements into the heap.

Space Complexity: O(N)

We store the elements in an auxiliary ArrayList (heap) which takes linear space proportional to the input size.
