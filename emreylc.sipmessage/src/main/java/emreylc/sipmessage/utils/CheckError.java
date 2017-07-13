package emreylc.sipmessage.utils;

public class CheckError {

    public static void checkBoolean(boolean error) throws Exception {
	if (error) {
	    throw new Exception();
	}
    }

}
