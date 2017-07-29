package emreylc.sipmessage.sdp;

import java.util.ArrayList;

import emreylc.sipmessage.elements.SipConstant.SDPMediaType;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public class SDPMedia {

    private int port = 0;
    private String rtpType = "RTP/AVP";
    private ArrayList<SDPCodec> codecList;
    private ArrayList<SDPAttribute> sdpAttributeList;
    private String mediaIp;
    private String bandwidth;
    private String key;
    private String mediaTitle;

    private SDPMediaType sdpMediaType;

    public void parse(String code, String value) {
	if (code.equals("a")) {
	    SDPAttribute sdpAttribute = new SDPAttribute();
	    sdpAttribute.parse(value);
	    sdpAttribute = (SDPAttribute) CheckError.checkBooleanWithoutException(sdpAttribute.errorParse,
		    sdpAttribute);
	    if (sdpAttribute != null) {
		if (getSdpAttributeList() == null) {
		    setSdpAttributeList(new ArrayList<SDPAttribute>());
		}
		getSdpAttributeList().add(sdpAttribute);
	    }
	} else if (code.equals("c")) {
	    int tempIndex = value.indexOf("IP4");
	    if (tempIndex < 0) {
		return;
	    }
	    value = value.substring(tempIndex + "IP4".length());
	    value = value.trim();
	    setMediaIp(value);

	} else if (code.equals("b")) {
	    setBandwidth(value);
	} else if (code.equals("k")) {
	    setKey(value);
	} else if (code.equals("i")) {
	    setMediaTitle(value);
	}

    }

    @Override
    public String toString() {
	try {
	    if (sdpMediaType == null) {
		return null;
	    }
	    String line = "m=" + sdpMediaType.toString() + " " + port + " " + rtpType + " ";
	    if (codecList == null) {
		return line;
	    }
	    String rtpMaps = "";
	    for (int i = 0; i < codecList.size(); i++) {
		line += codecList.get(i).getNum() + " ";
		rtpMaps += codecList.get(i).toString();
	    }
	    line += Standarts.LF + rtpMaps;
	    if (getMediaIp() != null) {
		line += "c=" + getMediaIp();
	    }
	    if (getBandwidth() != null) {
		line += "b=" + getBandwidth();
	    }
	    if (getKey() != null) {
		line += "k=" + getKey();
	    }
	    if (getMediaTitle() != null) {
		line += "i" + getMediaTitle();
	    }
	    if (getSdpAttributeList() == null) {
		return line;
	    }
	    for (int i = 0; i < getSdpAttributeList().size(); i++) {
		line += getSdpAttributeList().get(i).toString();
	    }

	    return line;

	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 2);
	    return null;
	}
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getRtpType() {
	return rtpType;
    }

    public void setRtpType(String rtpType) {
	this.rtpType = rtpType;
    }

    public ArrayList<SDPCodec> getCodecList() {
	return codecList;
    }

    public void setCodecList(ArrayList<SDPCodec> codecList) {
	this.codecList = codecList;
    }

    public ArrayList<SDPAttribute> getSdpAttributeList() {
	return sdpAttributeList;
    }

    public void setSdpAttributeList(ArrayList<SDPAttribute> sdpAttributeList) {
	this.sdpAttributeList = sdpAttributeList;
    }

    public String getMediaIp() {
	return mediaIp;
    }

    public void setMediaIp(String mediaIp) {
	this.mediaIp = mediaIp;
    }

    public SDPMediaType getSdpMediaType() {
	return sdpMediaType;
    }

    public void setSdpMediaType(SDPMediaType sdpMediaType) {
	this.sdpMediaType = sdpMediaType;
    }

    public String getBandwidth() {
	return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
	this.bandwidth = bandwidth;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getMediaTitle() {
	return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
	this.mediaTitle = mediaTitle;
    }

}
