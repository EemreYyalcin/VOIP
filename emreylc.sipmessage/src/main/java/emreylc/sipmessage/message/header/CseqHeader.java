package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.Method;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public class CseqHeader extends SipMessageHeader {

    private int value;
    private Method method;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    String[] parts = message.split(Standarts.splitWhitespace);
	    if (parts.length < 2) {
		throw new Exception();
	    }
	    value = Integer.valueOf(parts[0]);
	    method = new Method();
	    message = method.parse(parts[1]);
	    CheckError.checkBoolean(method.errorParse);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	String headerValue = "Cseq: ";
	try {
	    headerValue += value + " " + method.toString();
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    return null;
	}
	return headerValue;
    }

    public static void main(String[] args) {
//	String message = " 1 INVITE";
//	 String message = "1 INVITE";
	 String message = " 3  INVITE";
	System.out.println("message:" + message);
	CseqHeader cseq = new CseqHeader();
	message = cseq.parse(message);
	System.out.println("messagea:" + message);
	System.out.println("toString:" + cseq.toString());

    }

}
