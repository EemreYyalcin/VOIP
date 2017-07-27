package emreylc.sipmessage.message;

import emreylc.sipmessage.code.StatusCode;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.LineUtils;
import emreylc.sipmessage.utils.Standarts;

public class ResponseMessage extends Message {

    private String sipVersion = "SIP/2.0";
    private StatusCode statusCode;
    @Override
    public String parse(String message) {
	try {
	    String splitElement = LineUtils.getLineEndSuffix(message);
	    String[] lines = message.split(splitElement);
	    if (lines.length < 2) {
		throw new Exception();
	    }
	    lines[0] = lines[0].trim();
	    if (lines[0].indexOf(sipVersion) < 0) {
		throw new Exception();
	    }
	    String[] parts = lines[0].split(Standarts.splitWhitespace);
	    if (parts.length < 3) {
		throw new Exception();
	    }
	    int code = Integer.valueOf(parts[1]);
	    statusCode = new StatusCode(code);
	    super.parseLine(lines);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 1);
	    errorParse = true;
	    statusCode = null;
	}
	return null;
    }

    @Override
    public String toString() {
	if (statusCode == null) {
	    return null;
	}
	String message = sipVersion + " " + statusCode.getStatusCode() + " " + statusCode.getStatusCodeName()
		+ Standarts.CRLF;
	message += super.toString();
	return message;
    }

    public String getSipVersion() {
	return sipVersion;
    }

    public void setSipVersion(String sipVersion) {
	this.sipVersion = sipVersion;
    }

    public StatusCode getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
	this.statusCode = statusCode;
    }

}
