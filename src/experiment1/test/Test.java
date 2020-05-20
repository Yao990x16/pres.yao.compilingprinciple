package experiment1.test;

import experiment1.utils.TextLexer;

import java.io.File;

/**
 * @ClassName test
 * @Description TOOD
 * Date 2020/4/18 20:32
 **/
public class Test {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String filePath =
                root+ File.separator+"src" + File.separator + "experiment1"+File.separator+"io"+File.separator+
                        "testfile.txt";


        TextLexer textLexer = new TextLexer(filePath);
        //FileUtil.clearFile();
        textLexer.analyse();
    }

}
