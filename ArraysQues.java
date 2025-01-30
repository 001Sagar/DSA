import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArraysQues {

    public static void setzero(int[][] nums) {

        int r = nums.length, c = nums[0].length;
        int[] rowarr = new int[r];
        int[] colarr = new int[c];

        // Set to the zero
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (nums[i][j] == 0) {
                    rowarr[i] = 0;
                    colarr[j] = 0;
                }
            }
        }

        // Set to the zero
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rowarr[i] == 0 || colarr[j] == 0) {
                    nums[i][j] = 0;
                }
            }

        }
    }

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2, j = nums.length - 1;

        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i > 0) {
            while (j > 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }

        rev(nums, i + 1, j);

    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void rev(int[] nums, int start, int end) {

        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static int maxSubArray(int[] nums) {

        int sum = nums[0], currsum = 0;

        for (int i : nums) {

            currsum += i;

            sum = Math.max(sum, currsum);

            currsum = currsum < 0 ? 0 : currsum;
        }

        return sum;
    }

    public static void sortColors(int[] nums) {

        int zero = 0, one = 0, two = 0;

        for (int i : nums) {
            if (i == 0)
                zero++;
            if (i == 1)
                one++;
        }

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }

        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }

        for (int i = zero + one; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public static int maxProfit(int[] prices) {

        int profit = 0, buy = prices[0];

        for (int i : prices) {

            if (i - buy > profit) {
                profit = i - buy;
            }

            if (i < buy) {
                buy = i;
            }

        }

        return profit;
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Transpose the Matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse the Each Column of Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l1 = m - 1;
        int l2 = n - 1;
        int k = m + n - 1;

        while (l2 >= 0) {
            if (l1 >= 0 && nums1[l1] > nums2[l2]) {
                nums1[k--] = nums1[l1--];

            } else {
                nums1[k--] = nums2[l2--];
            }
        }

    }

    public static int findDuplicate(int[] nums) {

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i))
                return i;

            map.put(i, true);
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length, c = matrix[0].length;

        int s = 0, e = r * c - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int midval = matrix[mid / c][mid % c];

            if (target == midval) {
                return true;
            } else if (target < midval) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return false;
    }

    public int majorityElement(int[] nums) {

        int n = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int uniquePaths(int m, int n) {

        // Create a DP Array
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }

            int temp = target - nums[i];
            map.put(temp, i);
        }
        return null;
    }

    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int curr = 0, max = 0;
        for (int i = 1; i < nums.length; i++) {

            // Skip Duplicate Elements
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0, maxlen = 0;

        for (int i = 0; i < s.length(); i++) {

            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }

            maxlen = Math.max(maxlen, i - left + 1);
        }

        return maxlen;

    }

    public static int trap(int[] height) {

        int left = 0, right = height[height.length - 1], water = 0, maxleft = height[left], maxright = height[right];

        while (left < right) {

            if (height[left] < height[right]) {
                left++;
                maxleft = Math.max(maxleft, height[left]);
                water = water + maxleft - height[left];
            } else {
                right--;
                maxright = Math.max(maxright, height[right]);
                water = water + maxright - height[right];
            }

        }
        return water;
    }

    public static void pushzero(int[] arr) {
        int count = 0, len = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        for (int i = count; i < len; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}