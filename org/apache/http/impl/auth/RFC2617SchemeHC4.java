package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BasicHeaderValueParserHC4;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class RFC2617SchemeHC4 extends AuthSchemeBaseHC4 {
    private final Charset credentialsCharset;
    private final Map params;

    public RFC2617SchemeHC4() {
        this(Consts.ASCII);
    }

    public RFC2617SchemeHC4(Charset charset0) {
        this.params = new HashMap();
        if(charset0 == null) {
            charset0 = Consts.ASCII;
        }
        this.credentialsCharset = charset0;
    }

    @Deprecated
    public RFC2617SchemeHC4(ChallengeState challengeState0) {
        super(challengeState0);
        this.params = new HashMap();
        this.credentialsCharset = Consts.ASCII;
    }

    public String getCredentialsCharset(HttpRequest httpRequest0) {
        String s = (String)httpRequest0.getParams().getParameter("http.auth.credential-charset");
        return s == null ? this.getCredentialsCharset().name() : s;
    }

    public Charset getCredentialsCharset() {
        return this.credentialsCharset;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getParameter(String s) {
        return s == null ? null : ((String)this.params.get(s.toLowerCase(Locale.ENGLISH)));
    }

    public Map getParameters() {
        return this.params;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getRealm() {
        return this.getParameter("realm");
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public void parseChallenge(CharArrayBuffer charArrayBuffer0, int v, int v1) {
        ParserCursor parserCursor0 = new ParserCursor(v, charArrayBuffer0.length());
        HeaderElement[] arr_headerElement = BasicHeaderValueParserHC4.INSTANCE.parseElements(charArrayBuffer0, parserCursor0);
        if(arr_headerElement.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        this.params.clear();
        for(int v2 = 0; v2 < arr_headerElement.length; ++v2) {
            HeaderElement headerElement0 = arr_headerElement[v2];
            String s = headerElement0.getName().toLowerCase(Locale.ENGLISH);
            String s1 = headerElement0.getValue();
            this.params.put(s, s1);
        }
    }
}

