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
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class NetscapeDraftSpecHC4 extends CookieSpecBaseHC4 {
    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";
    private final String[] datepatterns;

    public NetscapeDraftSpecHC4() {
        this(null);
    }

    public NetscapeDraftSpecHC4(String[] arr_s) {
        this.datepatterns = arr_s == null ? new String[]{"EEE, dd-MMM-yy HH:mm:ss z"} : ((String[])arr_s.clone());
        this.registerAttribHandler("path", new BasicPathHandlerHC4());
        this.registerAttribHandler("domain", new NetscapeDomainHandlerHC4());
        this.registerAttribHandler("max-age", new BasicMaxAgeHandlerHC4());
        this.registerAttribHandler("secure", new BasicSecureHandlerHC4());
        this.registerAttribHandler("comment", new BasicCommentHandlerHC4());
        this.registerAttribHandler("expires", new BasicExpiresHandlerHC4(this.datepatterns));
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
            charArrayBuffer0.append(cookie0.getName());
            String s = cookie0.getValue();
            if(s != null) {
                charArrayBuffer0.append("=");
                charArrayBuffer0.append(s);
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

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(header0, "Header");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(!header0.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header \'" + header0.toString() + "\'");
        }
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

    @Override
    public String toString() {
        return "netscape";
    }
}

