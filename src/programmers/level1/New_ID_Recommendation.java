package programmers.level1;

public class New_ID_Recommendation {
    public String solution(String new_id) {
        String answer = "";

        new_id = new_id.toLowerCase();

        for(int i = 0; i < new_id.length(); i++) {
            if((new_id.charAt(i) >= 97 && new_id.charAt(i) <= 122) || (new_id.charAt(i) >= 48 && new_id.charAt(i) <= 57) ||
                    new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
                answer += Character.toString(new_id.charAt(i));
            }
        }

        while(true) {
            answer = answer.replace("..", ".");
            if(!answer.contains("..")) break;
        }

        if(!answer.isEmpty()) {
            if(answer.charAt(0) == '.') answer = answer.substring(1);
            else if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        }

        if(!answer.isEmpty()) {
            if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
            else if(answer.charAt(0) == '.') answer = answer.substring(1);
        }

        if(answer.isEmpty()) answer = "a";

        int count = answer.length();

        if(answer.length() >= 16) {
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.') {
                answer = answer.substring(0, answer.length()-1);
            }
        }
        else if(answer.length() <= 2) {
            for(int i = 0; i < 3-count; i++) {
                answer += Character.toString(answer.charAt(answer.length()-1));
            }
        }


        return answer;
    }
}
