package emreylc.sipmessage.message.header;

import java.util.Properties;
import java.util.Set;

import emreylc.sipmessage.message.line.uri.parameter.ParamObject;
import emreylc.sipmessage.utils.LineUtils;

public abstract class SipMessageHeader {

    public boolean errorParse = false;
    protected Properties params;
    protected String originalMessage;

    public abstract String parse(String message);

    protected String addParams(String message) throws Exception {
	int endParameterIndex = message.indexOf(";");
	do {
	    if (endParameterIndex == 0) {
		message = message.substring(1);
		endParameterIndex = message.indexOf(";");
	    }
	    if (endParameterIndex < 0) {
		endParameterIndex = LineUtils.getLineEndIndex(message);
		if (endParameterIndex == 0) {
		    return message;
		}
	    }
	    if (endParameterIndex < 0) {
		throw new Exception();
	    }
	    String param = message.substring(0, endParameterIndex).trim();
	    ParamObject paramObj = ParamObject.createParamObj(param);
	    if (paramObj == null) {
		continue;
	    }
	    setParameter(paramObj.getParamName(), paramObj);
	    message = message.substring(endParameterIndex);
	    endParameterIndex = message.indexOf(";");
	} while (true);
    }

    public void setParameter(String key, ParamObject paramObj) {
	if (key == null) {
	    return;
	}
	if (paramObj == null) {
	    return;
	}
	if (params == null) {
	    params = new Properties();
	}
	params.put(key, paramObj);
    }

    public ParamObject getParameter(String key) {
	if (key == null) {
	    return null;
	}
	if (params == null) {
	    return null;
	}

	return (ParamObject) params.get(key);

    }

    public String appendParameter() {
	String headerValue = "";
	if (params == null) {
	    return headerValue;
	}
	Set<Object> keys = params.keySet();
	for (Object key : keys) {
	    ParamObject paramObj = (ParamObject) params.get(key);
	    if (paramObj.isJustNameParam()) {
		headerValue += ";" + key;
	    } else {
		headerValue += ";" + key + "=" + paramObj.getParamValue();
	    }
	}
	return headerValue;
    }

}
