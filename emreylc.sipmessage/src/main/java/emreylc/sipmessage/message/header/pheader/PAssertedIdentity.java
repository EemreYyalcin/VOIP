package emreylc.sipmessage.message.header.pheader;

import java.util.ArrayList;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.SipMessageHeader;
import emreylc.sipmessage.message.header.parameter.NameOrSipUriParam;
import emreylc.sipmessage.utils.CheckError;

public class PAssertedIdentity extends SipMessageHeader {

    private ArrayList<NameOrSipUriParam> nameOrSipUriParamList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    nameOrSipUriParamList = new ArrayList<NameOrSipUriParam>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		NameOrSipUriParam nameOrSipUriParam = new NameOrSipUriParam(true);
		nameOrSipUriParam.parse(part);
		nameOrSipUriParam = (NameOrSipUriParam) CheckError
			.checkBooleanWithoutException(nameOrSipUriParam.errorParse, nameOrSipUriParam);
		if (nameOrSipUriParam == null) {
		    continue;
		}
		nameOrSipUriParamList.add(nameOrSipUriParam);
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
	String headerValue = "P-Asserted-Identity: ";
	if (nameOrSipUriParamList == null) {
	    return null;
	}
	for (int i = 0; i < nameOrSipUriParamList.size(); ++i) {
	    NameOrSipUriParam nameOrSipUriParam = nameOrSipUriParamList.get(i);
	    if (++i == nameOrSipUriParamList.size()) {
		headerValue = nameOrSipUriParam.toString();
	    } else {
		headerValue = nameOrSipUriParam.toString() + ",";
	    }
	}
	return headerValue;
    }

}
