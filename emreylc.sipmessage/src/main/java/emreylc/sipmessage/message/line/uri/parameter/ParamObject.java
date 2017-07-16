package emreylc.sipmessage.message.line.uri.parameter;

public class ParamObject {

    private boolean justNameParam = false;

    private String paramValue;

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

}
