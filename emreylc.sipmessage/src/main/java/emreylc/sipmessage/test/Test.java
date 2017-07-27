package emreylc.sipmessage.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import emreylc.sipmessage.message.Message;
import emreylc.sipmessage.utils.CheckError;

public class Test {

    public static void main(String[] args) {
	try {
	    File file = new File("sipTest.txt");
	    File fileAppend = new File("sipTestAppend.txt");
	    FileOutputStream fos = new FileOutputStream(fileAppend);
	    FileInputStream fis = new FileInputStream(file);
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
	    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
	    String sipMessage = getSipMessage(bufferedReader);
	    while (sipMessage != null) {
		Message message = Message.createRequestOrResponseMessage(sipMessage);
		message.parse(sipMessage);
		CheckError.checkBoolean(message.errorParse);
		sipMessage = getSipMessage(bufferedReader);
		System.out.println("SipMessage: \r\n" + message.toString());
		bufferedWriter.write("<\n" + message.toString() + ">\n");
	    }
	    bufferedReader.close();
	    bufferedWriter.close();

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
