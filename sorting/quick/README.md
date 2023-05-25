# Blog Notes: Quick Sort

QuickSort is a highly efficient sorting algorithm and is based on partitioning of array of data into smaller arrays. The algorithm picks a pivot element, rearranges the array elements in such a way that all elements smaller than the chosen pivot element go to the left side of the pivot, and all greater elements go to the right side.

```java
class Main {
  public static void main(String[] args) {
    int[] unsortedArr = {5, 2, 1, 4, 0, 3};
    System.out.println("unsorted array: " + java.util.Arrays.toString(unsortedArr));

    quickSort(unsortedArr, 0, unsortedArr.length - 1);

    System.out.println("sorted array: " + java.util.Arrays.toString(unsortedArr));
  }

  static void quickSort(int[] arr, int low, int high) {
    if(low < high) {
      int pivotLocation = partition(arr, low, high);
      quickSort(arr, low, pivotLocation - 1);
      quickSort(arr, pivotLocation + 1, high);
    }
  }

  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int leftwall = low;

    for(int i = low; i < high; i++) {
      if(arr[i] <= pivot) {
        int temp = arr[i];
        arr[i] = arr[leftwall];
        arr[leftwall] = temp;
        leftwall+=1;
      }
    }

    int temp = arr[leftwall];
    arr[leftwall] = arr[high];
    arr[high] = temp;

    return leftwall;
  }
}
```
## Trace

## Pass 1

We start with our `quickSort` function, setting our `low` to `0` and `high` to `5`. We check if `low < high` and it is, so we enter into the partition phase.

Given an array with elements [5, 2, 1, 0, 4, 3], we set our pivot to the value at the high index, which is 3. We also set our leftwall to 0 initially.

We start iterating over the array from the low index (0) to high - 1 index (4).

The first element we encounter is 5, which is not less than our pivot (3), so we continue to the next element.

When encountering the second element, 2, which is smaller than the pivot, we swap it with the element at the leftwall position and increment leftwall.

We continue this process until we've gone through the entire array. The array now looks like `[2, 1, 0, 4, 5, 3]`, and `leftwall` is at index `3`.

Finally, we swap our `pivot` with the value at `leftwall`, which gives us `[2, 1, 0, 3, 5, 4]`. `leftwall` is now our `pivotLocation`.

## Pass 2


After the partition phase, we recursively apply the quickSort algorithm to the two subarrays divided by the pivot location: the left subarray [2, 1, 0] and the right subarray [5, 4].

When we apply quickSort on the left subarray [2, 1, 0], the partition phase takes place, and the pivot is chosen as 0. After partitioning the subarray, we obtain the sorted subarray [0, 1, 2].

## Pass 3

Then, we apply `quickSort` on the right subarray. We partition the array around the pivot which is `4`, leaving the array as `[4, 5]`.

### Final Array

After all the passes, the array becomes fully sorted and now looks like this: `[0, 1, 2, 3, 4, 5]`.

The `quickSort` algorithm has successfully sorted the array.

## Efficiency

- Time Complexity: O(n log n) on average, but O(n^2) in the worst case.

- Space Complexity: O(log n)





