package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;

public class PolicyIDHeader extends SipMessageHeader {

    private ArrayList<SipURI> policyIDList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    policyIDList = new ArrayList<SipURI>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		SipURI sipUri = new SipURI();
		sipUri.parse(part);
		sipUri = (SipURI) CheckError.checkBooleanWithoutException(sipUri.errorParse, sipUri);
		if (sipUri == null) {
		    continue;
		}
		policyIDList.add(sipUri);
	    }
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	String headerValue = "Policy-ID: ";
	if (policyIDList == null) {
	    return null;
	}
	for (int i = 0; i < policyIDList.size(); ++i) {
	    SipURI sipUri = policyIDList.get(i);
	    if (++i == policyIDList.size()) {
		headerValue = sipUri.toString();
	    } else {
		headerValue = sipUri.toString() + ",";
	    }
	}
	return headerValue;
    }

}
