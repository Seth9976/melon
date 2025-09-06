package org.apache.http.impl.auth;

import android.util.Base64;
import java.nio.charset.Charset;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.Credentials;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
public class BasicSchemeHC4 extends RFC2617SchemeHC4 {
    private boolean complete;

    public BasicSchemeHC4() {
        this(Consts.ASCII);
    }

    public BasicSchemeHC4(Charset charset0) {
        super(charset0);
        this.complete = false;
    }

    @Deprecated
    public BasicSchemeHC4(ChallengeState challengeState0) {
        super(challengeState0);
    }

    @Deprecated
    public static Header authenticate(Credentials credentials0, String s, boolean z) {
        Args.notNull(credentials0, "Credentials");
        Args.notNull(s, "charset");
        byte[] arr_b = Base64.encode(EncodingUtils.getBytes((credentials0.getUserPrincipal().getName() + ":" + (credentials0.getPassword() == null ? "null" : credentials0.getPassword())), s), 2);
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x20);
        if(z) {
            charArrayBuffer0.append("Proxy-Authorization");
        }
        else {
            charArrayBuffer0.append("Authorization");
        }
        charArrayBuffer0.append(": Basic ");
        charArrayBuffer0.append(arr_b, 0, arr_b.length);
        return new BufferedHeader(charArrayBuffer0);
    }

    @Override  // org.apache.http.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0) {
        return this.authenticate(credentials0, httpRequest0, new BasicHttpContextHC4());
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(credentials0, "Credentials");
        Args.notNull(httpRequest0, "HTTP request");
        byte[] arr_b = Base64.decode(EncodingUtils.getBytes((credentials0.getUserPrincipal().getName() + ":" + (credentials0.getPassword() == null ? "null" : credentials0.getPassword())), this.getCredentialsCharset(httpRequest0)), 2);
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x20);
        if(this.isProxy()) {
            charArrayBuffer0.append("Proxy-Authorization");
        }
        else {
            charArrayBuffer0.append("Authorization");
        }
        charArrayBuffer0.append(": Basic ");
        charArrayBuffer0.append(arr_b, 0, arr_b.length);
        return new BufferedHeader(charArrayBuffer0);
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "basic";
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        return this.complete;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public void processChallenge(Header header0) {
        super.processChallenge(header0);
        this.complete = true;
    }
}

