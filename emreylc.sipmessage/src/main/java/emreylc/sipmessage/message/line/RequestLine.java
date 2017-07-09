package emreylc.sipmessage.message.line;

import emreylc.sipmessage.message.RequestMessage.Method;
import emreylc.sipmessage.message.line.uri.RequestURI;

public class RequestLine {

    private Method method;

    private RequestURI requestURI;

    private String sipVersion = "2.0";

}
