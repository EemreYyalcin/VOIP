package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.authenticate.creditial.Challenge;
import emreylc.sipmessage.utils.CheckError;

public class ProxyAuthorizationHeader extends SipMessageHeader {

    private Challenge credential;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    credential = new Challenge(params);
	    message = credential.parse(message);
	    CheckError.checkBoolean(credential.errorParse);
	    return message;
	} catch (Exception e) {
	    credential = null;
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Proxy-Authorization: " + credential.toString();
    }

}
