package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class NetscapeDraftSpecFactoryHC4 implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;

    public NetscapeDraftSpecFactoryHC4() {
        this(null);
    }

    public NetscapeDraftSpecFactoryHC4(String[] arr_s) {
        this.datepatterns = arr_s;
    }

    @Override  // org.apache.http.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext0) {
        return new NetscapeDraftSpecHC4(this.datepatterns);
    }

    @Override  // org.apache.http.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams0) {
        if(httpParams0 != null) {
            Collection collection0 = (Collection)httpParams0.getParameter("http.protocol.cookie-datepatterns");
            return collection0 == null ? new NetscapeDraftSpecHC4(null) : new NetscapeDraftSpecHC4(((String[])collection0.toArray(new String[collection0.size()])));
        }
        return new NetscapeDraftSpecHC4();
    }
}

