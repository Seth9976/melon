package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicCommentHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        setCookie0.setComment(s);
    }
}

