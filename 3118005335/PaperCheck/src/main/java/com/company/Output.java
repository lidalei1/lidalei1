package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
    public static void output(String outputPath, String result) {
        File f = new File(outputPath);
        try (FileWriter fr = new FileWriter(f)) {
            String data = result;
            char[] cs = data.toCharArray();
            fr.write(cs);
            fr.close();
            System.out.println("结果已写入" + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
