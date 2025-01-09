package ro.alexil.algorithms.fastslow.a01;
/*

 */
public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        var slow = n;
        var fast = nextNumber(nextNumber(n));
        while(fast > 1 && fast != slow) {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
        }
        return fast == 1;
    }


    public static int nextNumber(int n) {
        if (n > 9) {
            var modulo = n % 10;
            return modulo * modulo + nextNumber(n / 10);
        }
        return n * n;
    }

    public static void main(String[] arg) {
        int[] testCase = {
                1
        };

        System.out.println(nextNumber(77));

        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case # " + (k + 1));
            System.out.println(testCase[k] + " is happy number : " + isHappyNumber(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
