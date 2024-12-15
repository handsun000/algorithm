package programmers.level2;

public class TWOxN타일링 {
    public static int answer = 0;
    public static void main(String[] args) {
        System.out.println(solution(7));

    }
    public static int solution(int n) {
        int[] lens = {1, 2};
        dfs (lens, 0, n);

        return answer;
    }
    public static void dfs(int[] lens, int sum, int n) {
        if (sum == n) {
            answer++;
            return;
        }
        else if (sum > n) return;

        for (int len : lens) {
            sum += len;
            dfs(lens, sum, n);
            sum -= len;
        }
    }
}
