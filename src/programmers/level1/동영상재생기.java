package programmers.level1;

public class 동영상재생기 {
    public static void main(String[] args) {
        String[] command = {"next"};

        System.out.println(solution("30:35","30:30","01:00"	,"02:00", command));
    }
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_mm = Integer.parseInt(video_len.split(":")[0]);
        int video_ss = Integer.parseInt(video_len.split(":")[1]);

        for (String command : commands) {
            if (Integer.parseInt(op_start.replace(":","")) <= Integer.parseInt(pos.replace(":","")) &&
                    Integer.parseInt(op_end.replace(":","")) > Integer.parseInt(pos.replace(":",""))) {
                pos = op_end;
            }
            int mm = Integer.parseInt(pos.split(":")[0]);
            int ss = Integer.parseInt(pos.split(":")[1]);
            switch (command) {
                case "next" -> {
                    ss += 10;
                    if (ss >=60) {
                        mm += 1;
                        ss -= 60;
                    }
                }
                case "prev" ->{
                    ss -= 10;
                    if (ss < 0) {
                        if (mm <= 0) {
                            mm = 0;
                            ss = 0;
                        }
                        else {
                            mm -= 1;
                            ss += 60;
                        }
                    }
                }
            }

            pos = (mm < 10)? "0"+mm : String.valueOf(mm);
            pos += ":";
            pos += (ss < 10)? "0"+ss : String.valueOf(ss);

            if (Integer.parseInt(video_len.replace(":","")) < Integer.parseInt(pos.replace(":",""))) {
                pos = video_len;
            }
        }

        if (Integer.parseInt(op_start.replace(":","")) <= Integer.parseInt(pos.replace(":","")) &&
                Integer.parseInt(op_end.replace(":","")) > Integer.parseInt(pos.replace(":",""))) {
            pos = op_end;
        }

        return pos;
    }
}
