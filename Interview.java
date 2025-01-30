public class Interview {

    public static void sort(int[] nums) {

        int zero = 0;

        for (int i : nums) {
            if (i == 0)
                zero++;
        }

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }

        for (int i = zero; i < nums.length; i++) {
            nums[i] = 1;
        }

    }

    public static void print(int[] nums) {

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int[] evenOdd(int[] nums) {

        int s = 0, e = nums.length - 1, c = 0;

        int[] temp = new int[nums.length];

        while (s <= e) {
            if (nums[c] % 2 == 0) {
                temp[s++] = nums[c++];
            } else {
                temp[e--] = nums[c++];
            }
        }
        return temp;
    }

    public static int seclarg(int[] nums) {

        int f = Integer.MIN_VALUE, s = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > f) {
                s = f;
                f = i;
            } else if (i <= f && i > s) {
                s = i;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        // System.out.println(seclarg(nums));

        int[] ans = evenOdd(nums);

        print(ans);
    }
}