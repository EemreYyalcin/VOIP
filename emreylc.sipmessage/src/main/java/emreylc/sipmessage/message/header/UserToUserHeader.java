package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.LineUtils;

public class UserToUserHeader extends SipMessageHeader {

    private String userToUser;
    
    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    int endIndex = LineUtils.getParamIndexOrEndLine(message);
	    userToUser = message.substring(0, endIndex);
	    message = message.substring(endIndex);
	    message = addParams(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "User-to-User: " + userToUser + appendParameter();
    }

}
