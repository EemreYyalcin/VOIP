package emreylc.sipmessage.message;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.RequestLine;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.LineUtils;

public class RequestMessage extends Message {

    private RequestLine requestLine;

    @Override
    public String parse(String message) {
	try {
	    String splitElement = LineUtils.getLineEndSuffix(message);
	    String[] lines = message.split(splitElement);
	    if (lines.length < 2) {
		throw new Exception();
	    }
	    requestLine = new RequestLine();
	    requestLine.parse(lines[0].trim());
	    CheckError.checkBoolean(requestLine.errorParse);
	    super.parseLine(lines);
	    return message;

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 1);
	    errorParse = true;
	    requestLine = null;
	}
	return null;
    }

    public String toString() {
	if (requestLine == null) {
	    return null;
	}
	String message = requestLine.toString();
	message += super.toString();
	return message;
    }

}
