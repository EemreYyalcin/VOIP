package emreylc.sipmessage.sdp;

import java.util.ArrayList;

import emreylc.sipmessage.elements.SipConstant.SDPMediaType;
import emreylc.sipmessage.utils.LineUtils;

public class SDP {

    private String version;
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
    private SDPMediaType sdpMedia;
    private SDPMediaAudio mediaAudio;
    private SDPMediaVideo mediaVideo;
    private SDPMediaApplication mediaApplication;

    public String parse(String sdp) {
	try {
	    String splitElement = LineUtils.getLineEndSuffix(sdp);
	    String[] lines = sdp.split(splitElement);
	    if (lines.length < 2) {
		throw new Exception();
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    private void parseSDPHeader(String line) {
	line = line.trim();
	if (line.startsWith("a")) {

	} else if (line.startsWith("o")) {

	} else if (line.startsWith("s")) {

	} else if (line.startsWith("v")) {

	} else if (line.startsWith("u")) {

	} else if (line.startsWith("e")) {

	} else if (line.startsWith("p")) {

	} else if (line.startsWith("v")) {

	} else if (line.startsWith("c")) {

	} else if (line.startsWith("b")) {

	} else if (line.startsWith("t")) {

	} else if (line.startsWith("r")) {

	} else if (line.startsWith("z")) {

	} else if (line.startsWith("k")) {

	} else if (line.startsWith("i")) {

	}
    }

}
