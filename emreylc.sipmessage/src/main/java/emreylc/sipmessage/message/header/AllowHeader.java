package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.Method;
import emreylc.sipmessage.utils.CheckError;

public class AllowHeader extends SipMessageHeader {

    // Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY
    private ArrayList<Method> allowMethodList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    allowMethodList = new ArrayList<Method>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		Method method = new Method();
		method.parse(part);
		method = (Method) CheckError.checkBooleanWithoutException(method.errorParse, method);
		if (method == null) {
		    continue;
		}
		allowMethodList.add(method);
	    }
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	String headerValue = "Allow: ";
	if (allowMethodList == null) {
	    return null;
	}
	int size = allowMethodList.size();
	for (int i = 0; i < size; ++i) {
	    Method method = allowMethodList.get(i);
	    if ((i + 1) == allowMethodList.size()) {
		headerValue += method.toString();
	    } else {
		headerValue += method.toString() + ", ";
	    }
	}
	return headerValue;
    }

}
