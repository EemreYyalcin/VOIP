package emreylc.sipmessage.message.header.pheader;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.SipMessageHeader;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.SipURI;

public class PAssertedIdentity extends SipMessageHeader {

    private ArrayList<NameAddress> nameAddressList;
    private ArrayList<SipURI> requestURIList;

}
