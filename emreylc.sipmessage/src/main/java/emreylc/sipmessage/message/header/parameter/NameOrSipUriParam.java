package emreylc.sipmessage.message.header.parameter;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;

public class NameOrSipUriParam {

    private NameAddress nameAddress;
    private SipURI addrSpec;

    public boolean errorParse = false;
    private boolean checkParameter = true;

    public NameOrSipUriParam(boolean checkParameter) {
	this.checkParameter = checkParameter;
    }

    public String parse(String message) {
	String originalMessage = message;
	try {
	    nameAddress = new NameAddress();
	    message = nameAddress.parse(message);
	    if (nameAddress.errorParse) {
		nameAddress = null;
		addrSpec = new SipURI(checkParameter);
		message = addrSpec.parse(message);
		CheckError.checkBoolean(addrSpec.errorParse);
	    }
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

	return message;
    }

    public String toString() {
	try {
	    String headerValue = "";
	    if (nameAddress == null && addrSpec == null) {
		return null;
	    }
	    if (nameAddress != null) {
		headerValue += nameAddress.toString();
		return headerValue;
	    }
	    if (addrSpec != null) {
		headerValue += addrSpec.toString();
	    }
	    return headerValue;

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    return null;
	}
    }

}
