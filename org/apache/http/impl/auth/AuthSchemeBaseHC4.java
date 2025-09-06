package org.apache.http.impl.auth;

import java.util.Locale;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AuthSchemeBaseHC4 implements ContextAwareAuthScheme {
    private ChallengeState challengeState;

    public AuthSchemeBaseHC4() {
    }

    @Deprecated
    public AuthSchemeBaseHC4(ChallengeState challengeState0) {
        this.challengeState = challengeState0;
    }

    @Override  // org.apache.http.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return this.authenticate(credentials0, httpRequest0);
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public boolean isProxy() {
        return this.challengeState != null && this.challengeState == ChallengeState.PROXY;
    }

    public abstract void parseChallenge(CharArrayBuffer arg1, int arg2, int arg3);

    @Override  // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header0) {
        int v;
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(header0, "Header");
        String s = header0.getName();
        if(s.equalsIgnoreCase("WWW-Authenticate")) {
            this.challengeState = ChallengeState.TARGET;
        }
        else if(s.equalsIgnoreCase("Proxy-Authenticate")) {
            this.challengeState = ChallengeState.PROXY;
        }
        else {
            throw new MalformedChallengeException("Unexpected header name: " + s);
        }
        if(header0 instanceof FormattedHeader) {
            charArrayBuffer0 = ((FormattedHeader)header0).getBuffer();
            v = ((FormattedHeader)header0).getValuePos();
        }
        else {
            String s1 = header0.getValue();
            if(s1 == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            charArrayBuffer0 = new CharArrayBuffer(s1.length());
            charArrayBuffer0.append(s1);
            v = 0;
        }
        while(v < charArrayBuffer0.length() && HTTP.isWhitespace(charArrayBuffer0.charAt(v))) {
            ++v;
        }
        int v1;
        for(v1 = v; v1 < charArrayBuffer0.length() && !HTTP.isWhitespace(charArrayBuffer0.charAt(v1)); ++v1) {
        }
        String s2 = charArrayBuffer0.substring(v, v1);
        if(!s2.equalsIgnoreCase(this.getSchemeName())) {
            throw new MalformedChallengeException("Invalid scheme identifier: " + s2);
        }
        this.parseChallenge(charArrayBuffer0, v1, charArrayBuffer0.length());
    }

    @Override
    public String toString() {
        String s = this.getSchemeName();
        return s == null ? super.toString() : s.toUpperCase(Locale.ENGLISH);
    }
}

