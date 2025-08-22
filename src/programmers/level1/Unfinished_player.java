package programmers.level1;

import java.util.*;

public class Unfinished_player {
    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = "";

        for (int i = 0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        if (answer.equals("")) answer = participant[participant.length-1];

        return answer;
    }
}