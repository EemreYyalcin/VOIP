package emreylc.sipmessage.message.line.uri.element;

import emreylc.sipmessage.log.TraceErrorLog;

public class UserInfo {

    // (user/ telephonesubscriber)[ ":" password ] "@"

    public boolean errorParse = false;

    private String user;
    private String password;

    public String parse(String message) {
	try {
	    int atIndex = message.indexOf("@");
	    if (atIndex <= 0) {
		errorParse = true;
		return message;
	    }
	    String userAndPassword = message.substring(0, atIndex);
	    int twoDotsIndex = userAndPassword.indexOf(":");
	    if (twoDotsIndex <= 0) {
		user = userAndPassword;
		return message.substring(atIndex + 1);
	    }
	    user = userAndPassword.substring(0, twoDotsIndex);
	    password = userAndPassword.substring(twoDotsIndex + 1);
	    return message.substring(atIndex + 1);

	} catch (Exception e) {
	    errorParse = true;

	}
	return message;
    }
    
    public String toString(){
	try {
	    String userInfo = "";
	    userInfo += user;
	    if (password != null) {
		userInfo += ":" + password;
	    }
	    userInfo += "@";
	    return userInfo;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 8);
	    return null;
	}
    }

    public static void main(String[] args) {
	UserInfo userInfo = new UserInfo();
	String message1 = "alice:secretword@atlanta.com ";
	String message2 = "alice@atlanta.com;transport=tcp ";
	String message3 = "+1-212-555-1212:1234@gateway.com;user=phone";
	System.out.println(message1);
	message1 = userInfo.parse(message1);
	System.out.println(message1);
	System.out.println("user:" + userInfo.user + " Password:" + userInfo.password);

	userInfo = new UserInfo();
	System.out.println(message2);
	message2 = userInfo.parse(message2);
	System.out.println(message2);
	System.out.println("user:" + userInfo.user + " Password:" + userInfo.password);

	userInfo = new UserInfo();
	System.out.println(message3);
	message3 = userInfo.parse(message3);
	System.out.println(message3);
	System.out.println("user:" + userInfo.user + " Password:" + userInfo.password);

    }

}
