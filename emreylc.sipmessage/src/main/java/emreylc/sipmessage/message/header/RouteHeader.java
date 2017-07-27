package emreylc.sipmessage.message.header;

import java.util.ArrayList;
import java.util.Properties;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.parameter.RouteParam;
import emreylc.sipmessage.utils.CheckError;

public class RouteHeader extends SipMessageHeader {

    private ArrayList<RouteParam> routeParamList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    routeParamList = new ArrayList<RouteParam>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		RouteParam routeParam = new RouteParam(new Properties());
		routeParam.parse(part);
		routeParam = (RouteParam) CheckError.checkBooleanWithoutException(routeParam.errorParse, routeParam);
		if (routeParam == null) {
		    continue;
		}
		routeParamList.add(routeParam);
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
	String headerValue = "Route: ";
	if (routeParamList == null) {
	    return null;
	}
	for (int i = 0; i < routeParamList.size(); ++i) {
	    RouteParam routeParam = routeParamList.get(i);
	    if (++i == routeParamList.size()) {
		headerValue += routeParam.toString();
	    } else {
		headerValue += routeParam.toString() + ",";
	    }
	}
	return headerValue;
    }

}
