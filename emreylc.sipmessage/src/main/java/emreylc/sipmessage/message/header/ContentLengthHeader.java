package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class ContentLengthHeader extends SipMessageHeader {

    private int contentLength;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    contentLength = Integer.valueOf(message);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Content-Lentgh: " + contentLength;
    }

    
    
}
