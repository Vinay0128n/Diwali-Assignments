public class QuickSortStringsExample {


    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition 
    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareToIgnoreCase(pivot) <= 0) {
                i++;
                // swap arr[i] and arr[j]
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap 
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Display 
    private static void display(String[] arr) {
        for (String str : arr) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }  

    
    public static void main(String[] args) {
        String[] arr = { "banana", "Apple", "grape", "cherry", "Mango" };

        System.out.println("Before Sorting:");
        display(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nAfter Sorting:");
        display(arr);
    }
}
