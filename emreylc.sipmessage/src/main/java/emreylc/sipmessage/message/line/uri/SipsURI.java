package emreylc.sipmessage.message.line.uri;

import emreylc.sipmessage.message.line.uri.element.HostPort;
import emreylc.sipmessage.message.line.uri.element.UserInfo;
import emreylc.sipmessage.message.line.uri.parameter.UriParameter;

public class SipsURI extends RequestURI {

    private final String sip = "sips";
    private UserInfo userInfo;
    private HostPort hostPort;
    private UriParameter uriParameter;
//    private Header header;
    
}
