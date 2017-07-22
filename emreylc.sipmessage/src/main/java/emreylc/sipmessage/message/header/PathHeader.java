package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.utils.CheckError;

public class PathHeader extends SipMessageHeader {

    private ArrayList<NameAddress> nameAddressList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    nameAddressList = new ArrayList<NameAddress>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		NameAddress nameAddress = new NameAddress();
		nameAddress.parse(part);
		nameAddress = (NameAddress) CheckError.checkBooleanWithoutException(nameAddress.errorParse,
			nameAddress);
		if (nameAddress == null) {
		    continue;
		}
		nameAddressList.add(nameAddress);
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
	String headerValue = "Path: ";
	if (nameAddressList == null) {
	    return null;
	}
	for (int i = 0; i < nameAddressList.size(); ++i) {
	    NameAddress nameAddress = nameAddressList.get(i);
	    if (++i == nameAddressList.size()) {
		headerValue = nameAddress.toString();
	    } else {
		headerValue = nameAddress.toString() + ",";
	    }
	}
	return headerValue;
    }

}
