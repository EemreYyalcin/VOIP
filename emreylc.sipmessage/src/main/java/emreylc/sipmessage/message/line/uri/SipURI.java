package emreylc.sipmessage.message.line.uri;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.element.HostPort;
import emreylc.sipmessage.message.line.uri.element.UserInfo;
import emreylc.sipmessage.message.line.uri.parameter.UriParameter;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public class SipURI {

    public boolean errorParse = false;

    private SipType sipType;
    private UserInfo userInfo;
    private HostPort hostPort;
    private UriParameter uriParameter;

    public String parse(String message) {
	try {
	    String[] parts = message.split(Standarts.splitWhitespace);
	    setSipType(SipType.valueOf(parts[0]));
	    message = message.substring(parts[0].length());
	    userInfo = new UserInfo();
	    message = userInfo.parse(message);
	    userInfo = (UserInfo) CheckError.checkBooleanWithoutException(userInfo.errorParse, userInfo);
	    hostPort = new HostPort();
	    message = hostPort.parse(message);
	    CheckError.checkBoolean(hostPort.errorParse);

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 9);
	    errorParse = true;
	}

	return null;
    }

    public SipType getSipType() {
	return sipType;
    }

    public void setSipType(SipType sipType) {
	this.sipType = sipType;
    }

    public enum SipType {
	sip, sips
    }
}
