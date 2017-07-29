package emreylc.sipmessage.sdp;

import java.util.ArrayList;
import java.util.Arrays;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.Standarts;

public class SDPAttribute {

    private ArrayList<String> valueList;

    public boolean errorParse = false;

    public void parse(String line) {
	try {
	    String[] parts = line.split(Standarts.splitWhitespace);
	    if (parts.length < 1) {
		throw new Exception();
	    }
	    setValueList((ArrayList<String>) Arrays.asList(parts));
	} catch (Exception e) {
	    errorParse = true;
	}
    }

    @Override
    public String toString() {
	try {
	    if (valueList == null || valueList.size() == 0) {
		return null;
	    }
	    String value = "a=";
	    for (int i = 0; i < valueList.size(); i++) {
		value += valueList.get(i) + " ";
	    }
	    return value += Standarts.LF;
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 2);
	}

	return null;
    }

    public ArrayList<String> getValueList() {
	return valueList;
    }

    public void setValueList(ArrayList<String> valueList) {
	this.valueList = valueList;
    }

}
