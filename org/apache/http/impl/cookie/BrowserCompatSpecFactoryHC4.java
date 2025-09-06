package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class BrowserCompatSpecFactoryHC4 implements CookieSpecFactory, CookieSpecProvider {
    public static enum SecurityLevel {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM;

    }

    private final String[] datepatterns;
    private final SecurityLevel securityLevel;

    public BrowserCompatSpecFactoryHC4() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactoryHC4(String[] arr_s) {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactoryHC4(String[] arr_s, SecurityLevel browserCompatSpecFactoryHC4$SecurityLevel0) {
        this.datepatterns = arr_s;
        this.securityLevel = browserCompatSpecFactoryHC4$SecurityLevel0;
    }

    @Override  // org.apache.http.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext0) {
        return new BrowserCompatSpecHC4(this.datepatterns);
    }

    @Override  // org.apache.http.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams0) {
        String[] arr_s = null;
        if(httpParams0 != null) {
            Collection collection0 = (Collection)httpParams0.getParameter("http.protocol.cookie-datepatterns");
            if(collection0 != null) {
                arr_s = (String[])collection0.toArray(new String[collection0.size()]);
            }
            return new BrowserCompatSpecHC4(arr_s, this.securityLevel);
        }
        return new BrowserCompatSpecHC4(null, this.securityLevel);
    }
}

