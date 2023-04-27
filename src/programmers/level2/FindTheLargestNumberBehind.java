package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindTheLargestNumberBehind {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack();

        int[] answer = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
