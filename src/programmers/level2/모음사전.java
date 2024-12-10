package programmers.level2;

public class 모음사전 {
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static int answer;
    static int count;

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }

    public static int solution(String word) {
        StringBuilder result = new StringBuilder();
        answer = 0;

        bfs(word, result);

        return answer;
    }

    private static void bfs(String word, StringBuilder result) {
        if (result.toString().equals(word)) {
            answer = count;
            return;
        }
        if (result.length() == 5) return;

        for (String a : alpha) {
            result.append(a);
            count++;
            bfs(word, result);
            if (answer>0) break;
            result.setLength(result.length() - 1);
        }
    }
}
