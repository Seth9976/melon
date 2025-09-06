package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class BestMatchSpecHC4 implements CookieSpec {
    private BrowserCompatSpecHC4 compat;
    private final String[] datepatterns;
    private RFC2109SpecHC4 obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965SpecHC4 strict;

    public BestMatchSpecHC4() {
        this(null, false);
    }

    public BestMatchSpecHC4(String[] arr_s, boolean z) {
        this.datepatterns = arr_s == null ? null : ((String[])arr_s.clone());
        this.oneHeader = z;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        Args.notNull(list0, "List of cookies");
        int v = 0x7FFFFFFF;
        boolean z = true;
        for(Object object0: list0) {
            Cookie cookie0 = (Cookie)object0;
            if(!(cookie0 instanceof SetCookie2)) {
                z = false;
            }
            if(cookie0.getVersion() < v) {
                v = cookie0.getVersion();
            }
        }
        if(v > 0) {
            return z ? this.getStrict().formatCookies(list0) : this.getObsoleteStrict().formatCookies(list0);
        }
        return this.getCompat().formatCookies(list0);
    }

    private BrowserCompatSpecHC4 getCompat() {
        if(this.compat == null) {
            this.compat = new BrowserCompatSpecHC4(this.datepatterns);
        }
        return this.compat;
    }

    private RFC2109SpecHC4 getObsoleteStrict() {
        if(this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109SpecHC4(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private RFC2965SpecHC4 getStrict() {
        if(this.strict == null) {
            this.strict = new RFC2965SpecHC4(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return this.getStrict().getVersion();
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return this.getStrict().getVersionHeader();
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(cookie0.getVersion() > 0) {
            return cookie0 instanceof SetCookie2 ? this.getStrict().match(cookie0, cookieOrigin0) : this.getObsoleteStrict().match(cookie0, cookieOrigin0);
        }
        return this.getCompat().match(cookie0, cookieOrigin0);
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        ParserCursor parserCursor0;
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(header0, "Header");
        Args.notNull(cookieOrigin0, "Cookie origin");
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
        if(!z && z1) {
            return "Set-Cookie2".equals(header0.getName()) ? this.getStrict().parse(arr_headerElement, cookieOrigin0) : this.getObsoleteStrict().parse(arr_headerElement, cookieOrigin0);
        }
        NetscapeDraftHeaderParserHC4 netscapeDraftHeaderParserHC40 = NetscapeDraftHeaderParserHC4.DEFAULT;
        if(header0 instanceof FormattedHeader) {
            charArrayBuffer0 = ((FormattedHeader)header0).getBuffer();
            parserCursor0 = new ParserCursor(((FormattedHeader)header0).getValuePos(), charArrayBuffer0.length());
        }
        else {
            String s = header0.getValue();
            if(s == null) {
                throw new MalformedCookieException("Header value is null");
            }
            charArrayBuffer0 = new CharArrayBuffer(s.length());
            charArrayBuffer0.append(s);
            parserCursor0 = new ParserCursor(0, charArrayBuffer0.length());
        }
        HeaderElement[] arr_headerElement1 = {netscapeDraftHeaderParserHC40.parseHeader(charArrayBuffer0, parserCursor0)};
        return this.getCompat().parse(arr_headerElement1, cookieOrigin0);
    }

    @Override
    public String toString() {
        return "best-match";
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(cookie0.getVersion() > 0) {
            if(cookie0 instanceof SetCookie2) {
                this.getStrict().validate(cookie0, cookieOrigin0);
                return;
            }
            this.getObsoleteStrict().validate(cookie0, cookieOrigin0);
            return;
        }
        this.getCompat().validate(cookie0, cookieOrigin0);
    }
}

