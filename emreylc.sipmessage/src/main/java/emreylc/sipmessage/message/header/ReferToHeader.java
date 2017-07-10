package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.RequestURI;

public class ReferToHeader extends SipMessageHeader {

    private NameAddress nameAddress;
    private RequestURI requestUri;
    private ArrayList<GenericParam> genericParamList;

}
