public class fibonachii {
    // public static int fib(int n) {
    // if (n <= 1) { // recursion Time- O(2^n), space - O(n)
    // return n;
    // }
    // return fib(n - 1) + fib(n - 2);

    // }

    // DP
    // Tabulation
    public static int fibT(int n) {
        int dp[] = new int[n + 1]; // Time = O(n) , space = O(n)
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    // space optimization Time -> O(n), Space-> O(1)
    public static int fib(int n) {
        int prev = 0;
        int prev2 = 1;
        for (int i = 2; i <= n + 1; i++) {
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;

    }

    public static void main(String args[]) {
        int n = 6;
        System.out.println(fib(n));

    }
}