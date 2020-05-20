import experiment1.utils.TextLexer;

import java.io.File;

/**
 * @ClassName MainTest
 * @Description TOOD
 * Date 2020/4/19 17:47
 **/
public class MainTest {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String filePath = root+ File.separator+ "testfile.txt";

        TextLexer textLexer = new TextLexer(filePath);
        //FileUtil.clearFile();
        textLexer.analyse();
    }
}
