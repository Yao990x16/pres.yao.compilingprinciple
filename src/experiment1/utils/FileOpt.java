package experiment1.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @ClassName FileOpt
 * @Description TOOD
 * Date 2020/4/19 17:45
 **/
public class FileOpt {
    static String root = System.getProperty("user.dir");
    /*static String filePath =
            root+ File.separator+"src" + File.separator + "experiment1"+File.separator+"out"+File.separator+
                    "output.txt";*/
    static String filePath = root+ File.separator+ "output.txt";
    public static boolean readFile(StringBuffer buffer, String fileSrc) {
        try {
            FileReader fileReader = new FileReader(fileSrc);
            BufferedReader br = new BufferedReader(fileReader);
            String temp = null;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 追加方式写文件
     * @param args	需要写入字符串
     * @return	true : success
     * 		   false : filed
     */
    public static boolean writeFile(String args) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(args);
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }
    /**
     * 清空文件
     */
    public static boolean clearFile() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }
}
