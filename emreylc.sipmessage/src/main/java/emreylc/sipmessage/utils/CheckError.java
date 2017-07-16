package emreylc.sipmessage.utils;

public class CheckError {

    public static void checkBoolean(boolean error) throws Exception {
	if (error) {
	    throw new Exception();
	}
    }

    public static Object checkBooleanWithoutException(boolean error, Object object) {
	if (error) {
	    return null;
	}
	return object;
    }

}
