package emreylc.sipmessage.message.line.uri.element;

import emreylc.sipmessage.utils.LineUtils;

public class HostPort {

    // host [ ":" port ]
    private String host;
    private String port;

    public boolean errorParse = false;

    public String parse(String message) {
	try {
	    int semiColonIndex = message.indexOf(";");
	    int lastIndex = 0;
	    if (semiColonIndex > 0) {
		lastIndex = semiColonIndex;
	    } else {
		lastIndex = LineUtils.getLineEndIndex(message);
		if (lastIndex <= 0) {
		    throw new Exception();
		}
	    }
	    String hostPort = message.substring(0, lastIndex);
	    int twoDotsIndex = hostPort.indexOf(":");
	    if (twoDotsIndex < 0) {
		setHost(hostPort.trim());
		return message.substring(lastIndex);
	    }
	    setHost(hostPort.substring(0, twoDotsIndex).trim());
	    setPort(hostPort.substring(twoDotsIndex + 1).trim());
	    return message.substring(lastIndex);
	} catch (Exception e) {
	    errorParse = true;
	    return message;
	}
    }

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public String getPort() {
	return port;
    }

    public void setPort(String port) {
	this.port = port;
    }

    public String toString() {
	if (port == null) {
	    return host;
	}
	return host + ":" + port;
    }

    public static void main(String[] args) {

	String message1 = "atlanta.com\r\n";
	String message2 = "atlanta.com;transport=tcp \n";
	String message3 = "gateway.com:8888;user=phone\r\n";
	HostPort hostPort = new HostPort();
	System.out.println("m1:" + message1);
	message1 = hostPort.parse(message1);
	System.out.println("m11" + message1);
	System.out.println("host:" + hostPort.host + " port:" + hostPort.port);

	hostPort = new HostPort();
	System.out.println(message2);
	message2 = hostPort.parse(message2);
	System.out.println(message2);
	System.out.println("host:" + hostPort.host + " port:" + hostPort.port);

	hostPort = new HostPort();
	System.out.println(message3);
	message3 = hostPort.parse(message3);
	System.out.println(message3);
	System.out.println("host:" + hostPort.host + " port:" + hostPort.port);

    }

}
