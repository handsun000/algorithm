package programmers.level2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }
    public static int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        int number = 1;
        Stack<Integer> st = new Stack<>();
        while (true) {
            if (number != order[idx]) {
                st.push(number);
            }
            else {
                answer ++;
                idx ++;
                while(!st.isEmpty()) {
                    if (st.peek() == order[idx]) {
                        st.pop();
                        answer++;
                        if (idx < order.length-1) idx ++;
                    }
                    else break;
                }
            }
            if (order[idx] < number) break;
            number++;
        }
        return answer;
    }
}
