package emreylc.sipmessage.message;

import emreylc.sipmessage.log.LogMessage;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.RequestLine;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.LineUtils;

public class RequestMessage extends Message {

    private RequestLine requestLine;

    @Override
    protected String parse(String message) {
	try {
	    String splitElement = LineUtils.getLineEndSuffix(message);
	    String[] lines = message.split(splitElement);
	    if (lines.length < 2) {
		throw new Exception();
	    }
	    requestLine = new RequestLine();
	    requestLine.parse(lines[0]);
	    CheckError.checkBoolean(requestLine.errorParse);
	    for (int i = 1; i < lines.length; i++) {
		try {
		    parseHeader(lines[i]);
		} catch (Exception e) {
		    TraceErrorLog.traceError(e, 1);
		    errorParse = true;
		    LogMessage.error("Parsing Error " + lines[i]);
		}
	    }

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 1);
	    errorParse = true;
	    requestLine = null;
	}
	return null;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return null;
    }

}
