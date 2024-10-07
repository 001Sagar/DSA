import java.util.*;

public class backtracking {

    public static List<String> subsequences(String str) {

        List<String> result = new ArrayList<>();
        subsequenceshelper(result, "", str, 0);
        return result;
    }

    public static void subsequenceshelper(List<String> res, String curr, String s, int index) {
        // Base Case
        if (index == s.length()) {
            res.add(curr);
            return;
        }

        // Include
        subsequenceshelper(res, curr + s.charAt(index), s, index + 1);

        // Exlude
        subsequenceshelper(res, curr, s, index + 1);
    }

    public static void printStringList(List<String> list) {

        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    // Function to Print the SubSet of Array
    public static List<List<Integer>> subset(int[] nums) {

        // Make a ArrayList
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        subsethelper(res, curr, nums, 0);

        return res;
    }

    public static void subsethelper(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {

        // Check Base Case
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Include
        curr.add(nums[index]);
        subsethelper(res, curr, nums, index + 1);

        // BackTrack
        curr.remove(curr.size() - 1);

        // Exclude
        subsethelper(res, curr, nums, index + 1);
    }

    // Print the ArrayList
    public static void printArrayList(List<List<Integer>> list) {

        for (List<Integer> l : list) {
            System.out.print(l + " ");
        }
    }

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permutationHelper(res, curr, nums);
        return res;
    }

    public static void permutationHelper(List<List<Integer>> res, List<Integer> curr, int[] nums) {
        // Base Case
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i]))
                continue;
            curr.add(nums[i]);
            permutationHelper(res, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        letterCombinationsbacktrack(res, "", digits, 0);

        return res;
    }

    public static void letterCombinationsbacktrack(List<String> res, String curr, String s, int index) {
        if (curr.length() == s.length()) {
            res.add(curr);
            return;
        }

        String str = letterCombinationshelper(s.charAt(index));

        for (int i = 0; i < str.length(); i++) {
            // curr = curr + s.charAt(i);
            letterCombinationsbacktrack(res, curr + str.charAt(i), s, index + 1);
        }
    }

    public static String letterCombinationshelper(Character digit) {

        if (digit == '2')
            return "abc";
        if (digit == '3')
            return "def";
        if (digit == '4')
            return "ghi";
        if (digit == '5')
            return "jkl";
        if (digit == '6')
            return "mno";
        if (digit == '7')
            return "pqrs";
        if (digit == '8')
            return "tuv";
        if (digit == '9')
            return "wxyz";

        return "";
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generateParenthesishelper(res, "", 0, 0, n);

        return res;
    }

    public static void generateParenthesishelper(List<String> res, String curr, int left, int right, int n) {

        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        if (left < n) {
            generateParenthesishelper(res, curr + '(', left + 1, right, n);
        }

        if (right < left) {
            generateParenthesishelper(res, curr + ')', left, right + 1, n);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        combinehelper(res, curr, n, k, 1);

        return res;
    }

    public static void combinehelper(List<List<Integer>> res, List<Integer> curr, int n, int k, int index) {

        // Base Case
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            combinehelper(res, curr, n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> duplicatesubset(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        duplicatesubsethelper(res, curr, nums, 0);

        return res;
    }

    public static void duplicatesubsethelper(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {

        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            curr.add(nums[i]);
            duplicatesubsethelper(res, curr, nums, index + 1);
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Please Enter the String");
        // String str = sc.nextLine();
        // List<String> result = subsequences(str);
        // System.out.println("The Length of the String " + result.size());
        // printStringList(result);

        // int[] nums = { 1, 2, 3, 4 };
        // List<List<Integer>> res = subset(nums);
        // printArrayList(res);

        // List<List<Integer>> list = permutation(nums);
        // printArrayList(list);

        // List<String> str = letterCombinations("23");
        // printStringList(str);

        // List<List<Integer>> res = combine(4, 2);
        // printArrayList(res);

        // List<List<Integer>> resper = permutation(nums);
        // System.out.println(resper.size());
        // printArrayList(resper);

        // int[] nums = { 1, 2, 3 };

        // List<List<Integer>> res = duplicatesubset(nums);

        // printArrayList(res);

        System.out.println("Hello");

    }

}