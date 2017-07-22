package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class FlowTimerHeader extends SipMessageHeader {

    private int flowTimer = -1;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    flowTimer = Integer.valueOf(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    @Override
    public String toString() {
	String headerValue = "Flow-Timer: ";
	if (flowTimer == -1) {
	    return null;
	}
	return headerValue + flowTimer;
    }

}
