package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class RFC2965SpecHC4 extends RFC2109SpecHC4 {
    public RFC2965SpecHC4() {
        this(null, false);
    }

    public RFC2965SpecHC4(String[] arr_s, boolean z) {
        super(arr_s, z);
        this.registerAttribHandler("domain", new RFC2965DomainAttributeHandlerHC4());
        this.registerAttribHandler("port", new RFC2965PortAttributeHandlerHC4());
        this.registerAttribHandler("commenturl", new RFC2965CommentUrlAttributeHandlerHC4());
        this.registerAttribHandler("discard", new RFC2965DiscardAttributeHandlerHC4());
        this.registerAttribHandler("version", new RFC2965VersionAttributeHandlerHC4());
    }

    private static CookieOrigin adjustEffectiveHost(CookieOrigin cookieOrigin0) {
        String s = cookieOrigin0.getHost();
        int v = 0;
        while(v < s.length()) {
            if(s.charAt(v) != 46 && s.charAt(v) != 58) {
                ++v;
                continue;
            }
            return cookieOrigin0;
        }
        return new CookieOrigin(s + ".local", cookieOrigin0.getPort(), cookieOrigin0.getPath(), cookieOrigin0.isSecure());
    }

    private List createCookies(HeaderElement[] arr_headerElement, CookieOrigin cookieOrigin0) {
        List list0 = new ArrayList(arr_headerElement.length);
        for(int v = 0; v < arr_headerElement.length; ++v) {
            HeaderElement headerElement0 = arr_headerElement[v];
            String s = headerElement0.getName();
            String s1 = headerElement0.getValue();
            if(s == null || s.length() == 0) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            BasicClientCookie2HC4 basicClientCookie2HC40 = new BasicClientCookie2HC4(s, s1);
            basicClientCookie2HC40.setPath(CookieSpecBaseHC4.getDefaultPath(cookieOrigin0));
            basicClientCookie2HC40.setDomain(CookieSpecBaseHC4.getDefaultDomain(cookieOrigin0));
            basicClientCookie2HC40.setPorts(new int[]{cookieOrigin0.getPort()});
            NameValuePair[] arr_nameValuePair = headerElement0.getParameters();
            HashMap hashMap0 = new HashMap(arr_nameValuePair.length);
            for(int v1 = arr_nameValuePair.length - 1; v1 >= 0; --v1) {
                NameValuePair nameValuePair0 = arr_nameValuePair[v1];
                hashMap0.put(nameValuePair0.getName().toLowerCase(Locale.ENGLISH), nameValuePair0);
            }
            for(Object object0: hashMap0.entrySet()) {
                NameValuePair nameValuePair1 = (NameValuePair)((Map.Entry)object0).getValue();
                String s2 = nameValuePair1.getName().toLowerCase(Locale.ENGLISH);
                basicClientCookie2HC40.setAttribute(s2, nameValuePair1.getValue());
                CookieAttributeHandler cookieAttributeHandler0 = this.findAttribHandler(s2);
                if(cookieAttributeHandler0 != null) {
                    cookieAttributeHandler0.parse(basicClientCookie2HC40, nameValuePair1.getValue());
                }
            }
            ((ArrayList)list0).add(basicClientCookie2HC40);
        }
        return list0;
    }

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public void formatCookieAsVer(CharArrayBuffer charArrayBuffer0, Cookie cookie0, int v) {
        super.formatCookieAsVer(charArrayBuffer0, cookie0, v);
        if(cookie0 instanceof ClientCookie) {
            String s = ((ClientCookie)cookie0).getAttribute("port");
            if(s != null) {
                charArrayBuffer0.append("; $Port");
                charArrayBuffer0.append("=\"");
                if(s.trim().length() > 0) {
                    int[] arr_v = cookie0.getPorts();
                    if(arr_v != null) {
                        for(int v1 = 0; v1 < arr_v.length; ++v1) {
                            if(v1 > 0) {
                                charArrayBuffer0.append(",");
                            }
                            charArrayBuffer0.append(Integer.toString(arr_v[v1]));
                        }
                    }
                }
                charArrayBuffer0.append("\"");
            }
        }
    }

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public int getVersion() [...] // Inlined contents

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public Header getVersionHeader() {
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(40);
        charArrayBuffer0.append("Cookie2");
        charArrayBuffer0.append(": ");
        charArrayBuffer0.append("$Version=");
        charArrayBuffer0.append("1");
        return new BufferedHeader(charArrayBuffer0);
    }

    @Override  // org.apache.http.impl.cookie.CookieSpecBaseHC4
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        return super.match(cookie0, RFC2965SpecHC4.adjustEffectiveHost(cookieOrigin0));
    }

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        Args.notNull(header0, "Header");
        Args.notNull(cookieOrigin0, "Cookie origin");
        if(!header0.getName().equalsIgnoreCase("Set-Cookie2")) {
            throw new MalformedCookieException("Unrecognized cookie header \'" + header0.toString() + "\'");
        }
        return this.createCookies(header0.getElements(), RFC2965SpecHC4.adjustEffectiveHost(cookieOrigin0));
    }

    @Override  // org.apache.http.impl.cookie.CookieSpecBaseHC4
    public List parse(HeaderElement[] arr_headerElement, CookieOrigin cookieOrigin0) {
        return this.createCookies(arr_headerElement, RFC2965SpecHC4.adjustEffectiveHost(cookieOrigin0));
    }

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public String toString() {
        return "rfc2965";
    }

    @Override  // org.apache.http.impl.cookie.RFC2109SpecHC4
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        super.validate(cookie0, RFC2965SpecHC4.adjustEffectiveHost(cookieOrigin0));
    }
}

