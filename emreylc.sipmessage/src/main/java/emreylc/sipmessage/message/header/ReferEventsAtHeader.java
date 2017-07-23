package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;

public class ReferEventsAtHeader extends SipMessageHeader {

    private SipURI addrSpec;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    addrSpec = new SipURI();
	    message = addrSpec.parse(message);
	    CheckError.checkBoolean(addrSpec.errorParse);
	    message = addParams(message);

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

	return message;
    }

    public String toString() {
	try {
	    String headerValue = "From:";
	    if (addrSpec == null) {
		return null;
	    }
	    if (addrSpec != null) {
		headerValue += addrSpec.toString();
	    }
	    headerValue += appendParameter();
	    return headerValue;

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    return null;
	}
    }

}
