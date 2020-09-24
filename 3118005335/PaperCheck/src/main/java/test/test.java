package test;

import com.company.Calculate;
import com.company.EmptyFileException;
import com.company.Output;
import com.company.Separateword;
import org.junit.Test;

import java.text.DecimalFormat;

public class test {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00" );
    @Test
    public void origAndAllTest(){
        String[] str = new String[10];
        str[0] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        str[1] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_add.txt");
        str[2] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_del.txt");
        str[3] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_1.txt");
        str[4] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_3.txt");
        str[5] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_7.txt");
        str[6] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_10.txt");
        str[7] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_15.txt");
        str[8] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_mix.txt");
        str[9] = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_rep.txt");

        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";

        for(int i = 0; i <= 9; i++){
            String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str[0],str[i])));
            Output.output(ansFileName,ans);

        }
    }

    @Test
    public void fileReadTest(){
        String str = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        System.out.println(str);
    }

    @Test
    public void fileWriteTest(){
        Output.output("D:/Idea/IdeaProject/txt1/tests/ans.txt","0.85");
    }

    @Test
    public void emptyFileTest() throws EmptyFileException {
        String str = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/empty.txt");
        System.out.println(str);
    }

    @Test
    public void origAndOrigTest(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndAddTest(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_add.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDelTest(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_del.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDis1Test(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_1.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDis3Test(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_3.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDis7Test(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_7.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDis10Test(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_10.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndDis15Test(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_dis_15.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndMixTest(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_mix.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }

    @Test
    public void origAndRepTest(){
        String str0 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig.txt");
        String str1 = Separateword.ReadtoString("D:/Idea/IdeaProject/txt1/tests/orig_0.8_rep.txt");
        String ansFileName = "D:/Idea/IdeaProject/txt1/tests/ans.txt";
        String ans = (df2.format(Calculate.checkDuplicationWithMatrix(str0,str1)));
        Output.output(ansFileName,ans);
    }
}

