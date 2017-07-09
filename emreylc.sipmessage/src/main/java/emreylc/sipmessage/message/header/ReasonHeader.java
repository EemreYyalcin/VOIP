package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.ReasonParam;

public class ReasonHeader extends SipMessageHeader {

    private String protocol;
    private ArrayList<ReasonParam> reasonParams;

}
