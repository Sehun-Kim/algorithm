package other.woowa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Num2 {
    public static void main(String[] args) throws ParseException {
        //
        /*
         * 이름, 확장자, 도시, 날짜
         * photo.jpg, seoul, 2018-11-10 08:00:05
         *
         * 도시 별로 묶어, 시간이 오래된 순으로 1번부터 인덱싱을 붙인다
         * 만약, 하나의 도시에 속한 값이 10개 이상일 경우 01, 02, ... ,10로 인덱스를 붙인다
         * 10개 미만일 경우 1, 2, ... ,9
         * 데이터는 100개를 초과하지 않는다
         */

        String s = "photo.jpg, seoul, 2018-11-10 08:00:05\n" +
                "wow.png, newyork, 2018-10-15 12:15:05\n" +
                "a.jpg, seoul, 2018-10-07 12:15:05\n" +
                "b.jpg, paris, 2016-10-09 17:15:44\n" +
                "c.jpg, paris, 2016-07-13 19:15:22\n" +
                "d.jpg, seoul, 2018-06-14 17:18:22\n" +
                "e.jpg, seoul, 2018-08-22 13:11:13\n" +
                "1111.jpg, paris, 2018-10-14 12:15:05\n" +
                "f.jpg, seoul, 2018-09-11 14:02:12\n" +
                "g.png, seoul, 2018-05-11 09:02:23\n" +
                "h.jpeg, seoul, 2018-02-11 07:02:44\n" +
                "i.jpg, seoul, 2017-10-14 12:17:07\n" +
                "j.jpg, seoul, 2017-10-14 12:16:02\n" +
                "k.jpg, seoul, 2017-10-14 12:15:05";

        System.out.println(solution(s));
    }

    private static String solution(String s) throws ParseException {
        String[] values = s.split("\\n");
        List<Photo> result = new ArrayList<>();

        for (String value : values) {
            String[] split = value.split(",");
            result.add(new Photo(split[0], split[1].trim(), split[2].trim()));
        }


        // 같은 도시끼리 묶어야 함
        HashMap<String, List<Photo>> indexCity = new HashMap<>();
        for (Photo photo : result) {
            String cityName = photo.getCityName();
            if (indexCity.containsKey(cityName)) {
                indexCity.get(cityName).add(photo);
            } else {
                List<Photo> cities = new ArrayList<>();
                cities.add(photo);
                indexCity.put(cityName, cities);
            }
        }

        // 도시별 정렬 후 인덱싱
        for (String cityName : indexCity.keySet()) {
            List<Photo> cities = indexCity.get(cityName);
            Collections.sort(cities);

            for (int i = 0; i < cities.size(); i++) {
                if (i < 9 && cities.size() >= 10) {
                    cities.get(i).setIndex("0" + (i + 1));
                } else {
                    cities.get(i).setIndex((i + 1) + "");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Photo photo : result) {
            sb.append(photo.toString() + "\n");
        }

        return sb.toString();
    }

}

class Photo implements Comparable<Photo> {
    private String extension;
    private String cityName;
    private Date date;

    private String index;

    public Photo(String extension, String cityName, String date) throws ParseException {
        this.extension = extension.split("\\.")[1];
        this.cityName = Character.toUpperCase(cityName.charAt(0)) + cityName.substring(1);
        this.date = stringToDate(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dt.parse(date);
    }

    public String getCityName() {
        return cityName;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public int compareTo(Photo o) {
        return this.date.compareTo(o.date);
    }

    @Override
    public String toString() {
        return this.cityName + this.index + "." + this.extension;
    }
}
