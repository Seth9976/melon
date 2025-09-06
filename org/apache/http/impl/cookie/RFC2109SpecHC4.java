package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class RFC2109SpecHC4 extends CookieSpecBaseHC4 {
    private static final String[] DATE_PATTERNS;
    private static final CookiePathComparator PATH_COMPARATOR;
    private final String[] datepatterns;
    private final boolean oneHeader;

    static {
        RFC2109SpecHC4.PATH_COMPARATOR = new CookiePathComparator();
        RFC2109SpecHC4.DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
    }

    public RFC2109SpecHC4() {
        this(null, false);
    }

    public RFC2109SpecHC4(String[] arr_s, boolean z) {
        this.datepatterns = arr_s == null ? RFC2109SpecHC4.DATE_PATTERNS : ((String[])arr_s.clone());
        this.oneHeader = z;
        this.registerAttribHandler("version", new RFC2109VersionHandlerHC4());
        this.registerAttribHandler("path", new BasicPathHandlerHC4());
        this.registerAttribHandler("domain", new RFC2109DomainHandlerHC4());
        this.registerAttribHandler("max-age", new BasicMaxAgeHandlerHC4());
        this.registerAttribHandler("secure", new BasicSecureHandlerHC4());
        this.registerAttribHandler("comment", new BasicCommentHandlerHC4());
        this.registerAttribHandler("expires", new BasicExpiresHandlerHC4(this.datepatterns));
    }

    private List doFormatManyHeaders(List list0) {
        List list1 = new ArrayList(list0.size());
        for(Object object0: list0) {
            int v = ((Cookie)object0).getVersion();
            CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(40);
            charArrayBuffer0.append("Cookie: ");
            charArrayBuffer0.append("$Version=");
            charArrayBuffer0.append(Integer.toString(v));
            charArrayBuffer0.append("; ");
            this.formatCookieAsVer(charArrayBuffer0, ((Cookie)object0), v);
            ((ArrayList)list1).add(new BufferedHeader(charArrayBuffer0));
        }
        return list1;
    }

    private List doFormatOneHeader(List list0) {
        int v = 0x7FFFFFFF;
        for(Object object0: list0) {
            Cookie cookie0 = (Cookie)object0;
            if(cookie0.getVersion() < v) {
                v = cookie0.getVersion();
            }
        }
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(list0.size() * 40);
        charArrayBuffer0.append("Cookie");
        charArrayBuffer0.append(": ");
        charArrayBuffer0.append("$Version=");
        charArrayBuffer0.append(Integer.toString(v));
        for(Object object1: list0) {
            charArrayBuffer0.append("; ");
            this.formatCookieAsVer(charArrayBuffer0, ((Cookie)object1), v);
        }
        List list1 = new ArrayList(1);
        ((ArrayList)list1).add(new BufferedHeader(charArrayBuffer0));
        return list1;
    }

    public void formatCookieAsVer(CharArrayBuffer charArrayBuffer0, Cookie cookie0, int v) {
        this.formatParamAsVer(charArrayBuffer0, cookie0.getName(), cookie0.getValue(), v);
        if(cookie0.getPath() != null && cookie0 instanceof ClientCookie && ((ClientCookie)cookie0).containsAttribute("path")) {
            charArrayBuffer0.append("; ");
            this.formatParamAsVer(charArrayBuffer0, "$Path", cookie0.getPath(), v);
        }
        if(cookie0.getDomain() != null && cookie0 instanceof ClientCookie && ((ClientCookie)cookie0).containsAttribute("domain")) {
            charArrayBuffer0.append("; ");
            this.formatParamAsVer(charArrayBuffer0, "$Domain", cookie0.getDomain(), v);
        }
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        Args.notEmpty(list0, "List of cookies");
        if(list0.size() > 1) {
            ArrayList arrayList0 = new ArrayList(list0);
            Collections.sort(arrayList0, RFC2109SpecHC4.PATH_COMPARATOR);
            list0 = arrayList0;
        }
        return this.oneHeader ? this.doFormatOneHeader(list0) : this.doFormatManyHeaders(list0);
    }

    public void formatParamAsVer(CharArrayBuffer charArrayBuffer0, String s, String s1, int v) {
        charArrayBuffer0.append(s);
        charArrayBuffer0.append("=");
        if(s1 != null) {
            if(v > 0) {
                charArrayBuffer0.append('\"');
                charArrayBuffer0.append(s1);
                charArrayBuffer0.append('\"');
                return;
            }
            charArrayBuffer0.append(s1);
        }
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 1;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        Args.notNull(header0, "Header");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(!header0.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header \'" + header0.toString() + "\'");
        }
        return this.parse(header0.getElements(), cookieOrigin0);
    }

    @Override
    public String toString() {
        return "rfc2109";
    }

    @Override  // org.apache.http.impl.cookie.CookieSpecBaseHC4
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        String s = cookie0.getName();
        if(s.indexOf(0x20) != -1) {
            throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
        }
        if(s.startsWith("$")) {
            throw new CookieRestrictionViolationException("Cookie name may not start with $");
        }
        super.validate(cookie0, cookieOrigin0);
    }
}

