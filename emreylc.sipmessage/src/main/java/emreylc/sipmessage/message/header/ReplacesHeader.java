package emreylc.sipmessage.message.header;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.parameter.GenericParam;

public class ReplacesHeader extends SipMessageHeader {

    private String callId;
    private ArrayList<String> toTagList;
    private ArrayList<String> fromTagList;
    // early-only
    private boolean earlyFlag = false;
    private ArrayList<GenericParam> genericParamList;

}
