package emreylc.sipmessage.sdp;

import java.util.ArrayList;

import emreylc.sipmessage.elements.SipConstant.RtpType;

public abstract class SDPMedia {

    private int port;
    private RtpType rtpType;
    private ArrayList<SDPCodec> codecList;
    private ArrayList<SDPAttribute> sdpAttributeList;
}
