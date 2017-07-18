package emreylc.sipmessage.message.line;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.LineUtils;

public class RequestLine {

    private Method method;

    private SipURI sipURI;

    private String sipVersion = "SIP/2.0";
    public boolean errorParse = false;

    public String parse(String message) {
	String originalMessage = message;
	try {
	    method = new Method();
	    message = method.parse(message);
	    CheckError.checkBoolean(method.errorParse);
	    sipURI = new SipURI();
	    message = sipURI.parse(message);
	    CheckError.checkBoolean(sipURI.errorParse);
	    int endLineIndex = LineUtils.getLineEndIndex(message);
	    sipVersion = message.substring(0, endLineIndex);
	    sipVersion = sipVersion.trim();
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 9);
	    errorParse = true;
	    return originalMessage;
	}

    }

    public void setMethod(Method method) {
	this.method = method;
    }

    public Method getMethod() {
	return method;
    }

    public static void main(String[] args) {
	// String message = "REGISTER sips:ss2.biloxi.example.com SIP/2.0\r\n";
	String message = "REGISTER sips:ss2.biloxi.example.com;target=bob%40example.com;cause=486 SIP/2.0\r\n";
	RequestLine requestLine = new RequestLine();
	System.out.println("message:" + message);
	message = requestLine.parse(message);
	System.out.println("messagea:" + message);
    }

}
