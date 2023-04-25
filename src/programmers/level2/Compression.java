package programmers.level2;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Compression {
    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
    }

    public static ArrayList solution(String msg) {
        ArrayList<Integer> answer = new ArrayList();
        ArrayList<String> list = init();

        for (int i = 0; i < msg.length(); i++) {
            String w = String.valueOf(msg.charAt(i));

            if (i == msg.length()-1) {
                answer.add(list.indexOf(w));
                break;
            }

            String c = String.valueOf(msg.charAt(i+1));

            while (list.contains(w + c)) {
                w = w+c;
                i++;

                if (i == msg.length() - 1 || c.equals("")) {
                    c = "";
                    break;
                }

                c = String.valueOf(msg.charAt(i + 1));
            }

            if (!list.contains(w + c)) {
                list.add(w+c);
            }

            int x = list.indexOf(w);
            if (x != -1) {
                answer.add(x);
            }

            if (i == msg.length() - 1 && !c.equals("")) {
                answer.add(answer.indexOf(c));
            }
        }

        return answer;
    }

    private static ArrayList<String> init() {

        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for (int i = 65; i <= 90; i++) {
            list.add(String.valueOf((char) i));
        }

        return list;

    }
}
