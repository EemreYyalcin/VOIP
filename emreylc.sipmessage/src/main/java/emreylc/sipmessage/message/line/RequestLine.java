package emreylc.sipmessage.message.line;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;

public class RequestLine {

    private Method method = new Method();

    private SipURI sipURI;

    private String sipVersion = "2.0";
    public boolean errorParse = false;

    public String parse(String message) {
	try {
	    message = method.parse(message);
	    CheckError.checkBoolean(method.errorParse);

	    return null;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 9);
	    errorParse = true;
	    return message;
	}

    }

    public void setMethod(Method method) {
	this.method = method;
    }

    public Method getMethod() {
	return method;
    }

}
