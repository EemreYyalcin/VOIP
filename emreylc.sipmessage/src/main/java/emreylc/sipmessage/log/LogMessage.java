package emreylc.sipmessage.log;

public class LogMessage {

    // must be set different way
    public static int level = 5;

    public static void error(String message) {
	if (level > 0) {
	    System.out.println("ERROR: " + message);
	}
    }

    public static void warning(String message) {
	if (level > 1) {
	    System.out.println("WARNING: " + message);
	}
    }

    public static void debug(String message) {
	if (level > 2) {
	    System.out.println("DEBUG: " + message);
	}
    }

    public static void trace(String message) {
	if (level > 3) {
	    System.out.println("TRACE: " + message);
	}
    }

    public static void all(String message) {
	if (level > 4) {
	    System.out.println("ALL: " + message);
	}
    }

}
