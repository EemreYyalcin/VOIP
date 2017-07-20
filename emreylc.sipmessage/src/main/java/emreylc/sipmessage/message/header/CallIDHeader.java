package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class CallIDHeader extends SipMessageHeader {

    private String callID;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    callID = message.trim();
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Call-ID: " + callID;
    }
}
