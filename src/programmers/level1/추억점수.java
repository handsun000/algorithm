package programmers.level1;

public class 추억점수 {
    public static void main(String[] args) {

    }
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (name[k].equals(photo[i][j])){
                        sum += yearning[k];
                        break;
                    }
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
