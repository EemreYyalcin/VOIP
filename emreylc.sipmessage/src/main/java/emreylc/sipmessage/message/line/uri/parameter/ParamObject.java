package emreylc.sipmessage.message.line.uri.parameter;

public class ParamObject {

    private boolean justNameParam = false;

    private String paramValue;

    private String paramName;

    public ParamObject(String paramValue) {
	setParamValue(paramValue);
    }

    public ParamObject() {
	setJustNameParam(true);
    }

    public boolean isJustNameParam() {
	return justNameParam;
    }

    public void setJustNameParam(boolean justNameParam) {
	this.justNameParam = justNameParam;
    }

    public String getParamValue() {
	return paramValue;
    }

    public void setParamValue(String paramValue) {
	this.paramValue = paramValue;
	setJustNameParam(false);
    }

    public String getParamName() {
	return paramName;
    }

    public void setParamName(String paramName) {
	this.paramName = paramName;
    }

    public static ParamObject createParamObj(String param) {
	int equalIndex = param.indexOf("=");
	ParamObject paramObj = null;
	if (equalIndex < 0) {
	    paramObj = new ParamObject();
	    paramObj.setParamName(param);
	} else {
	    String paramName = param.substring(0, equalIndex).trim();
	    String paramValue = param.substring(equalIndex + 1).trim();
	    paramObj = new ParamObject(paramValue);
	    paramObj.setParamName(paramName);
	}
	return paramObj;
    }

}
