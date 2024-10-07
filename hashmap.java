import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class hashmap {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { i, map.get(i) };
            }

            int temp = target - nums[i];
            map.put(nums[i], i);
        }
        return null;
    }

    // Remove Duplicates from Array
    public static ArrayList<Integer> removeduplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            map.put(nums[i], true);

        }
        return list;
    }

    // Function to find the maximum frequency of the number
    public static int maxfrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0, max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }

        return max;
    }

    // Return the Intersesction of Two Arrays
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Push all the Elements of nums1 in set1
        for (int i : nums1) {
            set1.add(i);
        }

        // Push all the Elements of nums2 in Set
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        // Make an Array of Size set2
        int[] nums = new int[set2.size()];
        int count = 0;
        for (int i : set2) {
            nums[count++] = i;
        }

        return nums;
    }

    public boolean isIsomorphic(String s, String t) {
        // Check the langth of both String
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }

            return true;
        }

    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6 };
        System.out.println("The Maximum Frequency of the Array " + maxfrequency(arr));

    }
}
