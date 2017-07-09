package emreylc.sipmessage.message.header;

import emreylc.sipmessage.message.RequestMessage.Method;

public class RAckHeader extends SipMessageHeader {

    private int responseNum;

    private int cseqNum;

    private Method method;

}
