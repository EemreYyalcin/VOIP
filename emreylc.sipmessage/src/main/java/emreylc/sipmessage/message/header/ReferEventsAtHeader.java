package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.line.uri.RequestURI;

public class ReferEventsAtHeader extends SipMessageHeader {

    private RequestURI requestURI;
    private ArrayList<GenericParam> genericParams;

}
