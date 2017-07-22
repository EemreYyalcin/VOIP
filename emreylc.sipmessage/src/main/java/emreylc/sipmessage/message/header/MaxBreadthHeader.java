package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class MaxBreadthHeader extends SipMessageHeader {

    private int maxBreadth;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    maxBreadth = Integer.valueOf(message);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "Max-Breadth: ";
	if (maxBreadth == -1) {
	    return null;
	}
	return headerValue + maxBreadth;
    }

}
