package emreylc.sipmessage.message.header;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.header.parameter.TagParam;
import emreylc.sipmessage.message.line.uri.RequestURI;

public class FromHeader extends SipMessageHeader {

    private String displayName;
    private RequestURI requestUri;
    private TagParam tag;
    private GenericParam genericParam;

}
