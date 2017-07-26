package emreylc.sipmessage.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import emreylc.sipmessage.message.RequestMessage;
import emreylc.sipmessage.utils.CheckError;

public class Test {

    public static void main(String[] args) {
	try {
	    File file = new File("sipTest.txt");
	    // FileOutputStream fos = new FileOutputStream(file);
	    // fos.write("Test".getBytes());
	    // fos.close();
	    FileInputStream fis = new FileInputStream(file);
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
	    String sipMessage = getSipMessage(bufferedReader);
	    while (sipMessage != null) {
		RequestMessage requestMessage = new RequestMessage();
		requestMessage.parse(sipMessage);
		CheckError.checkBoolean(requestMessage.errorParse);
		sipMessage = getSipMessage(bufferedReader);
		System.out.println("RequestMessage: \r\n" + requestMessage.toString());
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    private static String getSipMessage(BufferedReader bufferedReader) throws IOException {
	String line = bufferedReader.readLine();
	if (line == null) {
	    return null;
	}
	if (!line.equals("<")) {
	    return null;
	}
	String message = "";
	while (true) {
	    line = bufferedReader.readLine();
	    if (line == null) {
		return null;
	    }
	    if (line.equals(">")) {
		return message;
	    }
	    message += line + "\r\n";
	}
    }

}
