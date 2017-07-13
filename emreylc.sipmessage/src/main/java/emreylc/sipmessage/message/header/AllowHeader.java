package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.line.Method;

public class AllowHeader extends SipMessageHeader {

    // Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY
    private ArrayList<Method> allowMethods;
}
