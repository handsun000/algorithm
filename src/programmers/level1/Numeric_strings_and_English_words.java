package programmers.level1;

public class Numeric_strings_and_English_words {
    public int solution(String s) {
        int answer = 0;
        String[] str = new String[s.length()];
        StringBuilder number = new StringBuilder();
        StringBuilder st = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            str[i] = Character.toString(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if ('0' <= str[i].charAt(0) && str[i].charAt(0) <= '9') {
                number.append(str[i]);
            } else {
                st.append(str[i]);
                if (st.toString().equals("zero")) {
                    number.append("0");
                    st = new StringBuilder();
                } else if (st.toString().equals("one")) {
                    number.append("1");
                    st = new StringBuilder();
                } else if (st.toString().equals("two")) {
                    number.append("2");
                    st = new StringBuilder();
                } else if (st.toString().equals("three")) {
                    number.append("3");
                    st = new StringBuilder();
                } else if (st.toString().equals("four")) {
                    number.append("4");
                    st = new StringBuilder();
                } else if (st.toString().equals("five")) {
                    number.append("5");
                    st = new StringBuilder();
                } else if (st.toString().equals("six")) {
                    number.append("6");
                    st = new StringBuilder();
                } else if (st.toString().equals("seven")) {
                    number.append("7");
                    st = new StringBuilder();
                } else if (st.toString().equals("eight")) {
                    number.append("8");
                    st = new StringBuilder();
                } else if (st.toString().equals("nine")) {
                    number.append("9");
                    st = new StringBuilder();
                }
            }
        }
        answer = Integer.parseInt(number.toString());
        return answer;
    }
}
