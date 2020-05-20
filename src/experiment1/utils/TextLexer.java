package experiment1.utils;

/**
 * @ClassName TestLexer
 * @Description TOOD
 * Date 2020/4/19 17:49
 **/
public class TextLexer {
    /**
     * @Description:
     * @Param 
     * @return 
     **/
        private StringBuffer buffer = new StringBuffer();
        private int i = 0;
        //存放最新读进的源程序字符
        private char ch;
        //存放构成单词符号的字符串
        private String strToken;

        public TextLexer() {
        }

        /**
         * @Description: 读取指定路径的文件
         * @Param [fileSrc]
         * @return
         **/
        public TextLexer(String fileSrc) {
            FileOpt.readFile(buffer, fileSrc);
        }

       /**
        * @Description:
        * @Param []
        * @return void
        **/
        public void analyse() {
            strToken = "";
            FileOpt.clearFile();//清空文件
            while (i < buffer.length()) {
                getChar();
                getBC();
                if (Judge.isLetter(ch)) {
                    while (Judge.isLetter(ch) || Judge.isDigit(ch)) {
                        concat();
                        getChar();
                    }
                    retract(); // 回调
                    if (Judge.isKeyWord(strToken)) {
                        //strToken为关键字
                        switch (strToken){
                            case "const":
                                writeFile("CONSTK",strToken);
                                break;
                            case "int":
                                writeFile("INTTK",strToken);
                                break;
                            case "char":
                                writeFile("CHARTK",strToken);
                                break;
                            case "void":
                                writeFile("VOIDTK",strToken);
                                break;
                            case "main":
                                writeFile("MAINTK",strToken);
                                break;
                            case "if":
                                writeFile("IFTK",strToken);
                                break;
                            case "else":
                                writeFile("ELSETK",strToken);
                                break;
                            case "do":
                                writeFile("DOTK",strToken);
                                break;
                            case "while":
                                writeFile("WHILETK",strToken);
                                break;
                            case "for":
                                writeFile("FORTK",strToken);
                                break;
                            case "scanf":
                                writeFile("SCANFTK",strToken);
                                break;
                            case "printf":
                                writeFile("PRINTFTK",strToken);
                                break;
                            case "return":
                                writeFile("RETURNTK",strToken);
                                break;
                                default :
                        }

                    } else {
                        //strToken为标识符
                        writeFile("STRCON",strToken);
                    }
                    strToken = "";
                } else if (Judge.isDigit(ch)) {
                    //ch为数字
                    while (Judge.isDigit(ch)) {
                        concat();
                        getChar();
                    }
                    //不能数字+字母
                    if(!Judge.isLetter(ch)){
                        retract(); // 回调
                        // 是整形
                        writeFile("INTCON",strToken);
                    }else {
                        // 非法
                        writeFile("error",strToken);
                    }
                    strToken = "";
                    //运算符
                } else if (Judge.isOperator(ch)) {
                    if(ch == '/'){
                        getChar();
                        retract();
                    }
                    switch (ch) {
                        case '+': writeFile("PLUS",ch+""); break;
                        case '-': writeFile("MINU",ch+""); break;
                        case '*': writeFile("MUTL",ch+""); break;
                        case '/': writeFile("DIV",ch+""); break;
                        case '>': writeFile("GRE",ch+""); break;
                        case '<': writeFile("LSS",ch+""); break;
                        case '=': writeFile("ASSIGN",ch+""); break;
                        case '&': writeFile("AND",ch+""); break;
                        case '|': writeFile("OR",ch+""); break;
                        case '!': writeFile("NEQ",ch+""); break;
                        default:  break;
                    }
                } else if (Judge.isSeparators(ch)) {
                    switch (ch){
                        case ';':
                            writeFile("SEMICN",ch+"");
                            break;
                        case ',':
                            writeFile("COMMA",ch+"");
                            break;
                        case '(':
                            writeFile("LPARENT",ch+"");
                            break;
                        case ')':
                            writeFile("RPARENT",ch+"");
                            break;
                        case '[':
                            writeFile("LBRACK",ch+"");
                            break;
                        case ']':
                            writeFile("RBRACK",ch+"");
                            break;
                        case '{':
                            writeFile("LBRACE",ch+"");
                            break;
                        case '}':
                            writeFile("RBRACE",ch+"");
                            break;
                            case '\'':
                                writeFile("CHARTK",ch+"");
                                break;
                                default :
                    }

                }
            }
        }

        /**
         * 将下一个输入字符读到ch中，搜索指示器前移一个字符
         */
        public void getChar() {
            ch = buffer.charAt(i);
            i++;
        }
        /** 检查ch中的字符是否为空白，若是则调用getChar()直至ch中进入一个非空白字符*/
        public void getBC() {
            //isSpaceChar(char ch) 确定指定字符是否为 Unicode 空白字符。
            //上述方法不能识别换行符
            //确定指定字符依据 Java 标准是否为空白字符
            while (Character.isWhitespace(ch))
            {
                getChar();
            }
        }

        /**将ch连接到strToken之后*/
        public void concat() {
            strToken += ch;
        }
        /** 将搜索指示器回调一个字符位置，将ch值为空白字 */
        public void retract() {
            i--;
            ch = ' ';
        }
        /**
         * 按照二元式规则写入文件
         * @param file 字符类型
         * @param s	当前字符
         */
        public void writeFile(String file,String s) {
            System.out.println(file+" "+s);
            FileOpt.writeFile(file+" "+s+'\n');
        }
}
