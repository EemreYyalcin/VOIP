package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.authenticate.creditial.Challenge;
import emreylc.sipmessage.utils.CheckError;

public class AuthorizationHeader extends SipMessageHeader {

    private Challenge digestResponse;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    digestResponse = new Challenge(params);
	    message = digestResponse.parse(message);
	    CheckError.checkBoolean(digestResponse.errorParse);
	    return message;
	} catch (Exception e) {
	    digestResponse = null;
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Authorization: " + digestResponse.toString();
    }

}
