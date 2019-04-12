package main.other.sixshop;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieTitles {
    public static void main(String[] args) throws IOException {
        String substr = "spiderman";
//        String[] result = getMovieTitles(substr);
//        for (String s : result) {
//            System.out.println(s);
//        }

    }

//    public static String[] getMovieTitles(String substr) {
//        List<String> result = new ArrayList<>();
//        result = getTitles(result, substr);
//
//        return result;
//    }

//    private static List<String> getTitles(List<String> result, String substr) {
//        List<String> titles = getTitles(result, substr);
//        StringBuilder sb= new StringBuilder();
//        sb.append("https://jsonmock.hackerrank.com/api/movies/search/?Title=");
//        sb.append(substr);
//        String s = sb.toString();
//        URL url = new URL(s);
//        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
//        connect.setRequestMethod("GET");
//        int resCode = connect.getResponseCode();
//
//        if(resCode == 200){
//            BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
//            String line;
//
//            // 조건에 맞는 처리를 하고, 페이지가 더 있으면 getTitles 재귀 호출
//        }
//
//        return titles.addAll(result);
//    }

}
