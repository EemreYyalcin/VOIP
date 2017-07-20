package emreylc.sipmessage.message.line.uri;

import emreylc.sipmessage.utils.CheckError;

public class NameAddress {

    private String displayName;
    private SipURI addrSpec;

    public boolean errorParse = false;

    // [disyplayName] < addrSpec >

    public String parse(String message) {
	String originalMessage = message;
	try {
	    int laquotIndex = message.indexOf("<");
	    int raquotIndex = message.indexOf(">");
	    if (laquotIndex < 0 || raquotIndex < 0) {
		throw new Exception();
	    }
	    if (laquotIndex == 0) {
		displayName = null;
	    } else {
		displayName = message.substring(0, laquotIndex);
		displayName = displayName.trim();
	    }
	    addrSpec = new SipURI();
	    addrSpec.parse(message.substring(laquotIndex + 1, raquotIndex));
	    CheckError.checkBoolean(addrSpec.errorParse);
	    return message.substring(raquotIndex + 1);
	} catch (Exception e) {
	    errorParse = true;
	    return originalMessage;
	}
    }

    public String toString() {
	try {
	    String nameAddress = "";
	    if (displayName != null) {
		nameAddress += displayName;
	    }
	    if (addrSpec == null) {
		return null;
	    }
	    nameAddress += "<";
	    nameAddress += addrSpec.toString();
	    nameAddress += ">";
	    return nameAddress;
	} catch (Exception e) {
	    return null;
	}

    }

    public static void main(String[] args) {
	// String message = "Bob <sip:bob@biloxi.example.com> XXX";
	String message = "\"Bob\" <sip:bob@biloxi.example.com> XXX";
	NameAddress nameAddress = new NameAddress();
	System.out.println("message:" + message);
	message = nameAddress.parse(message);
	System.out.println("messagea:" + message);
    }

}
