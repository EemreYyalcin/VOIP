package emreylc.sipmessage.message.line.uri.parameter;

import java.util.Properties;
import java.util.Set;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.utils.LineUtils;

public class UriParameter {

    private Properties params;
    public boolean errorParse = false;

    public String parse(String message) {

	String originalMessage = message;
	try {
	    int semiColonIndex = message.indexOf(";");
	    if (semiColonIndex < 0) {
		errorParse = true;
		return message;
	    }
	    message = message.substring(semiColonIndex + 1);
	    do {
		semiColonIndex = message.indexOf(";");
		if (semiColonIndex == 0) {
		    message = message.substring(semiColonIndex + 1);
		}
		message = addParams(message);
		if (semiColonIndex < 0) {
		    // Last Parameter
		    break;
		}
	    } while (true);
	} catch (Exception e) {
	    errorParse = true;
	    TraceErrorLog.traceError(e, 8);
	    return originalMessage;
	}
	return message;
    }

    private String addParams(String message) throws Exception {
	if (LineUtils.getLineEndIndex(message) == 0) {
	    return message;
	}
	int endParameterIndex = message.indexOf(";");
	if (endParameterIndex < 0) {
	    endParameterIndex = LineUtils.getLineEndIndex(message);
	}
	if (endParameterIndex < 0) {
	    throw new Exception();
	}
	if (params == null) {
	    params = new Properties();
	}
	String param = message.substring(0, endParameterIndex);
	int equalIndex = param.indexOf("=");
	if (equalIndex < 0) {
	    UriParam uriParam = UriParam.valueOf(param);
	    ParamObject paramObj = new ParamObject();
	    params.put(uriParam, paramObj);
	    return message.substring(endParameterIndex);
	}

	String paramName = param.substring(0, equalIndex);
	UriParam uriParam = UriParam.valueOf(paramName);
	String paramValue = param.substring(equalIndex + 1).trim();
	ParamObject paramObj = new ParamObject(paramValue);
	params.put(uriParam, paramObj);
	return message.substring(endParameterIndex);
    }

    public UriParameter setUriParameter(UriParam uriParam, String value) {
	if (uriParam == null) {
	    return this;
	}
	if (params == null) {
	    params = new Properties();
	}
	if (value == null) {
	    params.put(uriParam, new ParamObject());
	    return this;
	}
	params.put(uriParam, new ParamObject(value));
	return this;
    }

    public ParamObject getUriParamtere(UriParam uriParam) {
	if (uriParam == null) {
	    return null;
	}

	if (params == null) {
	    return null;
	}
	return (ParamObject) params.get(uriParam);
    }

    public String toString() {
	if (params == null) {
	    return null;
	}
	String uriParameters = "";
	Set<Object> keys = params.keySet();
	for (Object key : keys) {
	    ParamObject paramObj = (ParamObject) params.get(key);
	    if (paramObj.isJustNameParam()) {
		uriParameters += ";" + key;
	    } else {
		uriParameters += ";" + key + "=" + paramObj.getParamValue();
	    }
	}
	return uriParameters;

    }

    public enum UriParam {
	aai, alert, bnc, cause, ccxml, compression, dialog, gr, lr, maddr, maxage, maxstale, method, methodrequest, pname, postbody, target, text, transport, ttl, user
    }

    public static void main(String[] args) {
	UriParameter uriParamter;
	String message1 = ";transport=tcp\r\n";
	String message2 = ";maddr=239.255.255.1;ttl=15;lr\r\n";
	String message3 = ";target=bob%40example.com;cause=486\n";

	uriParamter = new UriParameter();
	System.out.println("message1:" + message1);
	message1 = uriParamter.parse(message1);
	System.out.println("message1:" + message1);
	System.out.println(uriParamter.toString());

	uriParamter = new UriParameter();
	System.out.println("message2:" + message2);
	message2 = uriParamter.parse(message2);
	System.out.println("message2:" + message2);
	System.out.println(uriParamter.toString());
	System.out.println(uriParamter.getUriParamtere(UriParam.ttl));
	System.out.println(uriParamter.getUriParamtere(UriParam.pname));

	uriParamter = new UriParameter();
	System.out.println("message3:" + message3);
	message3 = uriParamter.parse(message3);
	System.out.println("message3:" + message3);
	System.out.println(uriParamter.toString());

    }

}
