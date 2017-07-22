package emreylc.sipmessage.message.header.parameter;

import java.util.Properties;
import java.util.Set;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.line.uri.NameAddress;
import emreylc.sipmessage.message.line.uri.parameter.ParamObject;
import emreylc.sipmessage.utils.CheckError;

public class RouteParam {

    private NameAddress nameAddress;

    private Properties params;

    public boolean errorParse = false;

    public RouteParam(Properties params) {
	if (params == null) {
	    params = new Properties();
	}
	this.params = params;
    }

    public String parse(String message) {
	String originalMessage = message;
	try {
	    message = message.trim();
	    nameAddress = new NameAddress();
	    message = nameAddress.parse(message);
	    CheckError.checkBoolean(nameAddress.errorParse);
	    String[] parts = message.split(";");
	    if (parts.length < 1) {
		return "";
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
	String paramValue;
	if (nameAddress == null) {
	    return null;
	}
	paramValue = nameAddress.toString();
	boolean isFirst = true;
	Set<Object> keys = params.keySet();
	if (keys.size() == 0) {
	    return paramValue;
	}
	for (Object key : keys) {
	    ParamObject paramObj = (ParamObject) params.get(key);
	    String tempValue = "";
	    if (paramObj.isJustNameParam()) {
		tempValue = key + "";
	    } else {
		tempValue = key + "=" + paramObj.getParamValue();
	    }
	    if (isFirst) {
		paramValue += tempValue;
		isFirst = false;
	    } else {
		paramValue += ";" + tempValue;
	    }
	}
	return paramValue;
    }

}
