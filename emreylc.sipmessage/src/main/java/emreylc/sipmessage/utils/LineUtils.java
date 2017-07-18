package emreylc.sipmessage.utils;

public class LineUtils {

    public static int getLineEndIndex(String line) {
	int lastIndex = -1;
	lastIndex = line.indexOf(Standarts.CRLF);
	if (lastIndex >= 0) {
	    return lastIndex;
	}
	lastIndex = line.indexOf(Standarts.LF);
	return lastIndex;
    }
    
    public static String removeLineEnd(String line){
	int lastIndex = -1;
	lastIndex = line.indexOf(Standarts.CRLF);
	if (lastIndex >= 0) {
	    return line.substring(lastIndex + Standarts.CRLF.length());
	}
	lastIndex = line.indexOf(Standarts.LF);
	return line.substring(lastIndex + Standarts.LF.length());
	
    }
    
   

}
