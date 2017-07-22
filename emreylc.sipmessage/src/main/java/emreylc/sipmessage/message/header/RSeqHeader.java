package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class RSeqHeader extends SipMessageHeader {

    private int responseNum;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    responseNum = Integer.valueOf(message);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "RSeq: ";
	if (responseNum == -1) {
	    return null;
	}
	return headerValue + responseNum;
    }

}
