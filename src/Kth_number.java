import java.util.Arrays;

public class Kth_number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int first = 0;
        int second = 1;
        int third = 2;
        int a = 0;
        int b = 0;
        int c = 0;

        while (c < commands.length) {
            if (commands[c][first] > 0 && commands[c][second] > 0 && commands[c][first] > 0) {
                int[] arr = new int[commands[c][second] - commands[c][first] + 1];
                for (int i = commands[c][first] - 1; i < commands[c][second]; i++) {
                    arr[a] = array[i];
                    a++;
                }
                Arrays.sort(arr);
                answer[b] = arr[commands[c][third] - 1];
            }
            b++;
            c++;
            a = 0;
        }

        return answer;
    }
}
