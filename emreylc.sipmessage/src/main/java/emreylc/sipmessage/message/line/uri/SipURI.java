package emreylc.sipmessage.message.line.uri;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.element.HostPort;
import emreylc.sipmessage.message.line.uri.element.UserInfo;
import emreylc.sipmessage.message.line.uri.parameter.UriParameter;
import emreylc.sipmessage.utils.CheckError;

public class SipURI {

    public boolean errorParse = false;

    private SipType sipType;
    private UserInfo userInfo;
    private HostPort hostPort;
    private UriParameter uriParameter;
    private boolean checkParameter = true;

    public SipURI(boolean checkParameter) {
	this.checkParameter = checkParameter;
    }

    public SipURI() {
    }

    // sips:ss2.biloxi.example.com SIP/2.0

    public String parse(String message) {
	String originalMessage = message;
	try {
	    int colonIndex = message.indexOf(":");
	    if (colonIndex < 0) {
		throw new Exception();
	    }
	    String sipType = message.substring(0, colonIndex);
	    sipType = sipType.trim();
	    setSipType(SipType.valueOf(sipType));
	    message = message.substring(colonIndex + 1);
	    userInfo = new UserInfo();
	    message = userInfo.parse(message);
	    userInfo = (UserInfo) CheckError.checkBooleanWithoutException(userInfo.errorParse, userInfo);
	    hostPort = new HostPort();
	    message = hostPort.parse(message);
	    CheckError.checkBoolean(hostPort.errorParse);
	    if (checkParameter) {
		uriParameter = new UriParameter();
		message = uriParameter.parse(message);
		uriParameter = (UriParameter) CheckError.checkBooleanWithoutException(uriParameter.errorParse,
			uriParameter);
	    }
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 9);
	    errorParse = true;
	    return originalMessage;
	}

	return message;
    }

    public SipType getSipType() {
	return sipType;
    }

    public void setSipType(SipType sipType) {
	this.sipType = sipType;
    }

    public String toString() {
	try {
	    String sipUri = "";
	    if (sipType == null) {
		return null;
	    }
	    if (hostPort == null) {
		return null;
	    }
	    sipUri += sipType.toString() + ":";
	    if (userInfo != null) {
		sipUri += userInfo.toString();
	    }
	    sipUri += hostPort.toString();
	    if (uriParameter != null) {
		sipUri += uriParameter.toString();
	    }
	    return sipUri;

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 7);
	    return null;
	}
    }

    public enum SipType {
	sip, sips
    }

    public static void main(String[] args) {
	String message1 = "sips:ss2.biloxi.example.com;target=bob%40example.com;cause=486 SIP/2.0\n";
	// String message1 = "sips:ss2.biloxi.example.com SIP/2.0\n";
	SipURI sipUri = new SipURI();
	System.out.println("message1:" + message1);
	message1 = sipUri.parse(message1);
	System.out.println("message1 After:" + message1);
	System.out.println("errorParse:" + sipUri.errorParse);

    }
}
