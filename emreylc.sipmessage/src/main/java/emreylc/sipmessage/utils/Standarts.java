package emreylc.sipmessage.utils;

public class Standarts {

    public static String splitWhitespace = "[\\s\\xA0]+";
    public static String CR = "\r";
    public static String LF = "\n";
    public static String CRLF = CR + LF;
    public static String SPACE = " ";

    public static void main(String[] args) {
	String str = "emre\r ylc test1 \r test ";
	String[] parts = str.split(Standarts.CR);
	for (String string : parts) {
	    System.out.println(string);
	}
    }

}
