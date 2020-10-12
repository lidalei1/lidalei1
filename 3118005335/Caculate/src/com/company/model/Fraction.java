package com.company.model;

import java.util.Random;

public class Fraction {
    private int denominator;// 分母
    private int nominator;// 分子

    public Fraction(int denominator, int nominator) {
        super();
        this.denominator = denominator;
        this.nominator = nominator;
    }

    public Fraction(int nominator) {
        this.denominator = 1;
        this.nominator = nominator;
    }

    public Fraction() {
        super();
    }

    // 判断构建的是一个分数还是一个整数，不超过limit的数值
    public Fraction(boolean l, int limit) {
        Random r = new Random();
        // 这是一个分数
        if (l == true) {
            int index = r.nextInt(limit);
            int index2 = r.nextInt(limit);

            while(index==0) {
                index = r.nextInt(limit);
//				System.out.println("会生成0："+index);
            }
//			System.out.println("不会生成0："+index);
            this.denominator = index;
            this.nominator = index2;

            // 这是一个整数
        } else {
            int index = r.nextInt(limit);
            this.denominator = 1;
            this.nominator = index;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    @Override
    public String toString() {
        Appointment();
        if(this.denominator == 0){
            System.out.println(this.nominator + "|" + this.denominator);
            System.out.println("分母为0");
        }
        if (this.denominator == 1 || this.nominator == 0) {
            return "" + this.nominator;
        }else if (this.nominator > this.denominator) {
            if(nominator % denominator==0){
                return "" + nominator / denominator;
            }
            return "" + nominator / denominator + "," + nominator % denominator + "/" + denominator;
        }else{
            return "" + this.nominator + "/" + this.denominator;
        }


    }

    // 加法运算
    public Fraction add(Fraction r) {
        int a = r.getNominator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNominator = nominator * b + denominator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newDenominator, newNominator);
        return result;
    }

    // 减法运算
    public Fraction sub(Fraction r) {
        int a = r.getNominator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNominator = nominator * b - denominator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newDenominator, newNominator);
        return result;
    }

    // 分数的乘法运算
    public Fraction mut(Fraction r) { // 乘法运算
        int a = r.getNominator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNominator = nominator * a;
        int newDenominator = denominator * b;
        Fraction result = new Fraction(newDenominator, newNominator);
        return result;
    }

    // 分数除法运算
    public Fraction div(Fraction r) {
        int a = r.getNominator();// 获得分子
        int b = r.getDenominator();// 获得分母
        int newNominator = nominator * b;
        int newDenominator = denominator * a;
        Fraction result = new Fraction(newDenominator, newNominator);
        return result;
    }

    // 用辗转相除法求最大公约数
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 对分数进行约分
    public void Appointment() {
        if (nominator == 0 || denominator == 1)
            return;
        // 如果分子是0或分母是1就不用约分了
        long gcd = gcd(nominator, denominator);
        this.nominator /= gcd;
        this.denominator /= gcd;
    }

    public int existZero(){
        if(this.nominator<0||this.denominator<0){
            return 0;
        }else {
            return 1;
        }
    }
}
