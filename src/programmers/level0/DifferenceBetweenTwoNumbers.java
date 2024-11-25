package programmers.level0;

import java.util.Arrays;
import java.util.OptionalInt;

public class DifferenceBetweenTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num1 = 2;
        int num2 = 3;

        System.out.println(solution.solution(num1, num2));
    }
}

class Solution {
    public int solution(int num1, int num2) {

        return num1 - num2;
    }
}