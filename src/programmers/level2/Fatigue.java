package programmers.level2;

public class Fatigue {
    public static void main(String[] args) {

        int[][] number = {{80,20}, {50,40}, {30,10}};

        System.out.println(solution(80,number));

    }
    public static int answer = 0;
    public static boolean[] visit;

    public static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    private static void dfs(int index, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(index+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, index);
    }
}
