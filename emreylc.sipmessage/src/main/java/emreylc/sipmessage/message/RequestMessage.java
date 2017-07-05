package emreylc.sipmessage.message;

import emreylc.sipmessage.message.line.RequestLine;

public class RequestMessage extends Message {

	private RequestLine requestLine;
	
	

	public enum Method {
		REGISTER, INVITE, ACK, BYE, CANCEL, OPTIONS, PRACT, SUBSCRIBE, NOTIFY, INFO, REFER, MESSAGE, UPDATE, PUBLISH
	}
}
