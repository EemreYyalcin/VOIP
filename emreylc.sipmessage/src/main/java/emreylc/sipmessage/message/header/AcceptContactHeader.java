package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.LineUtils;

public class AcceptContactHeader extends SipMessageHeader {

    private String acceptContact;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    int endIndex = LineUtils.getParamIndexOrEndLine(message);
	    acceptContact = message.substring(0, endIndex);
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
	return "Accept-Contact: " + acceptContact + appendParameter();
    }

    public static void main(String[] args) {
//	String message = " *;audio;require";
//	 String message = "*;video;explicit";
	 String message = " *;methods=\"BYE\";class=\"business\";q=1.0";

	AcceptContactHeader acceptContactHeader = new AcceptContactHeader();
	System.out.println("message:" + message);
	message = acceptContactHeader.parse(message);
	System.out.println("messagea:" + message);
	System.out.println("ToString:" + acceptContactHeader.toString());

    }

}
