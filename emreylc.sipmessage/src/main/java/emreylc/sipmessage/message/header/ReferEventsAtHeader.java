package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.line.uri.SipURI;

public class ReferEventsAtHeader extends SipMessageHeader {

    private SipURI sipURI;
    private ArrayList<GenericParam> genericParams;

}
