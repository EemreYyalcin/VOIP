package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class MaxForwardsHeader extends SipMessageHeader {

    private int maxForwards;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    maxForwards = Integer.valueOf(message);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "Max-Forwards: ";
	if (maxForwards == -1) {
	    return null;
	}
	return headerValue + maxForwards;
    }

}
