package emreylc.sipmessage.message.header.parameter;

import java.util.ArrayList;

import emreylc.sipmessage.message.line.uri.element.HostPort;

public class ViaParam {

    private static String sipProtocol = "SIP/2.0";
    private Transport transport;
    private HostPort hostPort;
    private ArrayList<ViaParameter> parameters;

    public enum Transport {
	UDP, TCP, TLS, SCTP
    }

}
