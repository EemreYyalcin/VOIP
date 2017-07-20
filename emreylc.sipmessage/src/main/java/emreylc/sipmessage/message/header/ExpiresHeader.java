package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class ExpiresHeader extends SipMessageHeader {

    private int expires = -1;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    expires = Integer.valueOf(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "Expires: ";
	if (expires == -1) {
	    return null;
	}
	return headerValue + expires;
    }

}
