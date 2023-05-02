package programmers.level1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonalInformationCollectionValidityPeriod {
    public static void main(String[] args) {
        String today = "2021.12.08";
        String[] terms = {"A 18"};
        String[] privacies = {"2020.06.08 A"};
        System.out.println(solution(today, terms, privacies));

    }

    public static ArrayList solution(String today, String[] terms, String[] privacies) {
        ArrayList arr = new ArrayList();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int term = Integer.parseInt(map.get(privacy[1]));
            String[] date = privacy[0].split("\\.");
            String year = date[0];
            String month = date[1];
            String day = date[2];
            int m = Integer.parseInt(month) + term;
            int d = Integer.parseInt(day) - 1;

            if (m > 12) {
                year = String.valueOf(Integer.parseInt(year) + m/12);
                m = m%12;
                if (m == 0) {
                    m = 12;
                    year = String.valueOf(Integer.parseInt(year)-1);
                }
                if (date[2].equals("01")) {
                    m = m - 1;
                    d = 28;
                }
            }

            month = (m <= 9) ? "0" + m : String.valueOf(m);
            day = (d <= 9)? "0"+d : String.valueOf(d);
            String df = year + month + day;
            today = today.replaceAll("\\.", "");
            System.out.println(df +", " + today);
            if (Integer.parseInt(df) < Integer.parseInt(today)) arr.add(i+1);
        }

        return arr;
    }
}
