package emreylc.sipmessage.message.authenticate.creditial;

import emreylc.sipmessage.message.authenticate.ainfo.MessageQop;

public class Challenge {

    private String realm;
    private String domain;
    private String nonce;
    private String opaque;
    private String stale;
    private String algorithm;
    private MessageQop qop;
    private String authParam;

}
