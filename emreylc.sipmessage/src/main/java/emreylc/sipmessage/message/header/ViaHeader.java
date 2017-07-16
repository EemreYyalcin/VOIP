package emreylc.sipmessage.message.header;

import java.util.Set;

import emreylc.sipmessage.elements.SipConstant.Transport;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.element.HostPort;
import emreylc.sipmessage.message.line.uri.parameter.ParamObject;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.LineUtils;
import emreylc.sipmessage.utils.Standarts;

public class ViaHeader extends SipMessageHeader {

    public boolean errorParse = false;

    private static String sipProtocol = "SIP/2.0/";
    private Transport transport;
    private HostPort hostPort;

    @Override
    public String parse(String message) {
	String originalMessage = message;
	try {
	    int sipProtocolIndex = message.indexOf(sipProtocol);
	    if (sipProtocolIndex < 0) {
		throw new Exception();
	    }
	    message = message.substring(sipProtocolIndex + sipProtocol.length());
	    int spaceIndex = message.indexOf(Standarts.SPACE);
	    if (spaceIndex < 0) {
		throw new Exception();
	    }
	    transport = Transport.valueOf(message.substring(0, spaceIndex));
	    message = message.substring(spaceIndex + 1);
	    int endOfHostPortIndex = message.indexOf(";");
	    boolean hasParam = true;
	    if (endOfHostPortIndex < 0) {
		endOfHostPortIndex = LineUtils.getLineEndIndex(message);
		hasParam = false;
	    }
	    if (endOfHostPortIndex < 0) {
		throw new Exception();
	    }
	    message = parseHostPort(message);
	    if (!hasParam) {
		return message;
	    }
	    endOfHostPortIndex = message.indexOf(";");
	    message = message.substring(endOfHostPortIndex + 1);
	    message = addParams(message);

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}

	return message;
    }

    private String parseHostPort(String message) throws Exception {
	HostPort hostPort = new HostPort();
	message = hostPort.parse(message);
	CheckError.checkBoolean(hostPort.errorParse);
	this.hostPort = hostPort;
	return message;
    }

    public String toString() {
	if (transport == null) {
	    return null;
	}
	if (hostPort == null) {
	    return null;
	}
	String headerValue = "Via: " + sipProtocol;
	headerValue += transport.toString() + " ";
	headerValue += hostPort.toString();
	if (params == null) {
	    return headerValue + Standarts.CRLF;
	}
	Set<Object> keys = params.keySet();
	for (Object key : keys) {
	    ParamObject paramObj = (ParamObject) params.get(key);
	    if (paramObj.isJustNameParam()) {
		headerValue += ";" + key;
	    } else {
		headerValue += ";" + key + "=" + paramObj.getParamValue();
	    }
	}
	return headerValue + Standarts.CRLF;
    }

    public static void main(String[] args) {
	String message1 = "Via: SIP/2.0/UDP 10.11.228.67:5060; branch=z9hG4bK10_16a83292baa1de54e0b7843_I\r\n";
	String message2 = "Via: SIP/2.0/TLS client.biloxi.example.com:5061;branch=z9hG4bKnashds ;received=192.0.2.3;rport\n";
	String message3 = "Via: SIP/2.0/UDP first.example.com: 4000;ttl=16;maddr=224.2.0.1 ;branch=z9hG4bKa7c6a8dlze.1\r\n";
	String message4 = "Via: SIP/2.0/UDP bobspc.biloxi.com:5060\r\n";
	ViaHeader viaHeader = null;

	viaHeader = new ViaHeader();
	System.out.println("message1:" + message1);
	message1 = viaHeader.parse(message1);
	System.out.println("message1:" + message1);
	System.out.println("toString:" + viaHeader.toString());

	viaHeader = new ViaHeader();
	System.out.println("message2:" + message2);
	message2 = viaHeader.parse(message2);
	System.out.println("message2:" + message2);
	System.out.println("toString:" + viaHeader.toString());

	viaHeader = new ViaHeader();
	System.out.println("message3:" + message3);
	message3 = viaHeader.parse(message3);
	System.out.println("message3:" + message3);
	System.out.println("toString:" + viaHeader.toString());

	viaHeader = new ViaHeader();
	System.out.println("message4:" + message4);
	message4 = viaHeader.parse(message4);
	System.out.println("message4:" + message4);
	System.out.println("toString:" + viaHeader.toString());

    }

}
