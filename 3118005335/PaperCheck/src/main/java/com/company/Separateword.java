package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Separateword {
    private static final String html_seperator;
    private static final String sentence_seperator;

    static {
        html_seperator = "<br>";
        sentence_seperator = "[,.;!:，。；：]";
    }

    public static String[] split(String src)
    {
        List<String> result=new ArrayList<>();
        String []htmls=src.split(html_seperator);
        for (String s:htmls) {
            boolean b = Collections.addAll(result, s.split(sentence_seperator));
        }
        String []results=new String[result.size()];
        result.toArray(results);
        return results;
    }
    //清晰字符串除杂消除干扰
    static String[] clean(String []src)
    {
        for (int i=0;i<src.length;i++)
            src[i]=clean(src[i]);
        return src;
    }
    //清除非数字、字母、中文
    public static String clean(String src)
    {
        return src.replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]","");
    }
    public static String ReadtoString(String filepath){
        String str=" ";
        File file = new File(filepath);
        try {
            FileInputStream input=new FileInputStream(filepath);
            int size =input.available();
            byte[] buffer=new byte[size];
            input.read(buffer);
            input.close();
            str=new String(buffer,"UTF-8");
        }catch(IOException e){
            e.printStackTrace();
        }
        if (str.length() == 0){
            throw new EmptyFileException("这个文件是空文件");
        }
        return str;
    }

}