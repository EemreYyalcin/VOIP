package emreylc.sipmessage.message;

import java.util.Properties;

public abstract class Message {

    private Properties headers;

    protected abstract String parse(String message);

    public abstract String toString();

    public boolean errorParse = false;

    protected String originalMessage;

}
