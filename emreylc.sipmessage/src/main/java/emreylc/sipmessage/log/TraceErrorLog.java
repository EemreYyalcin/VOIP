package emreylc.sipmessage.log;

public class TraceErrorLog {

    //must be set different way
    public static int level = 5;

    public static void traceError(Exception e, int level) {
	if (TraceErrorLog.level < level) {
	    return;
	}
	e.printStackTrace();
    }

}
