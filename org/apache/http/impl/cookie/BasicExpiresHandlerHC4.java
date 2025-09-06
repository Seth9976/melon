package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicExpiresHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    private final String[] datepatterns;

    public BasicExpiresHandlerHC4(String[] arr_s) {
        Args.notNull(arr_s, "Array of date patterns");
        this.datepatterns = arr_s;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        Date date0 = DateUtils.parseDate(s, this.datepatterns);
        if(date0 == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: " + s);
        }
        setCookie0.setExpiryDate(date0);
    }
}

