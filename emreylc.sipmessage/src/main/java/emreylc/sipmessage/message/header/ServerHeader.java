package emreylc.sipmessage.message.header;

import emreylc.sipmessage.log.TraceErrorLog;

public class ServerHeader extends SipMessageHeader {

    private String server;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    server = message.trim();
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	return "Server: " + server;
    }
    
    
}
