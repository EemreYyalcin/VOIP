package emreylc.sipmessage.message.header;

import java.util.ArrayList;
import java.util.Properties;

import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.parameter.RouteParam;
import emreylc.sipmessage.utils.CheckError;

public class RecordRouteHeader extends SipMessageHeader {

    private ArrayList<RouteParam> recordRouteParamList;

    @Override
    public String parse(String message) {
	originalMessage = message;
	try {
	    message = message.trim();
	    recordRouteParamList = new ArrayList<RouteParam>();
	    String[] parts = message.split(",");
	    for (String part : parts) {
		part = part.trim();
		RouteParam routeParam = new RouteParam(new Properties());
		routeParam.parse(part);
		routeParam = (RouteParam) CheckError.checkBooleanWithoutException(routeParam.errorParse, routeParam);
		if (routeParam == null) {
		    continue;
		}
		recordRouteParamList.add(routeParam);
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
	String headerValue = "Record-Route: ";
	if (recordRouteParamList == null) {
	    return null;
	}
	for (int i = 0; i < recordRouteParamList.size(); ++i) {
	    RouteParam routeParam = recordRouteParamList.get(i);
	    if (++i == recordRouteParamList.size()) {
		headerValue = routeParam.toString();
	    } else {
		headerValue = routeParam.toString() + ",";
	    }
	}
	return headerValue;
    }

}
