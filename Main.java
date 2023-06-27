import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the integers (separated by spaces): ");
        String input = scanner.nextLine();

        // Input validation
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            scanner.close(); // Close the scanner before returning or exiting
            return; // Exit the program or handle the error appropriately
        }

        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        List<int[]> firstCombinations = findCombinations(nums, target);
        System.out.println("First Combination for \"" + target + "\":");
        for (int[] combination : firstCombinations) {
            System.out.println(Arrays.toString(combination));
        }

        int[] mergedArray = mergeArrays(firstCombinations);
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

        int doubledTarget = target * 2;
        List<int[]> secondCombinations = findCombinations(mergedArray, doubledTarget);
        System.out.println("Second Combination for \"" + doubledTarget + "\":");
        for (int[] combination : secondCombinations) {
            System.out.println(Arrays.toString(combination));
        }

        scanner.close();
    }

//     // Rest of the code...

//     public static List<int[]> findCombinations(int[] nums, int target) {
//         // Method implementation
//     }

//     public static int[] mergeArrays(List<int[]> arrays) {
//         // Method implementation
//     }
// }


// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the integers (separated by spaces): ");
//         String input = scanner.nextLine();

//         // Input validation
//         if (input.isEmpty()) {
//             System.out.println("Input cannot be empty.");
//             return; // Exit the program or handle the error appropriately
//         }

//         int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

//         System.out.print("Enter the target value: ");
//         int target = scanner.nextInt();

//         List<int[]> firstCombinations = findCombinations(nums, target);
//         System.out.println("First Combination for \"" + target + "\":");
//         for (int[] combination : firstCombinations) {
//             System.out.println(Arrays.toString(combination));
//         }

//         int[] mergedArray = mergeArrays(firstCombinations);
//         System.out.println("Merged Array: " + Arrays.toString(mergedArray));

//         int doubledTarget = target * 2;
//         List<int[]> secondCombinations = findCombinations(mergedArray, doubledTarget);
//         System.out.println("Second Combination for \"" + doubledTarget + "\":");
//         for (int[] combination : secondCombinations) {
//             System.out.println(Arrays.toString(combination));
//         }

//         scanner.close();
//     }

    // Rest of the code...




    public static List<int[]> findCombinations(int[] nums, int target) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<int[]> result = new ArrayList<>();
        for (int num : nums) {
            int diff = target - num;
            if (frequency.containsKey(diff) && frequency.get(diff) > 0) {
                result.add(new int[]{num, diff});
                frequency.put(diff, frequency.get(diff) - 1);
            }
        }

        return result;
    }

    public static int[] mergeArrays(List<int[]> arrays) {
        int totalLength = 0;
        for (int[] array : arrays) {
            totalLength += array.length;
        }

        int[] mergedArray = new int[totalLength];
        int index = 0;
        for (int[] array : arrays) {
            for (int num : array) {
                mergedArray[index++] = num;
            }
        }

        Arrays.sort(mergedArray);
        return mergedArray;
    }
}



