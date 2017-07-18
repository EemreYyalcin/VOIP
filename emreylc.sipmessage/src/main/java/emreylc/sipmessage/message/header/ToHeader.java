package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;

public class ToHeader extends SipMessageHeader {

    private NameAddress nameAddress;
    private SipURI sipUri;
    private ArrayList<GenericParam> genericParamList;

}
