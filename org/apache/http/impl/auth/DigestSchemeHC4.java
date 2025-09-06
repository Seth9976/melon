package org.apache.http.impl.auth;

import U4.x;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.Credentials;
import org.apache.http.message.BasicHeaderValueFormatterHC4;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
public class DigestSchemeHC4 extends RFC2617SchemeHC4 {
    private static final char[] HEXADECIMAL = null;
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    static {
        DigestSchemeHC4.HEXADECIMAL = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public DigestSchemeHC4() {
        this(Consts.ASCII);
    }

    public DigestSchemeHC4(Charset charset0) {
        super(charset0);
        this.complete = false;
    }

    @Deprecated
    public DigestSchemeHC4(ChallengeState challengeState0) {
        super(challengeState0);
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
        if(this.getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        }
        if(this.getParameter("nonce") == null) {
            throw new AuthenticationException("missing nonce in challenge");
        }
        this.getParameters().put("methodname", httpRequest0.getRequestLine().getMethod());
        this.getParameters().put("uri", httpRequest0.getRequestLine().getUri());
        if(this.getParameter("charset") == null) {
            this.getParameters().put("charset", this.getCredentialsCharset(httpRequest0));
        }
        return this.createDigestHeader(credentials0, httpRequest0);
    }

    public static String createCnonce() [...] // 潜在的解密器

    private Header createDigestHeader(Credentials credentials0, HttpRequest httpRequest0) {
        String s15;
        int v1;
        MessageDigest messageDigest0;
        int v;
        String s = this.getParameter("uri");
        String s1 = this.getParameter("realm");
        String s2 = this.getParameter("nonce");
        String s3 = this.getParameter("opaque");
        String s4 = this.getParameter("methodname");
        String s5 = this.getParameter("algorithm");
        if(s5 == null) {
            s5 = "MD5";
        }
        HashSet hashSet0 = new HashSet(8);
        String s6 = "MD5";
        String s7 = this.getParameter("qop");
        if(s7 == null) {
            v = 0;
        }
        else {
            StringTokenizer stringTokenizer0 = new StringTokenizer(s7, ",");
            while(stringTokenizer0.hasMoreTokens()) {
                hashSet0.add(stringTokenizer0.nextToken().trim().toLowerCase(Locale.ENGLISH));
            }
            if(httpRequest0 instanceof HttpEntityEnclosingRequest && hashSet0.contains("auth-int")) {
                v = 1;
            }
            else if(hashSet0.contains("auth")) {
                v = 2;
            }
            else {
                v = -1;
            }
        }
        if(v == -1) {
            throw new AuthenticationException("None of the qop methods is supported: " + s7);
        }
        String s8 = this.getParameter("charset");
        if(s8 == null) {
            s8 = "ISO-8859-1";
        }
        if(!s5.equalsIgnoreCase("MD5-sess")) {
            s6 = s5;
        }
        try {
            messageDigest0 = DigestSchemeHC4.createMessageDigest(s6);
        }
        catch(UnsupportedDigestAlgorithmException unused_ex) {
            throw new AuthenticationException("Unsuppported digest algorithm: " + s6);
        }
        String s9 = credentials0.getUserPrincipal().getName();
        String s10 = credentials0.getPassword();
        if(s2.equals(this.lastNonce)) {
            ++this.nounceCount;
        }
        else {
            this.nounceCount = 1L;
            this.cnonce = null;
            this.lastNonce = s2;
        }
        StringBuilder stringBuilder0 = new StringBuilder(0x100);
        Formatter formatter0 = new Formatter(stringBuilder0, Locale.US);
        formatter0.format("%08x", this.nounceCount);
        formatter0.close();
        String s11 = stringBuilder0.toString();
        if(this.cnonce == null) {
            this.cnonce = "0eeb5b1e70f52c4e";
        }
        this.a1 = null;
        this.a2 = null;
        if(s5.equalsIgnoreCase("MD5-sess")) {
            stringBuilder0.setLength(0);
            stringBuilder0.append(s9);
            stringBuilder0.append(':');
            stringBuilder0.append(s1);
            stringBuilder0.append(':');
            stringBuilder0.append(s10);
            String s12 = DigestSchemeHC4.encode(messageDigest0.digest(EncodingUtils.getBytes(stringBuilder0.toString(), s8)));
            stringBuilder0.setLength(0);
            stringBuilder0.append(s12);
            stringBuilder0.append(':');
            stringBuilder0.append(s2);
            stringBuilder0.append(':');
            stringBuilder0.append(this.cnonce);
        }
        else {
            stringBuilder0.setLength(0);
            stringBuilder0.append(s9);
            stringBuilder0.append(':');
            stringBuilder0.append(s1);
            stringBuilder0.append(':');
            stringBuilder0.append(s10);
        }
        this.a1 = stringBuilder0.toString();
        String s13 = DigestSchemeHC4.encode(messageDigest0.digest(EncodingUtils.getBytes(this.a1, s8)));
        if(v == 2) {
            this.a2 = s4 + ':' + s;
        }
        else if(v == 1) {
            HttpEntity httpEntity0 = httpRequest0 instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest)httpRequest0).getEntity() : null;
            if(httpEntity0 == null || httpEntity0.isRepeatable()) {
                HttpEntityDigester httpEntityDigester0 = new HttpEntityDigester(messageDigest0);
                try {
                    if(httpEntity0 != null) {
                        httpEntity0.writeTo(httpEntityDigester0);
                    }
                    httpEntityDigester0.close();
                }
                catch(IOException iOException0) {
                    throw new AuthenticationException("I/O error reading entity content", iOException0);
                }
                this.a2 = s4 + ':' + s + ':' + DigestSchemeHC4.encode(httpEntityDigester0.getDigest());
                v1 = 1;
            }
            else {
                if(!hashSet0.contains("auth")) {
                    throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                }
                this.a2 = s4 + ':' + s;
                v1 = 2;
            }
            v = v1;
        }
        else {
            this.a2 = s4 + ':' + s;
        }
        String s14 = DigestSchemeHC4.encode(messageDigest0.digest(EncodingUtils.getBytes(this.a2, s8)));
        if(v == 0) {
            stringBuilder0.setLength(0);
            stringBuilder0.append(s13);
            stringBuilder0.append(':');
            stringBuilder0.append(s2);
        }
        else {
            stringBuilder0.setLength(0);
            stringBuilder0.append(s13);
            stringBuilder0.append(':');
            stringBuilder0.append(s2);
            stringBuilder0.append(':');
            stringBuilder0.append(s11);
            stringBuilder0.append(':');
            stringBuilder0.append(this.cnonce);
            stringBuilder0.append(':');
            stringBuilder0.append((v == 1 ? "auth-int" : "auth"));
        }
        stringBuilder0.append(':');
        stringBuilder0.append(s14);
        s15 = stringBuilder0.toString();
        String s16 = DigestSchemeHC4.encode(messageDigest0.digest(EncodingUtils.getAsciiBytes(s15)));
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x80);
        if(this.isProxy()) {
            charArrayBuffer0.append("Proxy-Authorization");
        }
        else {
            charArrayBuffer0.append("Authorization");
        }
        charArrayBuffer0.append(": Digest ");
        ArrayList arrayList0 = new ArrayList(20);
        arrayList0.add(new BasicNameValuePair("username", s9));
        arrayList0.add(new BasicNameValuePair("realm", s1));
        arrayList0.add(new BasicNameValuePair("nonce", s2));
        arrayList0.add(new BasicNameValuePair("uri", s));
        arrayList0.add(new BasicNameValuePair("response", s16));
        if(v != 0) {
            arrayList0.add(new BasicNameValuePair("qop", (v == 1 ? "auth-int" : "auth")));
            arrayList0.add(new BasicNameValuePair("nc", s11));
            arrayList0.add(new BasicNameValuePair("cnonce", this.cnonce));
        }
        arrayList0.add(new BasicNameValuePair("algorithm", s5));
        if(s3 != null) {
            arrayList0.add(new BasicNameValuePair("opaque", s3));
        }
        for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
            BasicNameValuePair basicNameValuePair0 = (BasicNameValuePair)arrayList0.get(v2);
            if(v2 > 0) {
                charArrayBuffer0.append(", ");
            }
            String s17 = basicNameValuePair0.getName();
            BasicHeaderValueFormatterHC4.INSTANCE.formatNameValuePair(charArrayBuffer0, basicNameValuePair0, ((boolean)(("nc".equals(s17) || "qop".equals(s17) || "algorithm".equals(s17) ? 1 : 0) ^ 1)));
        }
        return new BufferedHeader(charArrayBuffer0);
    }

    private static MessageDigest createMessageDigest(String s) {
        try {
            return MessageDigest.getInstance(s);
        }
        catch(Exception unused_ex) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + s);
        }
    }

    public static String encode(byte[] arr_b) {
        char[] arr_c = new char[arr_b.length * 2];
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            arr_c[v * 2] = DigestSchemeHC4.HEXADECIMAL[(v1 & 0xF0) >> 4];
            arr_c[v * 2 + 1] = DigestSchemeHC4.HEXADECIMAL[v1 & 15];
        }
        return new String(arr_c);
    }

    public String getA1() {
        return this.a1;
    }

    public String getA2() {
        return this.a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    // 去混淆评级： 低(20)
    @Override  // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        return "true".equalsIgnoreCase(this.getParameter("stale")) ? false : this.complete;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String s, String s1) {
        this.getParameters().put(s, s1);
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public void processChallenge(Header header0) {
        super.processChallenge(header0);
        this.complete = true;
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DIGEST [complete=");
        stringBuilder0.append(this.complete);
        stringBuilder0.append(", nonce=");
        stringBuilder0.append(this.lastNonce);
        stringBuilder0.append(", nc=");
        return x.h(this.nounceCount, "]", stringBuilder0);
    }
}

