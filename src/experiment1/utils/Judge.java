package experiment1.utils;


/**
 * @author Yao
 * @ClassName JudgeType
 * @Description
 * Date 2020/4/18 15:58
 **/

public class Judge {
    //运算符
    static char[] opt = {'+', '-', '*', '/', '=', '>', '<', '&', '|','!' };
    //终结符
    static char[] terminator = {',', ';', '{', '}', '(', ')', '[', ']', '_',':', '.', '"','\\'};
    //关键字
    static String[] keyWords = {"const","int","char","void","main","if","else","do","while","for","scanf","printf","return"};


    /**
     * 判断是否为字母
     * @param ch 需判断的字符
     * @return boolean
     */
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    /**
     * 判断是否为数字
     * @param ch 需判断的字符
     * @return boolean
     */
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
    /**
     * 判断是否为关键字
     * @param s 需判断的字符串
     * @return boolean
     */
    public static boolean isKeyWord(String s) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为运算符
     * @param ch 需判断的字符
     * @return boolean
     */
    public static boolean isOperator(char ch) {
        for (int i = 0; i < opt.length; i++) {
            if (ch == opt[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为分隔符
     * @param ch 需判断的字符
     * @return boolean
     */
    public static boolean isSeparators(char ch) {
        for (int i = 0; i < terminator.length; i++) {
            if (ch == terminator[i]) {
                return true;
            }
        }
        return false;
    }

}
