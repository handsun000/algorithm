package programmers.level1;

public class Add_Missing_Numbers {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum1 = 45;
        int sum2 = 0;
        for(int i = 0; i<numbers.length; i++) {
            for(int j = 0; j<10; j++) {
                if(numbers[i] == j) {
                    sum2 += j;
                }
            }
        }
        answer = sum1 - sum2;
        return answer;
    }
}
