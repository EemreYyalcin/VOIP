package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.parameter.NameOrSipUriParam;
import emreylc.sipmessage.utils.CheckError;

public class ToHeader extends SipMessageHeader {

    // To: Bob <sip:bob@biloxi.example.com>;tag=8321234356

    private NameOrSipUriParam nameOrSipUriParam;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    nameOrSipUriParam = new NameOrSipUriParam(false);
	    message = nameOrSipUriParam.parse(message);
	    CheckError.checkBoolean(nameOrSipUriParam.errorParse);
	    message = addParams(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    nameOrSipUriParam = null;
	    return originalMessage;
	}
    }

    public String toString() {
	try {
	    String headerValue = "To: ";
	    if (nameOrSipUriParam == null) {
		return null;
	    }
	    headerValue += nameOrSipUriParam.toString();
	    headerValue += appendParameter();
	    return headerValue;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    return null;
	}
    }

}
