package emreylc.sipmessage.code;

public class StatusCode {

    private int statusCode;

    public StatusCode(int statusCode) {
	setStatusCode(statusCode);
    }

    public int getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
    }

    public static int trying = 100;
    public static int ringing = 180;
    public static int callIsBeingForwarded = 181;
    public static int queued = 182;
    public static int sessionProgress = 183;
    public static int earlyDialogTerminated = 199;
    public static int ok = 200;
    public static int accepted = 202;
    public static int noNotification = 204;
    public static int multipleChoices = 300;
    public static int movedPermenently = 301;
    public static int movedTemporarly = 302;
    public static int useProxy = 305;
    public static int alternativeService = 380;

    public static int badRequest = 400;
    public static int unAuthorized = 401;
    public static int paymentRequired = 402;
    public static int forbidden = 403;
    public static int notFound = 404;
    public static int methodNotAllowed = 405;
    public static int notAcceptable = 406;
    public static int proxyAuthenticationRequired = 407;
    public static int requestTimeout = 408;
    public static int gone = 410;
    public static int conditionalRequestFailed = 412;
    public static int requestEntityTooLarge = 413;
    public static int requestUriTooLong = 414;
    public static int unsupportedMediaType = 415;
    public static int unsupportedUriScheme = 416;
    public static int unknownResourcePriority = 417;
    public static int badExtension = 420;
    public static int extensionRequired = 421;
    public static int sessionIntervalTooSmall = 422;
    public static int intervalTooBrief = 423;
    public static int badLocationInformation = 424;
    public static int useIdentityHeader = 428;
    public static int provideRefererIdentity = 429;
    public static int flowFailed = 430;
    public static int anonymityDisallowed = 433;
    public static int badIdentityInfo = 436;
    public static int unsupportedCertificate = 437;
    public static int invalidIdentityHeader = 438;
    public static int firstHopLacksOutboundSupport = 439;
    public static int maxBreadthExceed = 440;
    public static int badInfoPackage = 469;
    public static int consentNeeded = 470;
    public static int temporarilyUnavailable = 480;
    public static int callTransactionDoesNotExist = 481;
    public static int loopDetected = 482;
    public static int tooManyHops = 483;
    public static int addressIncomplete = 484;
    public static int ambigious = 485;
    public static int busyHere = 486;
    public static int requestTerminated = 487;
    public static int notAcceptableHere = 488;
    public static int badEvent = 489;
    public static int requestPending = 491;
    public static int undecipherable = 493;
    public static int securityAgreementRequired = 494;

    public static int serverInternalError = 500;
    public static int notImplemented = 501;
    public static int badGateway = 502;
    public static int serviceUnavailable = 503;
    public static int serverTimeout = 504;
    public static int versionNotSupported = 505;
    public static int messageTooLarge = 513;
    public static int preconditionFailure = 580;

    public static int busyEverywhere = 600;
    public static int decline = 603;
    public static int doesNotExistAnywhere = 604;

    public static String getStatusCodeName(int statusCode) {
	switch (statusCode) {
	case 100:
	    return "Trying";
	case 180:
	    return "Ringing";
	case 181:
	    return "Call Is Being Forwarded";
	case 182:
	    return "Queued";
	case 183:
	    return "Session Progress";
	case 199:
	    return "Early Dialog Terminated";
	case 200:
	    return "OK";
	case 202:
	    return "Accepted";
	case 204:
	    return "No Notification";
	case 300:
	    return "Multiple Choices";
	case 301:
	    return "Moved Permanently";
	case 302:
	    return "Moved Temporarily";
	case 305:
	    return "Use Proxy";
	case 380:
	    return "Alternative Service";
	case 400:
	    return "Bad Request";
	case 401:
	    return "Unauthorized";
	case 402:
	    return "Payment Required";
	case 403:
	    return "Forbidden";
	case 404:
	    return "Not Found";
	case 405:
	    return "Method Not Allowed";
	case 406:
	    return "Not Acceptable";
	case 407:
	    return "Proxy Authentication Required";
	case 408:
	    return "Request Timeout";
	case 410:
	    return "Gone";
	case 412:
	    return "Conditional Request Failed";
	case 413:
	    return "Request Entity Too Large";
	case 414:
	    return "Request-URI Too Long";
	case 415:
	    return "Unsupported Media Type";
	case 416:
	    return "Unsupported URI Scheme";
	case 417:
	    return "Unknown Resource-Priority";
	case 420:
	    return "Bad Extension";
	case 421:
	    return "Extension Required";
	case 422:
	    return "Session Interval Too Small";
	case 423:
	    return "Interval Too Brief";
	case 424:
	    return "Bad Location Information";
	case 428:
	    return "Use Identity Header";
	case 429:
	    return "Provide Referrer Identity";
	case 430:
	    return "Flow Failed";
	case 433:
	    return "Anonymity Disallowed";
	case 436:
	    return "Bad Identity-Info";
	case 437:
	    return "Unsupported Certificate";
	case 438:
	    return "Invalid Identity Header";
	case 439:
	    return "First Hop Lacks Outbound Support";
	case 440:
	    return "Max-Breadth Exceeded";
	case 469:
	    return "Bad Info Package";
	case 470:
	    return "Consent Needed";
	case 480:
	    return "Temporarily Unavailable";
	case 481:
	    return "Call/Transaction Does Not Exist";
	case 482:
	    return "Loop Detected";
	case 483:
	    return "Too Many Hops";
	case 484:
	    return "Address Incomplete";
	case 485:
	    return "Ambiguous";
	case 486:
	    return "Busy Here";
	case 487:
	    return "Request Terminated";
	case 488:
	    return "Not Acceptable Here";
	case 489:
	    return "Bad Event";
	case 491:
	    return "Request Pending";
	case 493:
	    return "Undecipherable";
	case 494:
	    return "Security Agreement Required";
	case 500:
	    return "Server Internal Error";
	case 501:
	    return "Not Implemented";
	case 502:
	    return "Bad Gateway";
	case 503:
	    return "Service Unavailable";
	case 504:
	    return "Server Time-out";
	case 505:
	    return "Version Not Supported";
	case 513:
	    return "Message Too Large";
	case 580:
	    return "Precondition Failure";
	case 600:
	    return "Busy Everywhere";
	case 603:
	    return "Decline";
	case 604:
	    return "Does Not Exist Anywhere";
	case 606:
	    return "Not Acceptable";

	default:
	    return "Bad Event";
	}
    }

}
