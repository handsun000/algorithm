package programmers.level1;

import java.util.Arrays;

public class Report_Result {
    public static void main(String[] args) {
     String[] id_list = {"muzi", "frodo", "apeach", "neo"};
     String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
     int k = 2;

        System.out.println(solution(id_list, report, k));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String[] reporter = new String[id_list.length];
        int[] call = new int[id_list.length];
        int count = 0;


        for(int i = 0; i<reporter.length; i++){
            reporter[i] = "";
        }

        for (int i = 0; i<report.length; i++){
            String[] s = report[i].split("\\s+");
            for(int j = 0; j<id_list.length; j++){
                if(id_list[j].equals(s[0])) reporter[j] += s[1]+" ";
            }
        }
        for (int i = 0; i<id_list.length; i++){
            for(int j = 0; j<id_list.length; j++){
                if(reporter[j].contains(id_list[i])) {
                    call[j] = 1;
                }
            }
            for(int l = 0; l<call.length; l++) count += call[l];
            if(count>=k) {
                for(int j = 0; j<id_list.length; j++) {
                    if(call[j] == 1) {
                        answer[j]++;
                        call[j] = 0;
                    }
                }
            }
            else {
                for(int j = 0; j<id_list.length; j++) {
                    call[j] = 0;
                }
            }
            count = 0;
        }
        for (int i = 0; i < id_list.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;

    }
}
