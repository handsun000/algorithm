package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class CutN2Array {
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        System.out.println(Arrays.toString(solution(n, left, right)));
    }
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int y = (int)(left / n + 1);
            int x = (int)(left % n + 1);
            left++;
            answer[i] = Math.max(y, x);
        }

        return answer;
    }
}
