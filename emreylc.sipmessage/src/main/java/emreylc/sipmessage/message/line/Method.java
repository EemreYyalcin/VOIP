package emreylc.sipmessage.message.line;

import emreylc.sipmessage.log.TraceErrorLog;

public class Method {

    private SipMethod sipMethod;
    public boolean errorParse = false;

    public String parse(String message) {
	try {
	    String[] parts = message.split(" ");
	    setSipMethod(SipMethod.valueOf(parts[0]));
	    message = message.substring(parts[0].length());
	    return message;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 10);
	    errorParse = true;
	    return message;
	}
    }

    public SipMethod getSipMethod() {
	return sipMethod;
    }

    public void setSipMethod(SipMethod sipMethod) {
	this.sipMethod = sipMethod;
    }

    public enum SipMethod {
	REGISTER, INVITE, ACK, BYE, CANCEL, OPTIONS, PRACT, SUBSCRIBE, NOTIFY, INFO, REFER, MESSAGE, UPDATE, PUBLISH
    }

    @Override
    public String toString() {
	if (sipMethod != null) {
	    return sipMethod.toString();
	}
	return null;
    }

    public static void main(String[] args) {
	String message = "INVITEX 2123";
	Method method = new Method();
	message = method.parse(message);
	System.out.println("method:" + method);
	System.out.println("message:" + message);
	System.out.println("errorParse:" + method.errorParse);
    }

}
