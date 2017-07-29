package emreylc.sipmessage.sdp;

import emreylc.sipmessage.utils.Standarts;

public class SDPCodec {

    private int num;
    private String name;

    public SDPCodec(int num) {
	setNum(num);
    }

    @Override
    public String toString() {
	String rtpMap = "a=rtpmap:";
	switch (getNum()) {
	case 0:
	    rtpMap += "0 PCMU/8000";
	    break;
	case 8:
	    rtpMap += "8 PCMA/8000";

	    break;
	case 4:
	    rtpMap += "4 G723/8000";
	    break;
	case 9:
	    rtpMap += "9 G722/8000";
	    break;
	case 18:
	    rtpMap += "9 G729/8000";
	    break;
	case 31:
	    rtpMap += "31 H261/90000";
	    break;
	case 32:
	    rtpMap += "32 MPV/90000";
	    break;
	case 97:
	    rtpMap += "97 ILBC/90000";
	    break;
	default:
	    return null;
	}
	return rtpMap += Standarts.LF;
    }

    public int getNum() {
	return num;
    }

    public void setNum(int num) {
	this.num = num;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
