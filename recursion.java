import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class recursion {

    public static ArrayList<String> subsequences(String s) {
        // Base Case of the code
        if (s.length() == 0) {
            ArrayList<String> output = new ArrayList<>();
            output.add("");
            return output;
        }

        // Recursivelly call the function
        ArrayList<String> smalloutput = subsequences(s.substring(1));

        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < smalloutput.size(); i++) {
            output.add(smalloutput.get(i));
        }

        for (int i = 0; i < smalloutput.size(); i++) {
            output.add(s.charAt(0) + smalloutput.get(i));
        }

        return output;
    }

    public static void printlist(ArrayList<String> list) {

        for (String str : list) {
            System.out.println(str);
        }
    }

    // Function to return the minimum element of the Array
    public static int findMin(int[] nums, int index) {
        // check Base Case
        if (nums.length == index) {
            return Integer.MAX_VALUE;
        }

        int smalloutput = findMin(nums, index + 1);

        return nums[index] < smalloutput ? nums[index] : smalloutput;
    }

    public static List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        Collections.sort(res);
        res.remove(0);
        return res;
    }

    public static void helper(String s, int index, String curr, List<String> res) {

        // Base Case
        if (s.length() == index) {
            res.add(curr);
            return;
        }

        // include
        helper(s, index + 1, s.charAt(index) + curr, res);

        // Exclude
        helper(s, index + 1, curr, res);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the String");
        // String str = sc.next();

        // ArrayList<String> list = subsequences(str);

        // Print the String
        // printlist(list);

        int[] nums = { 9, 7, 6, 3, 1, 3 };
        System.out.println(findMin(nums, 0));
    }
}
