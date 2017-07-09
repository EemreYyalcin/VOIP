package emreylc.sipmessage.message.authenticate.creditial;

import emreylc.sipmessage.message.authenticate.ainfo.Cnonce;
import emreylc.sipmessage.message.authenticate.ainfo.MessageQop;
import emreylc.sipmessage.message.authenticate.ainfo.NonceCount;

public class DigestResponse extends Creditial {

    private String username;
    private String realm;
    private String nonce;
    private String digestUri;
    private String dresponse;
    private String algorithm;
    private Cnonce cnonce;
    private String opaque;
    private MessageQop messageQop;
    private NonceCount nonceCount;
    private String auts;

}
