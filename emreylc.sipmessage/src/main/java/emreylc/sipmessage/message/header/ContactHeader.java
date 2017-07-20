package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public class ContactHeader extends SipMessageHeader {

    private NameAddress nameAddress;
    private SipURI addrSpec;

    @Override
    public String parse(String message) {
	String originalMessage = message;
	try {
	    nameAddress = new NameAddress();
	    message = nameAddress.parse(message);
	    if (nameAddress.errorParse) {
		nameAddress = null;
		addrSpec = new SipURI(false);
		message = addrSpec.parse(message);
		CheckError.checkBoolean(addrSpec.errorParse);
	    }
	    message = addParams(message);
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

    }

    public String toString() {
	try {
	    String headerValue = "Contact:";
	    if (nameAddress == null && addrSpec == null) {
		return null;
	    }
	    if (nameAddress != null) {
		headerValue += nameAddress.toString();
	    }
	    if (addrSpec != null) {
		headerValue += addrSpec.toString();
	    }
	    headerValue = appendParameter();
	    headerValue += Standarts.CRLF;
	    return headerValue;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    return null;
	}
    }

}
