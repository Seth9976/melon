package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;

@Immutable
public class LaxRedirectStrategy extends DefaultRedirectStrategy {
    private static final String[] REDIRECT_METHODS;

    static {
        LaxRedirectStrategy.REDIRECT_METHODS = new String[]{"GET", "POST", "HEAD"};
    }

    @Override  // org.apache.http.impl.client.DefaultRedirectStrategy
    public boolean isRedirectable(String s) {
        String[] arr_s = LaxRedirectStrategy.REDIRECT_METHODS;
        for(int v = 0; v < arr_s.length; ++v) {
            if(arr_s[v].equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}

