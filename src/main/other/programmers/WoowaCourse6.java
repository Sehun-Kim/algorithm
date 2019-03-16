package main.other.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WoowaCourse6 {
    static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);

    public static void main(String[] args) {
        int totalTicket = 2000;
        String[] logs = {"woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };

        String[] result = new String[0];
        try {
            result = solution(totalTicket, logs);
            for (String s : result) {
                System.out.println(s);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    static class Server {
        Date finalTime;
        Date nowRequest;
        int totalTicket;

        public Server(int totalTicket) throws ParseException {
            this.finalTime = format.parse("10:00:00");
            this.nowRequest = format.parse("09:00:00");
            this.totalTicket = totalTicket;
        }

        public void request(Log log) {
            if (this.nowRequest.before(log.requestTime)) {
                if (this.finalTime.after(log.leaveTime)) {
                    this.nowRequest = log.leaveTime;
                } else {
                    log.fail();
                }
            } else {
                log.fail();
            }
        }
    }

    static class Log implements Comparable<Log> {
        String name;
        Date requestTime;
        Date leaveTime;
        int accessTime;

        public Log(String name, String request) {
            this.name = name;
            successTime(request);
            this.accessTime = 60;
        }

        private void successTime(String request) {
            try {
                this.requestTime = format.parse(request);
                this.leaveTime = format.parse(request);
                this.leaveTime.setSeconds(this.leaveTime.getSeconds() + 60);
            } catch (ParseException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public void setLeaveTime(String value) {
            try {
                this.leaveTime = format.parse(value);
                this.accessTime = this.leaveTime.getSeconds() - this.requestTime.getSeconds();
            } catch (ParseException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override
        public int compareTo(Log o) {
            if (this.requestTime.after(o.requestTime))
                return 1;
            if (this.requestTime.before(o.requestTime))
                return -1;
            return 0;
        }


        public void fail() {
            this.accessTime = 0;
        }
    }

    private static String[] solution(int totalTicket, String[] logs) throws ParseException {
        Server server = new Server(totalTicket);
        Map<String, Log> logMap = generateLogMap(logs);
        List<Log> logList = new ArrayList<>();

        for (String s : logMap.keySet()) {
            logList.add(logMap.get(s));
        }

        Collections.sort(logList);

        for (Log log : logList) {
            server.request(log);
        }

        List<Log> result = logList.stream().filter(log -> log.accessTime >= 60).collect(Collectors.toList());
        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).name;
        }

        return answer;
    }

    private static Map<String, Log> generateLogMap(String[] logs) {
        Map<String, Log> logMap = new HashMap<>();
        for (String log : logs) {
            String[] values = log.split(" ");
            if (logMap.containsKey(values[0]))
                logMap.get(values[0]).setLeaveTime(values[2]);
            else
                logMap.put(values[0], new Log(values[0], values[2]));
        }
        return logMap;
    }
}
