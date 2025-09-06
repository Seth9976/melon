package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.util.Args;

@NotThreadSafe
public abstract class CookieSpecBaseHC4 extends AbstractCookieSpecHC4 {
    public static String getDefaultDomain(CookieOrigin cookieOrigin0) {
        return cookieOrigin0.getHost();
    }

    public static String getDefaultPath(CookieOrigin cookieOrigin0) {
        String s = cookieOrigin0.getPath();
        int v = s.lastIndexOf(0x2F);
        if(v >= 0) {
            if(v == 0) {
                v = 1;
            }
            return s.substring(0, v);
        }
        return s;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        for(Object object0: this.getAttribHandlers()) {
            if(!((CookieAttributeHandler)object0).match(cookie0, cookieOrigin0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public List parse(HeaderElement[] arr_headerElement, CookieOrigin cookieOrigin0) {
        List list0 = new ArrayList(arr_headerElement.length);
        for(int v = 0; v < arr_headerElement.length; ++v) {
            HeaderElement headerElement0 = arr_headerElement[v];
            String s = headerElement0.getName();
            String s1 = headerElement0.getValue();
            if(s == null || s.length() == 0) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            BasicClientCookieHC4 basicClientCookieHC40 = new BasicClientCookieHC4(s, s1);
            basicClientCookieHC40.setPath(CookieSpecBaseHC4.getDefaultPath(cookieOrigin0));
            basicClientCookieHC40.setDomain(CookieSpecBaseHC4.getDefaultDomain(cookieOrigin0));
            NameValuePair[] arr_nameValuePair = headerElement0.getParameters();
            for(int v1 = arr_nameValuePair.length - 1; v1 >= 0; --v1) {
                NameValuePair nameValuePair0 = arr_nameValuePair[v1];
                String s2 = nameValuePair0.getName().toLowerCase(Locale.ENGLISH);
                basicClientCookieHC40.setAttribute(s2, nameValuePair0.getValue());
                CookieAttributeHandler cookieAttributeHandler0 = this.findAttribHandler(s2);
                if(cookieAttributeHandler0 != null) {
                    cookieAttributeHandler0.parse(basicClientCookieHC40, nameValuePair0.getValue());
                }
            }
            ((ArrayList)list0).add(basicClientCookieHC40);
        }
        return list0;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        for(Object object0: this.getAttribHandlers()) {
            ((CookieAttributeHandler)object0).validate(cookie0, cookieOrigin0);
        }
    }
}

