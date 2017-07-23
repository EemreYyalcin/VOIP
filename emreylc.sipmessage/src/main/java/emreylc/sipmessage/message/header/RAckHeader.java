package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.Method;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public class RAckHeader extends SipMessageHeader {

    private int responseNum = -1;

    private int cseqNum = -1;

    private Method method;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    String[] parts = message.split(Standarts.splitWhitespace);
	    if (parts.length < 3) {
		throw new Exception();
	    }
	    responseNum = Integer.valueOf(parts[0].trim());
	    cseqNum = Integer.valueOf(parts[1].trim());
	    method = new Method();
	    method.parse(parts[2]);
	    CheckError.checkBoolean(method.errorParse);
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	if (method == null || responseNum < 0 || cseqNum < 0) {
	    return null;
	}
	return "RAck: " + responseNum + " " + cseqNum + " " + method.toString();
    }

}
