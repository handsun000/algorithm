package programmers.level1;

import java.util.Stack;

class Crane_Puppet_Game {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {1, 2, 3}};
        int[] moves = {1, 2, 3};

        int solution = solution(board, moves);

        System.out.println("solution = " + solution);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        st.push(-1);

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][moves[i] - 1] == 0) continue;
                else {
                    int pk = st.peek();
                    st.push(board[j][moves[i] - 1]);

                    if (board[j][moves[i] - 1] == pk) {
                        st.pop();
                        st.pop();
                        answer += 2;
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }


        return answer;

    }
}
