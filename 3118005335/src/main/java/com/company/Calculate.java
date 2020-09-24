package com.company;

public class Calculate {
    public static float detect(String des,String src)
    {
        float resultFloat=0.00f;
        //分语义行切割作业内容
        String[] desArray =Separateword.split(des);
        String[] srcArray =Separateword.split(src);
        //对作业内容中非自然语言进行清洗除杂
        // desArray=clean(desArray);
        // srcArray=clean(srcArray);
        for (String s:desArray)
            resultFloat = resultFloat + checkSingleLineWithSrcArray(s, srcArray);
        resultFloat/=desArray.length;
        return resultFloat;
    }
    //将一行和所有可能行进行比较得出最大的相似率
    public static float checkSingleLineWithSrcArray(String line, String []srcArray)
    {
        float result  =0.0f;
        for (String s:srcArray) {
            //基于找公共子串进行相似度计算
            float temp1 = checkSingleLineWithSingleLine(line, s);
            //基于找公共字符数进行相似度计算
            float temp2 = checkDuplicationWithMatrix(line, s);
            if (temp2>result||temp1>result)
                result =(temp1+temp2)/2;
        }
        return result;
    }
    //将一行和一行比较，求出公共子序列，以此得出两字符串的相似度
    public static float checkSingleLineWithSingleLine(String line,String src)
    {
        float result;
        String max = line.length() >= src.length()? line : src;
        String min = line.length() >= src.length()? src : line;
        int l = 0;
        String s ="";
        for(int i=0;i<min.length();i++){
            for(int j=i+1;j<=min.length();j++){
                if(max.contains(min.substring(i,j)) && j-i>l){
                    l=j-i;
                    s=min.substring(i,j);
                }
            }
        }
        result=s.length();
        result/=line.length();
        return result;
    }
    //将一行和一行比较，使用集合法求出相似度
    public static float checkDuplicationWithMatrix(String s1,String s2)
    {
        float result;
        int count=0;
        for (int i=0;i<s1.length();i++)
            for (int j=0;j<s2.length();j++)
                if (s1.charAt(i)==s2.charAt(j))
                    count++;
        result=count;
        result/=((double) (s1.length() + s2.length()) /2);
        return result;
    }
}
