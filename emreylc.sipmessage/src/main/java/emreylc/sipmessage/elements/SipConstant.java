package emreylc.sipmessage.elements;

public class SipConstant {

    public enum Transport {
	UDP, TCP, TLS, SCTP
    }
    
    public enum SipMethod {
   	REGISTER, INVITE, ACK, BYE, CANCEL, OPTIONS, PRACT, SUBSCRIBE, NOTIFY, INFO, REFER, MESSAGE, UPDATE, PUBLISH
       }
    
}
