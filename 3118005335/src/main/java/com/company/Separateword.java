package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Separateword {
    private static final String html_seperator="<br>";
    private static final String sentence_seperator="[,.;!:，。；：]";
    public static String[] split(String src)
    {
        List<String> result=new ArrayList<>();
        String []htmls=src.split(html_seperator);
        for (String s:htmls)
            Collections.addAll(result, s.split(sentence_seperator));
        String []results=new String[result.size()];
        result.toArray(results);
        return results;
    }

    public static String ReadtoString(String filepath){
        String str=" ";
        try {
            FileInputStream input=new FileInputStream(filepath);
            int size =input.available();
            byte[] buffer=new byte[size];
            input.read(buffer);
            input.close();
            str=new String(buffer, StandardCharsets.UTF_8);
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
