package emreylc.sipmessage.message.authenticate.creditial;

import java.util.Properties;
import java.util.Set;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.parameter.ParamObject;

public class Challenge {

    private Properties params;

    public boolean errorParse = false;

    public Challenge(Properties params) {
	if (params == null) {
	    params = new Properties();
	}
	this.params = params;
    }

    public String parse(String message) {
	String originalMessage = message;
	try {
	    message = message.trim();
	    int digestIndex = message.indexOf("Digest");
	    if (digestIndex < 0) {
		throw new Exception();
	    }
	    message = message.substring(digestIndex + "Digest".length());
	    message = message.trim();
	    String[] parts = message.split(",");
	    if (parts.length < 1) {
		throw new Exception();
	    }
	    for (String part : parts) {
		ParamObject paramObj = ParamObject.createParamObj(part);
		if (paramObj == null) {
		    continue;
		}
		params.put(paramObj.getParamName(), paramObj);
	    }
	    return "";
	} catch (Exception e) {
	    TraceErrorLog.traceError(e, 5);
	    errorParse = true;
	    return originalMessage;
	}
    }

    @Override
    public String toString() {
	String headerValue = "Digest ";
	if (params == null) {
	    return null;
	}
	boolean isFirst = true;
	Set<Object> keys = params.keySet();
	for (Object key : keys) {
	    ParamObject paramObj = (ParamObject) params.get(key);
	    String tempValue = "";
	    if (paramObj.isJustNameParam()) {
		tempValue = key + "";
	    } else {
		tempValue = key + "=" + paramObj.getParamValue();
	    }
	    if (isFirst) {
		headerValue += tempValue;
		isFirst = false;
	    } else {
		headerValue += "; " + tempValue;
	    }
	}
	return headerValue;

    }

}
