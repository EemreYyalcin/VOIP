package emreylc.sipmessage.message.header;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.header.parameter.TagParam;
import emreylc.sipmessage.message.line.uri.SipURI;

public class FromHeader extends SipMessageHeader {

    private String displayName;
    private SipURI requestUri;
    private TagParam tag;
    private GenericParam genericParam;

}
