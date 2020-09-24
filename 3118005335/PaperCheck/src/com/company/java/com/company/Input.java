package com.company.java.com.company;
import java.text.DecimalFormat;

public class Input {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00" );
    public static void processpath(String orgFileName,String orgAddFileName,String outputPath) {
        String org = Separateword.ReadtoString(orgFileName);
        String orgAdd = Separateword.ReadtoString(orgAddFileName);
        String result = (df2.format(Calculate.detect(org, orgAdd)));
        System.out.println("查重结果为：" + result);
        Output.output(outputPath, result);
    }
}
