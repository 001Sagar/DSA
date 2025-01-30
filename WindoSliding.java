import java.util.HashMap;
import java.util.HashSet;

public class WindoSliding {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0, maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }

    public static int longestOnes(int[] nums, int k) {
        int zero = 0, maxlen = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
            while (zero > k) {
                if (nums[left] == 0)
                    zero--;
                left++;
            }
            maxlen = Math.max(maxlen, i - left + 1);
        }

        return maxlen;
    }

    public int totalFruit(int[] fruits) {

        int left = 0, maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }

            maxlen = Math.max(maxlen, i - left + 1);
        }
        return maxlen;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return numSubarraysWithSumhelper(nums, goal) - numSubarraysWithSumhelper(nums, goal - 1);
    }

    public int numSubarraysWithSumhelper(int[] nums, int target) {

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return numberOfSubarrayshelper(nums, k) - numberOfSubarrayshelper(nums, k - 1);
    }

    public int numberOfSubarrayshelper(int[] nums, int target) {

        int sum = 0, count = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right] % 2;

            while (sum > target && left <= right) {
                sum -= nums[left++] % 2;
            }

            count = count + right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = new int[26];

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
