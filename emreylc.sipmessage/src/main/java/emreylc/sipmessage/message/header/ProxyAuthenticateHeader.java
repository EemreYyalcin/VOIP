package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.authenticate.creditial.Challenge;
import emreylc.sipmessage.utils.CheckError;

public class ProxyAuthenticateHeader extends SipMessageHeader {

    private Challenge challenge;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    challenge = new Challenge(params);
	    message = challenge.parse(message);
	    CheckError.checkBoolean(challenge.errorParse);
	    return message;
	} catch (Exception e) {
	    challenge = null;
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Proxy-Authenticate: " + challenge.toString();
    }

}
