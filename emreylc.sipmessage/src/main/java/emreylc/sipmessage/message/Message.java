package emreylc.sipmessage.message;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import emreylc.sipmessage.log.LogMessage;
import emreylc.sipmessage.log.TraceErrorLog;
import emreylc.sipmessage.message.header.AcceptContactHeader;
import emreylc.sipmessage.message.header.AcceptEncodingHeader;
import emreylc.sipmessage.message.header.AcceptHeader;
import emreylc.sipmessage.message.header.AcceptLanguageHeader;
import emreylc.sipmessage.message.header.AcceptResourcePriorityHeader;
import emreylc.sipmessage.message.header.AllowEventHeader;
import emreylc.sipmessage.message.header.AllowHeader;
import emreylc.sipmessage.message.header.AnswerModeHeader;
import emreylc.sipmessage.message.header.AuthenticationInfoHeader;
import emreylc.sipmessage.message.header.AuthorizationHeader;
import emreylc.sipmessage.message.header.CallIDHeader;
import emreylc.sipmessage.message.header.CallInfoHeader;
import emreylc.sipmessage.message.header.ContactHeader;
import emreylc.sipmessage.message.header.ContentLengthHeader;
import emreylc.sipmessage.message.header.ContentTypeHeader;
import emreylc.sipmessage.message.header.CseqHeader;
import emreylc.sipmessage.message.header.DateHeader;
import emreylc.sipmessage.message.header.ErrorInfoHeader;
import emreylc.sipmessage.message.header.EventHeader;
import emreylc.sipmessage.message.header.ExpiresHeader;
import emreylc.sipmessage.message.header.FeatureCapsHeader;
import emreylc.sipmessage.message.header.FlowTimerHeader;
import emreylc.sipmessage.message.header.FromHeader;
import emreylc.sipmessage.message.header.GeolocationErrorHeader;
import emreylc.sipmessage.message.header.GeolocationHeader;
import emreylc.sipmessage.message.header.GeolocationRoutingHeader;
import emreylc.sipmessage.message.header.HistoryInfoHeader;
import emreylc.sipmessage.message.header.IdentityHeader;
import emreylc.sipmessage.message.header.IdentityInfoHeader;
import emreylc.sipmessage.message.header.InReplyToHeader;
import emreylc.sipmessage.message.header.InfoPackageHeader;
import emreylc.sipmessage.message.header.JoinHeader;
import emreylc.sipmessage.message.header.MaxBreadthHeader;
import emreylc.sipmessage.message.header.MaxForwardsHeader;
import emreylc.sipmessage.message.header.MimeVersionHeader;
import emreylc.sipmessage.message.header.MinExpiresHeader;
import emreylc.sipmessage.message.header.MinSEHeader;
import emreylc.sipmessage.message.header.OrganizationHeader;
import emreylc.sipmessage.message.header.PathHeader;
import emreylc.sipmessage.message.header.PermissionMissingHeader;
import emreylc.sipmessage.message.header.PolicyContactHeader;
import emreylc.sipmessage.message.header.PolicyIDHeader;
import emreylc.sipmessage.message.header.PriorityHeader;
import emreylc.sipmessage.message.header.PrivAnswerModeHeader;
import emreylc.sipmessage.message.header.PrivacyHeader;
import emreylc.sipmessage.message.header.ProxyAuthenticateHeader;
import emreylc.sipmessage.message.header.ProxyAuthorizationHeader;
import emreylc.sipmessage.message.header.ProxyRequireHeader;
import emreylc.sipmessage.message.header.RAckHeader;
import emreylc.sipmessage.message.header.RSeqHeader;
import emreylc.sipmessage.message.header.ReasonHeader;
import emreylc.sipmessage.message.header.RecordRouteHeader;
import emreylc.sipmessage.message.header.RecvInfoHeader;
import emreylc.sipmessage.message.header.ReferEventsAtHeader;
import emreylc.sipmessage.message.header.ReferSubHeader;
import emreylc.sipmessage.message.header.ReferToHeader;
import emreylc.sipmessage.message.header.ReferedByHeader;
import emreylc.sipmessage.message.header.RejectContactHeader;
import emreylc.sipmessage.message.header.ReplacesHeader;
import emreylc.sipmessage.message.header.ReplyToHeader;
import emreylc.sipmessage.message.header.RequestDispositionHeader;
import emreylc.sipmessage.message.header.RequireHeader;
import emreylc.sipmessage.message.header.ResourcePriorityHeader;
import emreylc.sipmessage.message.header.RetryAfterHeader;
import emreylc.sipmessage.message.header.RouteHeader;
import emreylc.sipmessage.message.header.SecurityClientHeader;
import emreylc.sipmessage.message.header.SecurityServerHeader;
import emreylc.sipmessage.message.header.SecurityVerifyHeader;
import emreylc.sipmessage.message.header.ServerHeader;
import emreylc.sipmessage.message.header.ServiceRouteHeader;
import emreylc.sipmessage.message.header.SessionExpiresHeader;
import emreylc.sipmessage.message.header.SessionIDHeader;
import emreylc.sipmessage.message.header.SipETagHeader;
import emreylc.sipmessage.message.header.SipIfMachHeader;
import emreylc.sipmessage.message.header.SipMessageHeader;
import emreylc.sipmessage.message.header.SubjectHeader;
import emreylc.sipmessage.message.header.SubscriptionStateHeader;
import emreylc.sipmessage.message.header.SupportedHeader;
import emreylc.sipmessage.message.header.SuppressIfMatchHeader;
import emreylc.sipmessage.message.header.TargetDialogHeader;
import emreylc.sipmessage.message.header.TimestampHeader;
import emreylc.sipmessage.message.header.ToHeader;
import emreylc.sipmessage.message.header.TriggerConsentHeader;
import emreylc.sipmessage.message.header.UnsupportedHeader;
import emreylc.sipmessage.message.header.UserAgentHeader;
import emreylc.sipmessage.message.header.UserToUserHeader;
import emreylc.sipmessage.message.header.ViaHeader;
import emreylc.sipmessage.message.header.WWWAuthenticateHeader;
import emreylc.sipmessage.message.header.WarningHeader;
import emreylc.sipmessage.message.header.pheader.PAccessNetworkInfoHeader;
import emreylc.sipmessage.message.header.pheader.PAnswerStateHeader;
import emreylc.sipmessage.message.header.pheader.PAssertedIdentityHeader;
import emreylc.sipmessage.message.header.pheader.PAssertedServiceHeader;
import emreylc.sipmessage.message.header.pheader.PAssociatedURIHeader;
import emreylc.sipmessage.message.header.pheader.PCalledPartyIDHeader;
import emreylc.sipmessage.message.header.pheader.PChargingFunctionAddressesHeader;
import emreylc.sipmessage.message.header.pheader.PChargingVectorHeader;
import emreylc.sipmessage.message.header.pheader.PDCSBillingInfoHeader;
import emreylc.sipmessage.message.header.pheader.PDCSLAESHeader;
import emreylc.sipmessage.message.header.pheader.PDCSOSPSHeader;
import emreylc.sipmessage.message.header.pheader.PDCSRedirectHeader;
import emreylc.sipmessage.message.header.pheader.PDCSTracePartIDHeader;
import emreylc.sipmessage.message.header.pheader.PEarlyMediaHeader;
import emreylc.sipmessage.message.header.pheader.PMediaAuthorizationHeader;
import emreylc.sipmessage.message.header.pheader.PPreferredIdentityHeader;
import emreylc.sipmessage.message.header.pheader.PPrefferedServiceHeader;
import emreylc.sipmessage.message.header.pheader.PPrivateNetworkIndicationHeader;
import emreylc.sipmessage.message.header.pheader.PProfileKeyHeader;
import emreylc.sipmessage.message.header.pheader.PRefusedURIListHeader;
import emreylc.sipmessage.message.header.pheader.PServedUserHeader;
import emreylc.sipmessage.message.header.pheader.PUserDatabaseHeader;
import emreylc.sipmessage.message.header.pheader.PVisitedNetworkIDHeader;
import emreylc.sipmessage.utils.CheckError;
import emreylc.sipmessage.utils.Standarts;

public abstract class Message {

    private Properties headers = new Properties();

    public abstract String parse(String message);

    public void parseLine(String[] lines) {
	for (int i = 1; i < lines.length; i++) {
	    try {
		parseHeader(lines[i]);
	    } catch (Exception e) {
		TraceErrorLog.traceError(e, 1);
		errorParse = true;
		LogMessage.error("Parsing Error " + lines[i]);
	    }
	}
    };

    private ArrayList<ViaHeader> viaHeaderList;
    private FromHeader fromHeader;
    private ToHeader toHeader;
    private CseqHeader cseqHeader;
    private ExpiresHeader expiresHeader;
    private ContactHeader contactHeader;
    private ContentLengthHeader contentLengthHeader;
    private CallIDHeader callIdHeader;
    private ContentTypeHeader contentTypeHeader;

    public String toString() {
	String message = "";
	Set<Object> keys = headers.keySet();
	if (keys == null) {
	    return message;
	}
	if (viaHeaderList != null) {
	    for (int i = 0; i < viaHeaderList.size(); i++) {
		message += appendHeaderToString(viaHeaderList.get(i));
	    }
	}
	message += appendHeaderToString(fromHeader);
	message += appendHeaderToString(toHeader);
	message += appendHeaderToString(cseqHeader);
	message += appendHeaderToString(expiresHeader);
	message += appendHeaderToString(callIdHeader);
	message += appendHeaderToString(contactHeader);
	for (Object key : keys) {
	    SipMessageHeader sipMessageHeader = (SipMessageHeader) headers.get(key);
	    message += sipMessageHeader.toString() + Standarts.CRLF;
	}
	message += appendHeaderToString(contentTypeHeader);
	message += appendHeaderToString(contentLengthHeader);
	return message;
    }

    private String appendHeaderToString(SipMessageHeader sipMessageHeader) {
	if (sipMessageHeader == null) {
	    return "";
	}
	return sipMessageHeader.toString() + Standarts.CRLF;
    }

    public boolean errorParse = false;

    protected String originalMessage;

    protected void parseHeader(String line) throws Exception {
	String[] parts = line.split(":");
	if (parts.length < 2) {
	    throw new Exception();
	}
	String headerName = parts[0].trim();
	String headerValue = line.substring(line.indexOf(parts[1])).trim();
	SipMessageHeader header = null;

	if (headerName.equalsIgnoreCase("From")) {
	    setFromHeader(new FromHeader());
	    header = getFromHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("To")) {
	    setToHeader(new ToHeader());
	    header = getToHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Via")) {
	    header = new ViaHeader();
	    addViaParameter((ViaHeader) header);
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Cseq")) {
	    setCseqHeader(new CseqHeader());
	    header = getCseqHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Call-ID")) {
	    setCallIdHeader(new CallIDHeader());
	    header = getCallIdHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Allow")) {
	    header = new AllowHeader();
	} else if (headerName.equalsIgnoreCase("Expires")) {
	    setExpiresHeader(new ExpiresHeader());
	    header = getExpiresHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("User-Agent")) {
	    header = new UserAgentHeader();
	} else if (headerName.equalsIgnoreCase("Contact")) {
	    setContactHeader(new ContactHeader());
	    header = getContactHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Content-Length")) {
	    setContentLengthHeader(new ContentLengthHeader());
	    header = getContentLengthHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("Max-Forwards")) {
	    header = new MaxForwardsHeader();
	} else if (headerName.equalsIgnoreCase("Content-Type")) {
	    setContentTypeHeader(new ContentTypeHeader());
	    header = getContentTypeHeader();
	    header.parse(headerValue);
	    CheckError.checkBoolean(header.errorParse);
	    return;
	} else if (headerName.equalsIgnoreCase("WWW-Authenticate")) {
	    header = new WWWAuthenticateHeader();
	} else if (headerName.equalsIgnoreCase("Route")) {
	    header = new RouteHeader();
	} else if (headerName.equalsIgnoreCase("Refer-To")) {
	    header = new ReferToHeader();
	} else if (headerName.equalsIgnoreCase("Proxy-Authenticate")) {
	    header = new ProxyAuthenticateHeader();
	} else if (headerName.equalsIgnoreCase("Accept")) {
	    header = new AcceptHeader();
	} else if (headerName.equalsIgnoreCase("Accept-Contact")) {
	    header = new AcceptContactHeader();
	} else if (headerName.equalsIgnoreCase("Reply-To")) {
	    header = new ReplyToHeader();
	} else if (headerName.equalsIgnoreCase("Accept-Language")) {
	    header = new AcceptLanguageHeader();
	} else if (headerName.equalsIgnoreCase("Accept-Resource-Priority")) {
	    header = new AcceptResourcePriorityHeader();
	} else if (headerName.equalsIgnoreCase("Authorization")) {
	    header = new AuthorizationHeader();
	} else if (headerName.equalsIgnoreCase("Alert-Info")) {
	    header = null;
	} else if (headerName.equalsIgnoreCase("Allow-Events")) {
	    header = new AllowEventHeader();
	} else if (headerName.equalsIgnoreCase("Answer-Mode")) {
	    header = new AnswerModeHeader();
	} else if (headerName.equalsIgnoreCase("Authentication-Info")) {
	    header = new AuthenticationInfoHeader();
	} else if (headerName.equalsIgnoreCase("Call-Info")) {
	    header = new CallInfoHeader();
	} else if (headerName.equalsIgnoreCase("Date")) {
	    header = new DateHeader();
	} else if (headerName.equalsIgnoreCase("Error-Info")) {
	    header = new ErrorInfoHeader();
	} else if (headerName.equalsIgnoreCase("Event")) {
	    header = new EventHeader();
	} else if (headerName.equalsIgnoreCase("Feature-Caps")) {
	    header = new FeatureCapsHeader();
	} else if (headerName.equalsIgnoreCase("Flow-Timer")) {
	    header = new FlowTimerHeader();
	} else if (headerName.equalsIgnoreCase("Geolocation")) {
	    header = new GeolocationHeader();
	} else if (headerName.equalsIgnoreCase("Geolocation-Error")) {
	    header = new GeolocationErrorHeader();
	} else if (headerName.equalsIgnoreCase("Geolocation-Routing")) {
	    header = new GeolocationRoutingHeader();
	} else if (headerName.equalsIgnoreCase("History-Info")) {
	    header = new HistoryInfoHeader();
	} else if (headerName.equalsIgnoreCase("Identity")) {
	    header = new IdentityHeader();
	} else if (headerName.equalsIgnoreCase("Identity-Info")) {
	    header = new IdentityInfoHeader();
	} else if (headerName.equalsIgnoreCase("Info-Package")) {
	    header = new InfoPackageHeader();
	} else if (headerName.equalsIgnoreCase("In-Reply-To")) {
	    header = new InReplyToHeader();
	} else if (headerName.equalsIgnoreCase("Join")) {
	    header = new JoinHeader();
	} else if (headerName.equalsIgnoreCase("Max-Breadth")) {
	    header = new MaxBreadthHeader();
	} else if (headerName.equalsIgnoreCase("Max-Forwards")) {
	    header = new MaxForwardsHeader();
	} else if (headerName.equalsIgnoreCase("MIME-Version")) {
	    header = new MimeVersionHeader();
	} else if (headerName.equalsIgnoreCase("Min-Expires")) {
	    header = new MinExpiresHeader();
	} else if (headerName.equalsIgnoreCase("Min-SE")) {
	    header = new MinSEHeader();
	} else if (headerName.equalsIgnoreCase("Organization")) {
	    header = new OrganizationHeader();
	} else if (headerName.equalsIgnoreCase("Path")) {
	    header = new PathHeader();
	} else if (headerName.equalsIgnoreCase("Permission-Missing")) {
	    header = new PermissionMissingHeader();
	} else if (headerName.equalsIgnoreCase("Policy-Contact")) {
	    header = new PolicyContactHeader();
	} else if (headerName.equalsIgnoreCase("Policy-ID")) {
	    header = new PolicyIDHeader();
	} else if (headerName.equalsIgnoreCase("Priority")) {
	    header = new PriorityHeader();
	} else if (headerName.equalsIgnoreCase("Privacy")) {
	    header = new PrivacyHeader();
	} else if (headerName.equalsIgnoreCase("Priv-Answer-Mode")) {
	    header = new PrivAnswerModeHeader();
	} else if (headerName.equalsIgnoreCase("Proxy-Authorization")) {
	    header = new ProxyAuthorizationHeader();
	} else if (headerName.equalsIgnoreCase("Accept-Encoding")) {
	    header = new AcceptEncodingHeader();
	} else if (headerName.equalsIgnoreCase("Proxy-Require")) {
	    header = new ProxyRequireHeader();
	} else if (headerName.equalsIgnoreCase("RAck")) {
	    header = new RAckHeader();
	} else if (headerName.equalsIgnoreCase("Reason")) {
	    header = new ReasonHeader();
	} else if (headerName.equalsIgnoreCase("Record-Route")) {
	    header = new RecordRouteHeader();
	} else if (headerName.equalsIgnoreCase("Recv-Info")) {
	    header = new RecvInfoHeader();
	} else if (headerName.equalsIgnoreCase("Refer-Events-At")) {
	    header = new ReferEventsAtHeader();
	} else if (headerName.equalsIgnoreCase("Refer-Sub")) {
	    header = new ReferSubHeader();
	} else if (headerName.equalsIgnoreCase("Referred-By")) {
	    header = new ReferedByHeader();
	} else if (headerName.equalsIgnoreCase("Reject-Contact")) {
	    header = new RejectContactHeader();
	} else if (headerName.equalsIgnoreCase("Replaces")) {
	    header = new ReplacesHeader();
	} else if (headerName.equalsIgnoreCase("Request-Disposition")) {
	    header = new RequestDispositionHeader();
	} else if (headerName.equalsIgnoreCase("Require")) {
	    header = new RequireHeader();
	} else if (headerName.equalsIgnoreCase("Resource-Priority")) {
	    header = new ResourcePriorityHeader();
	} else if (headerName.equalsIgnoreCase("Retry-After")) {
	    header = new RetryAfterHeader();
	} else if (headerName.equalsIgnoreCase("RSeq")) {
	    header = new RSeqHeader();
	} else if (headerName.equalsIgnoreCase("Security-Client")) {
	    header = new SecurityClientHeader();
	} else if (headerName.equalsIgnoreCase("Security-Server")) {
	    header = new SecurityServerHeader();
	} else if (headerName.equalsIgnoreCase("Security-Verify")) {
	    header = new SecurityVerifyHeader();
	} else if (headerName.equalsIgnoreCase("Server")) {
	    header = new ServerHeader();
	} else if (headerName.equalsIgnoreCase("Service-Route")) {
	    header = new ServiceRouteHeader();
	} else if (headerName.equalsIgnoreCase("Session-Expires")) {
	    header = new SessionExpiresHeader();
	} else if (headerName.equalsIgnoreCase("Session-ID")) {
	    header = new SessionIDHeader();
	} else if (headerName.equalsIgnoreCase("SIP-ETag")) {
	    header = new SipETagHeader();
	} else if (headerName.equalsIgnoreCase("SIP-If-Match")) {
	    header = new SipIfMachHeader();
	} else if (headerName.equalsIgnoreCase("Subject")) {
	    header = new SubjectHeader();
	} else if (headerName.equalsIgnoreCase("Subscription-State")) {
	    header = new SubscriptionStateHeader();
	} else if (headerName.equalsIgnoreCase("Supported")) {
	    header = new SupportedHeader();
	} else if (headerName.equalsIgnoreCase("Suppress-If-Match")) {
	    header = new SuppressIfMatchHeader();
	} else if (headerName.equalsIgnoreCase("Target-Dialog")) {
	    header = new TargetDialogHeader();
	} else if (headerName.equalsIgnoreCase("Timestamp")) {
	    header = new TimestampHeader();
	} else if (headerName.equalsIgnoreCase("Trigger-Consent")) {
	    header = new TriggerConsentHeader();
	} else if (headerName.equalsIgnoreCase("Unsupported")) {
	    header = new UnsupportedHeader();
	} else if (headerName.equalsIgnoreCase("User-to-User")) {
	    header = new UserToUserHeader();
	} else if (headerName.equalsIgnoreCase("Warning")) {
	    header = new WarningHeader();
	} else if (headerName.equalsIgnoreCase("P-Asserted-Identity")) {
	    header = new PAssertedIdentityHeader();
	} else if (headerName.equalsIgnoreCase("P-Asserted-Service")) {
	    header = new PAssertedServiceHeader();
	} else if (headerName.equalsIgnoreCase("P-Answer-State")) {
	    header = new PAnswerStateHeader();
	} else if (headerName.equalsIgnoreCase("P-Access-Network-Info")) {
	    header = new PAccessNetworkInfoHeader();
	} else if (headerName.equalsIgnoreCase("P-Associated-URI")) {
	    header = new PAssociatedURIHeader();
	} else if (headerName.equalsIgnoreCase("P-Called-Party-ID")) {
	    header = new PCalledPartyIDHeader();
	} else if (headerName.equalsIgnoreCase("P-Charging-Function-Addresses")) {
	    header = new PChargingFunctionAddressesHeader();
	} else if (headerName.equalsIgnoreCase("P-Charging-Vector")) {
	    header = new PChargingVectorHeader();
	} else if (headerName.equalsIgnoreCase("P-DCS-Billing-Info")) {
	    header = new PDCSBillingInfoHeader();
	} else if (headerName.equalsIgnoreCase("P-DCS-LAES")) {
	    header = new PDCSLAESHeader();
	} else if (headerName.equalsIgnoreCase("P-DCS-OSPS")) {
	    header = new PDCSOSPSHeader();
	} else if (headerName.equalsIgnoreCase("P-DCS-Redirect")) {
	    header = new PDCSRedirectHeader();
	} else if (headerName.equalsIgnoreCase("P-DCS-Trace-Party-ID")) {
	    header = new PDCSTracePartIDHeader();
	} else if (headerName.equalsIgnoreCase("P-Early-Media")) {
	    header = new PEarlyMediaHeader();
	} else if (headerName.equalsIgnoreCase("P-Media-Authorization")) {
	    header = new PMediaAuthorizationHeader();
	} else if (headerName.equalsIgnoreCase("P-Prefered-Identity")) {
	    header = new PPreferredIdentityHeader();
	} else if (headerName.equalsIgnoreCase("P-Prefered-Service")) {
	    header = new PPrefferedServiceHeader();
	} else if (headerName.equalsIgnoreCase("P-Private-Network-Indication")) {
	    header = new PPrivateNetworkIndicationHeader();
	} else if (headerName.equalsIgnoreCase("P-Profile-Key")) {
	    header = new PProfileKeyHeader();
	} else if (headerName.equalsIgnoreCase("P-Refused-URI-List")) {
	    header = new PRefusedURIListHeader();
	} else if (headerName.equalsIgnoreCase("P-Served-User")) {
	    header = new PServedUserHeader();
	} else if (headerName.equalsIgnoreCase("P-User-Database")) {
	    header = new PUserDatabaseHeader();
	} else if (headerName.equalsIgnoreCase("P-Visited-Network-ID")) {
	    header = new PVisitedNetworkIDHeader();
	} else {
	    header = null;
	    throw new Exception();
	}
	header.parse(headerValue);
	CheckError.checkBoolean(header.errorParse);
	headers.put(headerName.toLowerCase(), header);
    }

    public Properties getHeaders() {
	return headers;
    }

    public void addViaParameter(ViaHeader viaHeader) {
	if (viaHeaderList == null) {
	    viaHeaderList = new ArrayList<ViaHeader>();
	}
	viaHeaderList.add(viaHeader);
    }

    public ViaHeader getViaHeader(int index) {
	if (viaHeaderList == null) {
	    return null;
	}
	return viaHeaderList.get(index);
    }

    public void setHeaders(Properties headers) {
	this.headers = headers;
    }

    public FromHeader getFromHeader() {
	return fromHeader;
    }

    public void setFromHeader(FromHeader fromHeader) {
	this.fromHeader = fromHeader;
    }

    public ToHeader getToHeader() {
	return toHeader;
    }

    public void setToHeader(ToHeader toHeader) {
	this.toHeader = toHeader;
    }

    public CseqHeader getCseqHeader() {
	return cseqHeader;
    }

    public void setCseqHeader(CseqHeader cseqHeader) {
	this.cseqHeader = cseqHeader;
    }

    public ExpiresHeader getExpiresHeader() {
	return expiresHeader;
    }

    public void setExpiresHeader(ExpiresHeader expiresHeader) {
	this.expiresHeader = expiresHeader;
    }

    public ContactHeader getContactHeader() {
	return contactHeader;
    }

    public void setContactHeader(ContactHeader contactHeader) {
	this.contactHeader = contactHeader;
    }

    public ContentLengthHeader getContentLengthHeader() {
	return contentLengthHeader;
    }

    public void setContentLengthHeader(ContentLengthHeader contentLengthHeader) {
	this.contentLengthHeader = contentLengthHeader;
    }

    public CallIDHeader getCallIdHeader() {
	return callIdHeader;
    }

    public void setCallIdHeader(CallIDHeader callIdHeader) {
	this.callIdHeader = callIdHeader;
    }

    public ContentTypeHeader getContentTypeHeader() {
	return contentTypeHeader;
    }

    public void setContentTypeHeader(ContentTypeHeader contentTypeHeader) {
	this.contentTypeHeader = contentTypeHeader;
    }

    public boolean isErrorParse() {
	return errorParse;
    }

    public void setErrorParse(boolean errorParse) {
	this.errorParse = errorParse;
    }

    public String getOriginalMessage() {
	return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
	this.originalMessage = originalMessage;
    }

    public static Message createRequestOrResponseMessage(String message) {
	if (message.trim().startsWith("SIP/2.0")) {
	    return new ResponseMessage();
	}
	return new RequestMessage();
    }

}
