package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class ReasonHeader extends SipMessageHeader {

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    message = addParams(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Reason: " + justAppendParameter();
    }

}
