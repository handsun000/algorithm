package programmers.level1;

import java.util.*;

public class Press_KeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        String[] lefts = {"1", "4", "7", "10"};
        String[] mid = {"2", "5", "8", "0"};
        String[] rights = {"3", "6", "9", "12"};
        int left = 10;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            } else {
                int lCount = 0;
                int rCount = 0;

                int lIndex = Arrays.asList(lefts).indexOf(String.valueOf(left));
                int rIndex = Arrays.asList(rights).indexOf(String.valueOf(right));
                int mIndex = Arrays.asList(mid).indexOf(String.valueOf(numbers[i]));

                if (lIndex != -1) {
                    lCount++;
                } else {
                    lIndex = Arrays.asList(mid).indexOf(String.valueOf(left));
                }
                if (rIndex != -1) {
                    rCount++;
                } else {
                    rIndex = Arrays.asList(mid).indexOf(String.valueOf(right));
                }

                lCount += Math.max(mIndex, lIndex) - Math.min(mIndex, lIndex);
                rCount += Math.max(mIndex, rIndex) - Math.min(mIndex, rIndex);

                if (Math.abs(lCount) == Math.abs(rCount)) {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];
                    } else {
                        answer += "R";
                        right = numbers[i];
                    }
                } else if (Math.abs(lCount) > Math.abs(rCount)) {
                    answer += "R";
                    right = numbers[i];
                } else if (Math.abs(rCount) > Math.abs(lCount)) {
                    answer += "L";
                    left = numbers[i];
                }
            }
        }


        return answer;
    }
}
