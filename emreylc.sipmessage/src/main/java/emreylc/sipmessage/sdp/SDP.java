package emreylc.sipmessage.sdp;

import java.util.ArrayList;

import emreylc.sipmessage.elements.SipConstant.SDPMediaType;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Generator;
import emreylc.sipmessage.utils.Standarts;

public class SDP {

    private String version = "0";
    private String originator;
    private String sessionName;
    private String sessionInformation;
    private String uri;
    private String email;
    private String phone;
    private String connectionInformation;
    private String bandwidth;
    private String time;
    private String repeat;
    private String zone;
    private String key;
    private ArrayList<SDPAttribute> sdpAttributeList;
    private ArrayList<SDPMedia> sdpMediaList;

    private String globalIpO;

    private String globalIpC;

    public boolean errorParse = false;

    public void parse(String[] lines, int index) {
	try {
	    for (int i = index; i < lines.length; i++) {
		parseSDPHeader(lines[i]);
	    }
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 1);
	    errorParse = true;
	}
    }

    public void parseSDPHeader(String line) throws Exception {
	line = line.trim();
	String[] codeAndValue = line.split("=");
	if (codeAndValue == null || codeAndValue.length < 2) {
	    throw new Exception();
	}
	String code = codeAndValue[0].trim();
	String value = codeAndValue[1].trim();

	if (code.equals("m")) {
	    setMedia(value);
	    return;
	}
	if (getSdpMediaList() != null) {
	    getSdpMediaList().get(getSdpMediaList().size() - 1).parse(code, value);
	    return;
	}
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
	} else if (code.equals("o")) {
	    setOriginator(value.substring(0, value.indexOf("IN")));
	    int tempIndex = value.indexOf("IP4");
	    if (tempIndex < 0) {
		return;
	    }
	    value = value.substring(tempIndex + "IP4".length());
	    value = value.trim();
	    setGlobalIpO(value);
	} else if (code.equals("s")) {
	    setSessionName(value);
	} else if (code.equals("v")) {
	    setVersion(value);
	} else if (code.equals("u")) {
	    setUri(value);
	} else if (code.equals("e")) {
	    setEmail(value);
	} else if (code.equals("p")) {
	    setPhone(value);
	} else if (code.equals("c")) {
	    int tempIndex = value.indexOf("IP4");
	    if (tempIndex < 0) {
		return;
	    }
	    value = value.substring(tempIndex + "IP4".length());
	    value = value.trim();
	    setGlobalIpC(value);

	} else if (code.equals("b")) {
	    setBandwidth(value);
	} else if (code.equals("t")) {
	    setTime(value);
	} else if (code.equals("r")) {
	    setRepeat(value);
	} else if (code.equals("z")) {
	    setZone(value);
	} else if (code.equals("k")) {
	    setKey(value);
	} else if (code.equals("i")) {
	    setSessionInformation(value);
	}
    }

    public void setMedia(String line) throws Exception {

	SDPMedia sdpMedia = new SDPMedia();

	String[] parts = line.split(Standarts.splitWhitespace);
	if (parts == null || parts.length < 3) {
	    throw new Exception();
	}
	sdpMedia.setSdpMediaType(SDPMediaType.valueOf(parts[0]));
	sdpMedia.setPort(Integer.valueOf(parts[1]));
	sdpMedia.setRtpType(parts[2]);
	for (int i = 3; i < parts.length; i++) {
	    if (sdpMedia.getCodecList() == null) {
		sdpMedia.setCodecList(new ArrayList<SDPCodec>());
	    }
	    sdpMedia.getCodecList().add(new SDPCodec(Integer.valueOf(parts[i])));
	}
	if (getSdpMediaList() == null) {
	    setSdpMediaList(new ArrayList<SDPMedia>());
	}
	getSdpMediaList().add(sdpMedia);
    }

    @Override
    public String toString() {
	try {
	    String sdp = "v=" + version + Standarts.LF;
	    String ip = getGlobalIpO();
	    if (ip == null) {
		ip = getGlobalIpC();
	    }
	    if (getOriginator() == null) {
		String sessionNum = Generator.generateBigNum();
		setOriginator("YLC " + sessionNum + " " + sessionNum);
	    }
	    sdp += "o=" + getOriginator() + " IN IP4 " + ip + Standarts.LF;
	    if (getSessionName() != null) {
		sdp += "s=" + getSessionName() + Standarts.LF;
	    }
	    if (getSessionInformation() != null) {
		sdp += "i=" + getSessionInformation() + Standarts.LF;
	    }
	    if (getUri() != null) {
		sdp += "u=" + getUri() + Standarts.LF;
	    }
	    if (getEmail() != null) {
		sdp += "e=" + getEmail() + Standarts.LF;
	    }
	    if (getPhone() != null) {
		sdp += "p=" + getPhone() + Standarts.LF;
	    }
	    if (getGlobalIpC() != null) {
		sdp += "c=" + " IN IP4 " + getGlobalIpC() + Standarts.LF;
	    }
	    if (getBandwidth() != null) {
		sdp += "b=" + getBandwidth() + Standarts.LF;
	    }
	    if (getTime() != null) {
		sdp += "t=" + getTime() + Standarts.LF;
	    }
	    if (getRepeat() != null) {
		sdp += "r=" + getRepeat() + Standarts.LF;
	    }
	    if (getZone() != null) {
		sdp += "z=" + getZone() + Standarts.LF;
	    }
	    if (getKey() != null) {
		sdp += "k=" + getKey() + Standarts.LF;
	    }
	    if (getSdpAttributeList() != null) {
		for (int i = 0; i < getSdpAttributeList().size(); i++) {
		    sdp += getSdpAttributeList().get(i).toString();
		}
	    }
	    if (getSdpMediaList() != null) {
		for (int i = 0; i < getSdpMediaList().size(); i++) {
		    sdp += getSdpMediaList().get(i).toString();
		}
	    }
	    return sdp;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 2);
	    return null;
	}
    }

    public void setIpAddress(String ipAddress) {
	setGlobalIpO(ipAddress);
	setGlobalIpC(ipAddress);
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public String getOriginator() {
	return originator;
    }

    public void setOriginator(String originator) {
	this.originator = originator;
    }

    public String getSessionName() {
	return sessionName;
    }

    public void setSessionName(String sessionName) {
	this.sessionName = sessionName;
    }

    public String getSessionInformation() {
	return sessionInformation;
    }

    public void setSessionInformation(String sessionInformation) {
	this.sessionInformation = sessionInformation;
    }

    public String getUri() {
	return uri;
    }

    public void setUri(String uri) {
	this.uri = uri;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getConnectionInformation() {
	return connectionInformation;
    }

    public void setConnectionInformation(String connectionInformation) {
	this.connectionInformation = connectionInformation;
    }

    public String getBandwidth() {
	return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
	this.bandwidth = bandwidth;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }

    public String getRepeat() {
	return repeat;
    }

    public void setRepeat(String repeat) {
	this.repeat = repeat;
    }

    public String getZone() {
	return zone;
    }

    public void setZone(String zone) {
	this.zone = zone;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public ArrayList<SDPAttribute> getSdpAttributeList() {
	return sdpAttributeList;
    }

    public void setSdpAttributeList(ArrayList<SDPAttribute> sdpAttributeList) {
	this.sdpAttributeList = sdpAttributeList;
    }

    public String getGlobalIpO() {
	return globalIpO;
    }

    public void setGlobalIpO(String globalIpO) {
	this.globalIpO = globalIpO;
    }

    public String getGlobalIpC() {
	return globalIpC;
    }

    public void setGlobalIpC(String globalIpC) {
	this.globalIpC = globalIpC;
    }

    public ArrayList<SDPMedia> getSdpMediaList() {
	return sdpMediaList;
    }

    public void setSdpMediaList(ArrayList<SDPMedia> sdpMediaList) {
	this.sdpMediaList = sdpMediaList;
    }

}
