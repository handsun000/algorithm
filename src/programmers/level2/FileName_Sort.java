package programmers.level2;

import java.util.*;

public class FileName_Sort {
    public static void main(String[] args) {
        String[] files = {"F-14 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-5 Tomcat"};
        solution(files);
        solution2(files);

    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();
                if (head1.equals(head2)) {
                    String numTail1 = o1.substring(head1.length());
                    String numTail2 = o2.substring(head2.length());
                    return num(numTail1) - num(numTail2);
                }
                else {
                    return head1.compareTo(head2);
                }
            }
        });
        System.out.println(Arrays.toString(files));
        return files;
    }

    private static int num(String numTail1) {
        String num = "";
        for (int i = 0; i < numTail1.length(); i++) {
            if (Character.isDigit(numTail1.charAt(i)) && num.length() < 5) {
                num += numTail1.charAt(i);
            }
            else break;
        }
        return Integer.parseInt(num);
    }

    public static String[] solution2(String[] files) {
        String[] answer = new String[files.length];
        String[][] answer2 = new String[files.length][3];

        for(int i = 0; i < files.length; i++){
            String s = files[i];

            int startNumberIdx = -1;
            boolean first = true;
            int endNumberIdx = -1;
            int size = 0;

            for(int j = 0; j < s.length(); j++){
                if(Character.isDigit(s.charAt(j))){
                    if(first) {
                        startNumberIdx = j;
                        first = false;
                    }
                    size++;
                }else{
                    if(!first) break;
                }
            }

            endNumberIdx = startNumberIdx + size - 1;

            String head = s.substring(0, startNumberIdx);
            String number = s.substring(startNumberIdx, endNumberIdx+1);
            String tail = s.substring(endNumberIdx+1);

            answer2[i][0] = head;
            answer2[i][1] = number;
            answer2[i][2] = tail;
        }
        Arrays.sort(files);

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(answer2[i]));

        }

        System.out.println("========================================================");

        Arrays.sort(answer2, (o1, o2) -> {
            if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0){
                return 1;
            }else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0){
                return -1;
            }else{
                if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
                    return 1;
                }else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
//
//        for(int i = 0; i < answer.length; i++){
//            answer[i] = answer2[i][0] + answer2[i][1] + answer2[i][2];
//        }
//        for (int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(answer2[i]));
//
//        }
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
