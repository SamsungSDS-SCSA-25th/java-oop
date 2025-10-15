package basic;

public class Array {

    public static void main(String[] args) {

        int[] index = new int[11];

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int num : arr) {
            index[num]++;
        }

        for (int num : arr) {
            System.out.println(num + "의 출현횟수 " + index[num] + "회");
        }

        /**
         *  int[] arr = {1,2,3,4,5};
         *         System.out.println(arr[0]);
         * //        System.out.println(arr[6]);
         *
         * //        int[] fibonacci = {1, 1, 2, 3, 5, 8, 13, 21};
         *         int[] fibonacci = new int[10];
         *         fibonacci[0] = 1;
         *         fibonacci[1] = 1;
         *         for (int i = 2; i < fibonacci.length; i++) {
         *             fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
         *         }
         *
         *         for (int fibo: fibonacci) {
         *             System.out.println(fibo);
         *         }
         *
         *         // Arrays 클래스 기억!
         *         System.out.println(Arrays.toString(fibonacci));
         */

    }
}
