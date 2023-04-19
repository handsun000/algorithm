package programmers.level1;

public class Food_Fight_Competition {
    public static void main(String[] args) {

        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        String answer = "";

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++)
                answer += String.valueOf(i);
        }

        answer += "0";

        for (int i = answer.length() - 2; i >= 0; i--)
            answer += String.valueOf(answer.charAt(i));

        return answer;
    }
}
