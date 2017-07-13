package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;

public class ReferedByHeader extends SipMessageHeader {

    private NameAddress nameAddress;
    private SipURI requestUri;
    private ArrayList<GenericParam> genericParamList;

}
