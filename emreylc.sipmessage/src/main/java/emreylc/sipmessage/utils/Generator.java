package emreylc.sipmessage.utils;

import java.util.Random;
import java.util.UUID;

public class Generator {

    private static Random rand = new Random();

    public static int generateNum(int max) {
	return rand.nextInt(max);
    }

    public static int generateNum(int min, int max) {
	return rand.nextInt(max - min + 1) + min;
    }

    public static String generateUUID() {
	return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateBigNum() {
	String num = generateNum(1000, 9999) + "";
	num += generateNum(1000, 9999) + "";
	num += generateNum(10, 99);
	return num;
    }

}
