package emreylc.sipmessage.message.header.date;

public class SipDate {

    private WkDay wkday;
    private String day;
    private Month month;
    private String year;

    public enum WkDay {
	Mon, Tue, Wed, Thu, Fri, Sat, Sun
    }

    public enum Month {
	Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Oct, Nov, Dec
    }

}
