/*
1. Plus One 
Given a non-negative number represented as a list of digits, add 1 to the number (increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array.
 

Example 1:

Input: 
N = 3
arr[] = {1, 2, 4}
Output: 
1 2 5
Explanation:
124+1 = 125, and so the Output
Example 2:

Input: 
N = 3
arr[] = {9,9,9}
Output: 
1 0 0 0
Explanation:
999+1 = 1000, and so the output

Your Task:
You don't need to read input or print anything. You only need to complete the function increment() that takes an integer N, and an array arr of size N as input and returns a list of integers denoting the new number which we get after adding one to the number denoted by the array arr.


Expected Time Complexity:  O(N)
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= N <= 105
0 <= arri <= 9
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plus One {
    public static List<Integer> increment(int N, int[] arr) {
        int carry = 1; // Initialize carry to 1 to add 1 to the least significant digit.
        List<Integer> result = new ArrayList<>();

        for (int i = N - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }

        if (carry != 0) {
            result.add(carry); // If there's a carry left, add it as a new most significant digit.
        }

        List<Integer> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            List<Integer> result = increment(N, arr);

            for (int digit : result) {
                System.out.print(digit + " ");
            }
            System.out.println();
        }
    }
}
