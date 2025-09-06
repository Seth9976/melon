package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueFormatterHC4;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class BrowserCompatSpecHC4 extends CookieSpecBaseHC4 {
    private static final String[] DEFAULT_DATE_PATTERNS;
    private final String[] datepatterns;

    static {
        BrowserCompatSpecHC4.DEFAULT_DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    }

    public BrowserCompatSpecHC4() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecHC4(String[] arr_s) {
        this(arr_s, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecHC4(String[] arr_s, SecurityLevel browserCompatSpecFactoryHC4$SecurityLevel0) {
        this.datepatterns = arr_s == null ? BrowserCompatSpecHC4.DEFAULT_DATE_PATTERNS : ((String[])arr_s.clone());
        switch(org.apache.http.impl.cookie.BrowserCompatSpecHC4.2.$SwitchMap$org$apache$http$impl$cookie$BrowserCompatSpecFactoryHC4$SecurityLevel[browserCompatSpecFactoryHC4$SecurityLevel0.ordinal()]) {
            case 1: {
                this.registerAttribHandler("path", new BasicPathHandlerHC4());
                break;
            }
            case 2: {
                this.registerAttribHandler("path", new BasicPathHandlerHC4() {
                    @Override  // org.apache.http.impl.cookie.BasicPathHandlerHC4
                    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
                    }
                });
                break;
            }
            default: {
                throw new RuntimeException("Unknown security level");
            }
        }
        this.registerAttribHandler("domain", new BasicDomainHandlerHC4());
        this.registerAttribHandler("max-age", new BasicMaxAgeHandlerHC4());
        this.registerAttribHandler("secure", new BasicSecureHandlerHC4());
        this.registerAttribHandler("comment", new BasicCommentHandlerHC4());
        this.registerAttribHandler("expires", new BasicExpiresHandlerHC4(this.datepatterns));
        this.registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        Args.notEmpty(list0, "List of cookies");
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(list0.size() * 20);
        charArrayBuffer0.append("Cookie");
        charArrayBuffer0.append(": ");
        for(int v = 0; v < list0.size(); ++v) {
            Cookie cookie0 = (Cookie)list0.get(v);
            if(v > 0) {
                charArrayBuffer0.append("; ");
            }
            String s = cookie0.getName();
            String s1 = cookie0.getValue();
            if(cookie0.getVersion() <= 0 || BrowserCompatSpecHC4.isQuoteEnclosed(s1)) {
                charArrayBuffer0.append(s);
                charArrayBuffer0.append("=");
                if(s1 != null) {
                    charArrayBuffer0.append(s1);
                }
            }
            else {
                BasicHeaderElement basicHeaderElement0 = new BasicHeaderElement(s, s1);
                BasicHeaderValueFormatterHC4.INSTANCE.formatHeaderElement(charArrayBuffer0, basicHeaderElement0, false);
            }
        }
        List list1 = new ArrayList(1);
        ((ArrayList)list1).add(new BufferedHeader(charArrayBuffer0));
        return list1;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    // 去混淆评级： 低(20)
    private static boolean isQuoteEnclosed(String s) {
        return s != null && s.startsWith("\"") && s.endsWith("\"");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(header0, "Header");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(!header0.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header \'" + header0.toString() + "\'");
        }
        HeaderElement[] arr_headerElement = header0.getElements();
        boolean z = false;
        boolean z1 = false;
        for(int v = 0; v < arr_headerElement.length; ++v) {
            HeaderElement headerElement0 = arr_headerElement[v];
            if(headerElement0.getParameterByName("version") != null) {
                z1 = true;
            }
            if(headerElement0.getParameterByName("expires") != null) {
                z = true;
            }
        }
        if(z || !z1) {
            NetscapeDraftHeaderParserHC4 netscapeDraftHeaderParserHC40 = NetscapeDraftHeaderParserHC4.DEFAULT;
            if(header0 instanceof FormattedHeader) {
                charArrayBuffer0 = ((FormattedHeader)header0).getBuffer();
                return this.parse(new HeaderElement[]{netscapeDraftHeaderParserHC40.parseHeader(charArrayBuffer0, new ParserCursor(((FormattedHeader)header0).getValuePos(), charArrayBuffer0.length()))}, cookieOrigin0);
            }
            String s = header0.getValue();
            if(s == null) {
                throw new MalformedCookieException("Header value is null");
            }
            charArrayBuffer0 = new CharArrayBuffer(s.length());
            charArrayBuffer0.append(s);
            return this.parse(new HeaderElement[]{netscapeDraftHeaderParserHC40.parseHeader(charArrayBuffer0, new ParserCursor(0, charArrayBuffer0.length()))}, cookieOrigin0);
        }
        return this.parse(arr_headerElement, cookieOrigin0);
    }

    @Override
    public String toString() {
        return "compatibility";
    }
}

