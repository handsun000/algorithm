package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 지폐접기 {
    public static void main(String[] args) {

    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            if (bill[0] <= wallet[0]) {
                if (bill[1] <= wallet[1]) return answer;
            }
            else if (bill[0] <= wallet[1]) {
                if (bill[1] <= wallet[0]) return answer;
            }

            answer++;
            if (bill[0] < bill[1]) bill[1] /= 2;
            else bill[0] /= 2;
        }
    }
}
