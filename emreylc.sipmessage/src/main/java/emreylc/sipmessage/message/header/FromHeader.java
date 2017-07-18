package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;
import emreylc.sipmessage.utils.CheckError;

public class FromHeader extends SipMessageHeader {

    private NameAddress nameAddress;
    // OR
    private SipURI addrSpec;

    // "A. G. Bell" <sip:agb@bell-telephone.com> ;tag=a48s (nameAddress)
    // sip:+12125551212@server.phone2net.com;tag=887s (addrSpec)
    // Anonymous <sip:c8oqz84zk7z@privacy.org>;tag=hyh8 (nameAddress)

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

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

	return message;
    }

}
