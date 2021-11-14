package programmers.level1;

import java.util.*;

public class Mock_Exam {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] result = new int[3];
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) count++;
        }

        result[0] = count;
        count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == two[i%8]) count++;
        }

        result[1] = count;
        count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == three[i%10]) count++;
        }

        result[2] = count;

        int max = result[0];

        for(int i = 0; i < result.length; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }

        for(int i = 0; i < result.length; i++) {
            if(max <= result[i]) {
                list.add(i+1);
            }
        }

        int[] number = new int[list.size()];

        for(int i = 0; i < number.length; i++) {
            number[i] = list.get(i);
        }

        return number;
    }
}