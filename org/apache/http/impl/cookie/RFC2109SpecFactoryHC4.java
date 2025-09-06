package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class RFC2109SpecFactoryHC4 implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;
    private final boolean oneHeader;

    public RFC2109SpecFactoryHC4() {
        this(null, false);
    }

    public RFC2109SpecFactoryHC4(String[] arr_s, boolean z) {
        this.datepatterns = arr_s;
        this.oneHeader = z;
    }

    @Override  // org.apache.http.cookie.CookieSpecProvider
    public CookieSpec create(HttpContext httpContext0) {
        return new RFC2109SpecHC4(this.datepatterns, this.oneHeader);
    }

    @Override  // org.apache.http.cookie.CookieSpecFactory
    public CookieSpec newInstance(HttpParams httpParams0) {
        if(httpParams0 != null) {
            Collection collection0 = (Collection)httpParams0.getParameter("http.protocol.cookie-datepatterns");
            return collection0 == null ? new RFC2109SpecHC4(null, httpParams0.getBooleanParameter("http.protocol.single-cookie-header", false)) : new RFC2109SpecHC4(((String[])collection0.toArray(new String[collection0.size()])), httpParams0.getBooleanParameter("http.protocol.single-cookie-header", false));
        }
        return new RFC2109SpecHC4();
    }
}

