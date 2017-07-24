package emreylc.sipmessage.message.header.pheader;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.SipMessageHeader;
import emreylc.sipmessage.utils.LineUtils;

public class PDCSBillingInfoHeader extends SipMessageHeader {

    private String pDCSBillingInfo;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    int endIndex = LineUtils.getParamIndexOrEndLine(message);
	    pDCSBillingInfo = message.substring(0, endIndex);
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
	return "P-DCS-Billing-Info: " + pDCSBillingInfo + appendParameter();
    }

}
