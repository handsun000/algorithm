package programmers.level2;

public class Hopscotch {
    public static void main(String[] args) {
        int[][] land = {{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}};
        System.out.println(solution(land));

    }
    public static int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length+1][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                dp[i][j] = land[i][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][1] += Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] += Math.max(dp[i-1][1], Math.max(dp[i-1][0], dp[i-1][3]));
            dp[i][3] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][0]));
        }

        return Math.max(Math.max(dp[dp.length-1][0],dp[dp.length-1][1]), Math.max(dp[dp.length-1][2],dp[dp.length-1][3]));
    }
}
