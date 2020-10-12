package com.company.model;



import com.company.service.CheckService;
import com.company.service.FractionService;
import com.company.service.GenerateService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Operation {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
    private static GenerateService gs = new GenerateService();
    private static FractionService fs = new FractionService();

    public static void main(String[] args) {
        if(args.length==4){
            if(args[0].equals("-n")){
                int num = Integer.parseInt(args[1]);
                int limit = Integer.parseInt(args[3]);
                boolean result = mainGenerate(limit,num);
                if(result){
                    System.out.println("题目文件生成在jar包同级文件夹");
                }else {
                    System.out.println("程序出现错误");
                }
            }else {
                String checked = args[1];
                String answer = args[3];
                boolean result = mainCheck(checked,answer);
                if(result){
                    System.out.println("成绩文件生成在jar包同级文件夹");
                }else {
                    System.out.println("程序出现错误");
                }
            }
        }else {
            System.out.println("请按规格输入参数 ");
            System.out.println("说明参数1：-n [设置题目个数] -r [设置题目中数值的范围]");
            System.out.println("数值范围指自然数、真分数和真分数分母");
            System.out.println("说明参数2：-e [<exercisefile>.txt] -a [<answerfile>.txt]");
            System.out.println("参数2为检查文件答案是否正确的指令");
            System.out.println("请按规格输入参数");
        }


    }

    public static boolean mainGenerate(int limit,int num){
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        BufferedOutputStream bo = null; // 写入到文件的缓冲流
        BufferedOutputStream bo2 = null;
        List<List<String>> lists = new ArrayList<List<String>>();
        Result rm = null;
//		num = 10000;
        int i = 1;

        try {
            File file = new File("./Exercises.txt");
            File file2 = new File("./Answer.txt");
            bo = new BufferedOutputStream(new FileOutputStream(file));
            bo2 = new BufferedOutputStream(new FileOutputStream(file2));
//			bo.write(date.getBytes());
//			bo.write("\r\n".getBytes());
            while (i <= num) {

                // PrintStream ps = new PrintStream(new FileOutputStream(file));
                rm = gs.generateFormula(limit);
                if (rm != null) {
                    boolean result = fs.intoList(rm.getExp(), lists);
                    if (result == false) {
                        continue;
                    }
//					System.out.println(rm.getExp() + "=" + rm.getResult());
                    bo.write((i+".").getBytes());
                    bo.write(rm.toStringExp().getBytes());
                    bo.write("\r\n".getBytes());

                    bo2.write((i+".").getBytes());
                    bo2.write(rm.toString().getBytes());
                    bo2.write("\r\n".getBytes());
                    i++;
                }
            }
            bo.flush();
            bo2.flush();
            bo.close();
            bo2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.out.println("文件输入输出异常");
            e.printStackTrace();
            return false;
        }
        return true;
//		System.out.println(date);
    }

    public static boolean mainCheck(String checked,String answer){
        BufferedOutputStream bo = null; // 写入到文件的缓冲流
        try {
            File file = new File("./Grade.txt");
            bo = new BufferedOutputStream(new FileOutputStream(file));
            Map<String,String> m = CheckService.Check(checked, answer);
            bo.write(m.get("wrong").getBytes());
            bo.write("\r\n".getBytes());
            bo.write(m.get("correct").getBytes());
            bo.flush();
            bo.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
}
