package emreylc.sipmessage.message.header.pheader;

import java.util.ArrayList;

import emreylc.sipmessage.message.header.SipMessageHeader;
import emreylc.sipmessage.message.header.parameter.GenericParam;

public class PAnswerState extends SipMessageHeader {

    private String answerType;
    private ArrayList<GenericParam> genericParamList;

}
