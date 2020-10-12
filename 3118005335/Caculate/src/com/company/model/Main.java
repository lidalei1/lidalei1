package com.company.model;


import com.company.service.GenerateService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BufferedOutputStream bo = null; // 写入到文件的缓冲流
        GenerateService gs = new GenerateService(); // 生成分式类
        List<Result> lists = new ArrayList<Result>(); // 存放分式的集合
        Result rm = null;
        Scanner scanner = new Scanner(System.in);// 监听用户选择的文件的数量
        int limit = 0;
        int number = 0;

        try {
            File file = new File("./Exercises.txt");

            System.out.println("请输入要生成的题目数量:");
            number = scanner.nextInt();
            System.out.println("请输入要生成的分式的最大值:");
            limit = scanner.nextInt();
            bo = new BufferedOutputStream(new FileOutputStream(file));
            int i = 0;
            while (i < number) {
                rm = gs.generateFormula(limit);
                if (rm == null || rm.getResult().contains("-")) {
                    continue;
                }

                bo.write(rm.toString().getBytes());
                bo.write("\r\n".getBytes());
                i = i + 1;
                if (i == 100) {
                    bo.flush();
                }
            }

            bo.flush();
            bo.close();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                bo.flush();
                bo.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}
