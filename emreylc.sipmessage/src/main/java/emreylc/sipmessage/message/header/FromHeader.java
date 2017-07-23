package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.parameter.NameOrSipUriParam;
import emreylc.sipmessage.utils.CheckError;

public class FromHeader extends SipMessageHeader {

    private NameOrSipUriParam nameOrSipUriParam;

    // "A. G. Bell" <sip:agb@bell-telephone.com> ;tag=a48s (nameAddress)
    // sip:+12125551212@server.phone2net.com;tag=887s (addrSpec)
    // Anonymous <sip:c8oqz84zk7z@privacy.org>;tag=hyh8 (nameAddress)

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    nameOrSipUriParam = new NameOrSipUriParam(false);
	    message = nameOrSipUriParam.parse(message);
	    CheckError.checkBoolean(nameOrSipUriParam.errorParse);
	    message = addParams(message);
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    nameOrSipUriParam = null;
	    return originalMessage;
	}

	return message;
    }

    public String toString() {
	try {
	    String headerValue = "From:";
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

    public static void main(String[] args) {
	// String message = "Alice
	// <sip:alice@atlanta.example.com>;tag=9fxced76sl \r\n";
	// String message =
	// "\"Anonymous\"<sip:anonymous@anonymous.invalid>;tag=1928301774 \r\n";
	 String message ="sip:+12125551212@server.phone2net.com;tag=887s\r\n";
//	String message = "\"A. G. Bell\" <sip:agb@bell-telephone.com>;tag=a48s\r\n";

	FromHeader fromHeader = new FromHeader();
	System.out.println("message:" + message);
	message = fromHeader.parse(message);
	System.out.println("messagea:" + message);
	System.out.println("fromHeader:" + fromHeader.toString());

    }

}
