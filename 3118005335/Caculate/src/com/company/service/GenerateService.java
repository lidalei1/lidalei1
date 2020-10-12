package com.company.service;



import com.company.model.Fraction;
import com.company.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateService {
    private static FractionService fractionService = new FractionService();
    private static CalculateService calculateService = new CalculateService();

    /*
     * 生成算式，以及结果 limit表示生成每一个分式的最大值
     */
    public static Result generateFormula(int limit) {

        String exp = "";
        Random r = new Random();

        char[] c = { '+', '-', '*', '÷' };
        int s = r.nextInt(3);// 生成运算符的数量
        List l = new ArrayList();
        switch (s) {
            // 一个运算符
            case 0: {

                int franum = r.nextInt(2);
                if (franum == 0) {

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);

                    String symbol = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol);
                    l.add(f2);
//				if(!fractionService.isrule(l)){
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol + " " + f2.toString();

                } else if (franum == 1) {

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(true, limit);

                    String symbol = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol);
                    l.add(f2);

//				if(!fractionService.isrule(l)){
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol + " " + f2.toString();

                } else if (franum == 2) {
                    //
                    Fraction f = new Fraction(true, limit);
                    Fraction f2 = new Fraction(true, limit);

                    String symbol = String.valueOf(c[r.nextInt(4)]);
                    l.add(f);
                    l.add(symbol);
                    l.add(f2);
//				if(!fractionService.isrule(l)){
//					return null;
//				}

                    exp = "" + f.toString() + " " + symbol + " " + f2.toString();
                }
                break;
            }
            // 两个运算符
            case 1: {
                int franum = r.nextInt(3);
                if (franum == 0) {
                    // 无分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);
                    Fraction f3 = new Fraction(false, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);

//				if(!fractionService.isrule(l)){
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString();

                } else if (franum == 1) {
                    // 一个分数
                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);
                    Fraction f3 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);


                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
//				if(!fractionService.isrule(l)){
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString();
                } else if (franum == 2) {
                    // 两个分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(true, limit);
                    Fraction f3 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);


                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
//				if(!fractionService.isrule(l)){
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString();


                } else if (franum == 3) {
                    // 三个分数
                    Fraction f = new Fraction(true, limit);
                    Fraction f2 = new Fraction(true, limit);
                    Fraction f3 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
//				if(!fractionService.isrule(l)){
//					return null;
//				}

                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString();
                }

                break;
            }
            // 三个符号
            case 2: {

                int franum = r.nextInt(3);
                if (franum == 0) {
                    // 无分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);
                    Fraction f3 = new Fraction(false, limit);
                    Fraction f4 = new Fraction(false, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    String symbol3 = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
                    l.add(symbol3);
                    l.add(f4);
//				if (!fractionService.isrule(l)) {
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString()
                            + " " + symbol3 + " " + f4.toString();


                } else if (franum == 1) {
                    // 一个分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);
                    Fraction f3 = new Fraction(false, limit);
                    Fraction f4 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    String symbol3 = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
                    l.add(symbol3);
                    l.add(f4);
//				if (!fractionService.isrule(l)) {
//					return null;
//				}

                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString()
                            + " " + symbol3 + " " + f4.toString();
                } else if (franum == 2) {
                    // 两个分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(false, limit);
                    Fraction f3 = new Fraction(true, limit);
                    Fraction f4 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    String symbol3 = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
                    l.add(symbol3);
                    l.add(f4);
//				if (!fractionService.isrule(l)) {
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString()
                            + " " + symbol3 + " " + f4.toString();
                } else if (franum == 3) {
                    // 三个分数

                    Fraction f = new Fraction(false, limit);
                    Fraction f2 = new Fraction(true, limit);
                    Fraction f3 = new Fraction(true, limit);
                    Fraction f4 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    String symbol3 = String.valueOf(c[r.nextInt(4)]);

                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
                    l.add(symbol3);
                    l.add(f4);
//				if (!fractionService.isrule(l)) {
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString()
                            + " " + symbol3 + " " + f4.toString();
                } else if (franum == 3) {
                    // 四个分数
                    Fraction f = new Fraction(true, limit);
                    Fraction f2 = new Fraction(true, limit);
                    Fraction f3 = new Fraction(true, limit);
                    Fraction f4 = new Fraction(true, limit);

                    String symbol1 = String.valueOf(c[r.nextInt(4)]);
                    String symbol2 = String.valueOf(c[r.nextInt(4)]);
                    String symbol3 = String.valueOf(c[r.nextInt(4)]);


                    l.add(f);
                    l.add(symbol1);
                    l.add(f2);
                    l.add(symbol2);
                    l.add(f3);
                    l.add(symbol3);
                    l.add(f4);
//				if (!fractionService.isrule(l)) {
//					return null;
//				}
                    exp = "" + f.toString() + " " + symbol1 + " " + f2.toString() + " " + symbol2 + " " + f3.toString()
                            + " " + symbol3 + " " + f4.toString();
                }

                break;
            }

        }
        for (int i = 0; i < l.size(); i++) {
            if (i % 2 != 0) {
                if (l.get(i).equals("÷")) {
                    l.set(i, "/");
                }
            }
        }
        if(!fractionService.isrule(l)){
            return null;
        }
        Fraction m = calculateService.calculate(l);
        if(m==null){
            return null;
        }
//		String m = calculateService.calculate(l).toString();
        //System.out.println(m);
        l.clear();
        return new Result(exp, m.toString());
        // System.out.println(exp);

    }
}
