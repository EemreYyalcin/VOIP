package emreylc.sipmessage.message.line.uri.element;

public class UserInfo {

    // (user/ telephonesubscriber)[ ":" password ] "@"

    public boolean errorParse = false;

    private User user;
    private String password;

    public String parse(String message) {
	try {

	} catch (Exception e) {
	    errorParse = true;

	}
	return message;
    }

}
