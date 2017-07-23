package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.parameter.NameOrSipUriParam;
import emreylc.sipmessage.utils.CheckError;

public class ContactHeader extends SipMessageHeader {

    private NameOrSipUriParam nameOrSipUriParam;

    @Override
    public String parse(String message) {
	String originalMessage = message;
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
	    String headerValue = "Contact:";
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
