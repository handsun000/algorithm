import java.util.*;

class Unfinished_player {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        LinkedList array = new LinkedList();
        for (int i = 0; i < participant.length; i++) {
            array.add(participant[i]);
        }
        for (int i = 0; i < completion.length; i++) {
            if (array.contains(completion[i]))
                array.remove(completion[i]);
        }
        answer = (String) array.get(0);

        return answer;
    }
}