package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class MinExpiresHeader extends SipMessageHeader {

    private int minExpires;
    
    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    minExpires = Integer.valueOf(message);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "Min-Expires: ";
	if (minExpires == -1) {
	    return null;
	}
	return headerValue + minExpires;
    }


}
