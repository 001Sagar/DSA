public class array {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
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

        int[] arr = { 9, 0, 1, 0, 2, 4, 90 };

        pushzero(arr);
        print(arr);
    }
}
