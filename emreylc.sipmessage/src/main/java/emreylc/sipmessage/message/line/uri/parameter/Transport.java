package emreylc.sipmessage.message.line.uri.parameter;

public class Transport extends UriParameter{

	//transport=tcp
	private TransportType transportType;
	
	
	public enum TransportType {
		udp, tcp, sctp, tls, ws
	}

}
