package com.company.service;



import com.company.model.Fraction;

import java.util.List;

public class CalculateService {
    //分式的计算方法
    public Fraction calculate(List l){

        int muldiv = MulDivExist(l);
        if(muldiv != -1){
            String s = MulDiv(l,muldiv);
            if(s.equals("error")){
                return null;
            }
        }else {
            String s = AddSub(l);
            if(s.equals("error")){
                return null;
            }
        }
        if (l.size() == 1) {
            return (Fraction) l.get(0);
        }
        return calculate(l);
    }

    /*
     * 判断分式里面是否有乘除
     * 有乘除返回乘除的位置，没乘除返回-1
     */
    public int MulDivExist(List list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                return i;
            }
        }
        return -1;

    }

    //计算分式的乘除，计算结果往前放
    public String MulDiv(List l,int muldiv){
        String fuhao = (String) l.remove(muldiv);
        Fraction first = (Fraction) l.get(muldiv-1);
        Fraction last = (Fraction) l.get(muldiv);
        l.remove(muldiv);
        if (fuhao.equals("*")) {
            Fraction result = first.mut(last);
            l.set(muldiv - 1,result);
            if(result.existZero()==0){
                return "error";
            }
        }
        if (fuhao.equals("/")) {
            Fraction result = first.div(last);
            l.set(muldiv - 1,result);
            if(result.existZero()==0){
                return "error";
            }
        }
        return "right";

    }

    //计算分式的加减，计算结果往前放
    public String AddSub(List list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+")) {
                Fraction first = (Fraction) list.get(i-1);
                list.remove(i);
                Fraction last = (Fraction) list.get(i);
                list.remove(i);
                Fraction result = first.add(last);
                list.set(i - 1, result);
                i--;
                if(result.existZero()==0){
                    return "error";
                }
            }
            if (list.get(i).equals("-")) {
                Fraction first = (Fraction) list.get(i-1);
                list.remove(i);
                Fraction last = (Fraction) list.get(i);
                list.remove(i);
                Fraction result = first.sub(last);
                list.set(i - 1, result);
                i--;
                if(result.existZero()==0){
                    return "error";
                }
            }
        }
        return "right";
    }
}
