package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.LineUtils;

public class MinSEHeader extends SipMessageHeader {

    private int deltaSeconds = -1;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    int endLineIndex = LineUtils.getParamIndexOrEndLine(message);
	    deltaSeconds = Integer.valueOf(message.substring(0, endLineIndex));
	    message = message.substring(endLineIndex);
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
	String headerValue = "Min-SE: ";
	if (deltaSeconds == -1) {
	    return null;
	}
	return headerValue + deltaSeconds + appendParameter();
    }

}
