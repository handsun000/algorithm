package programmers.level1;
import java.util.Stack;

public class Crane_Puppet_Game {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> st = new Stack<>();

            st.push(-1);

            for(int i = 0; i<moves.length; i++) {
                for(int j = 0; j<board[0].length; j++) {
                    if(board[j][moves[i]-1] == 0) continue;
                    else {
                        int pk = st.peek();
                        st.push(board[j][moves[i]-1]);

                        if (board[j][moves[i]-1] == pk) {
                            st.pop();
                            st.pop();
                            answer += 2;
                        }
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }
            }

            return answer;

    }
}
