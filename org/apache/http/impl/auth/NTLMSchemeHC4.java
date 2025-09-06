package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class NTLMSchemeHC4 extends AuthSchemeBaseHC4 {
    static enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED;

    }

    private String challenge;
    private final NTLMEngine engine;
    private State state;

    public NTLMSchemeHC4() {
        this(new NTLMEngineImpl());
    }

    public NTLMSchemeHC4(NTLMEngine nTLMEngine0) {
        Args.notNull(nTLMEngine0, "NTLM engine");
        this.engine = nTLMEngine0;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0) {
        String s2;
        NTCredentials nTCredentials0;
        try {
            nTCredentials0 = (NTCredentials)credentials0;
            State nTLMSchemeHC4$State0 = this.state;
        }
        catch(ClassCastException unused_ex) {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials0.getClass().getName());
        }
        if(nTLMSchemeHC4$State0 == State.FAILED) {
            throw new AuthenticationException("NTLM authentication failed");
        }
        if(nTLMSchemeHC4$State0 == State.CHALLENGE_RECEIVED) {
            String s = nTCredentials0.getDomain();
            String s1 = nTCredentials0.getWorkstation();
            s2 = this.engine.generateType1Msg(s, s1);
            this.state = State.MSG_TYPE1_GENERATED;
        }
        else if(nTLMSchemeHC4$State0 == State.MSG_TYPE2_RECEVIED) {
            String s3 = nTCredentials0.getUserName();
            String s4 = nTCredentials0.getPassword();
            String s5 = nTCredentials0.getDomain();
            String s6 = nTCredentials0.getWorkstation();
            s2 = this.engine.generateType3Msg(s3, s4, s5, s6, this.challenge);
            this.state = State.MSG_TYPE3_GENERATED;
        }
        else {
            throw new AuthenticationException("Unexpected state: " + this.state);
        }
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x20);
        if(this.isProxy()) {
            charArrayBuffer0.append("Proxy-Authorization");
        }
        else {
            charArrayBuffer0.append("Authorization");
        }
        charArrayBuffer0.append(": NTLM ");
        charArrayBuffer0.append(s2);
        return new BufferedHeader(charArrayBuffer0);
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getParameter(String s) {
        return null;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        return "ntlm";
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        return this.state == State.MSG_TYPE3_GENERATED || this.state == State.FAILED;
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBaseHC4
    public void parseChallenge(CharArrayBuffer charArrayBuffer0, int v, int v1) {
        String s = charArrayBuffer0.substringTrimmed(v, v1);
        this.challenge = s;
        if(s.length() == 0) {
            if(this.state == State.UNINITIATED) {
                this.state = State.CHALLENGE_RECEIVED;
                return;
            }
            this.state = State.FAILED;
            return;
        }
        State nTLMSchemeHC4$State0 = State.MSG_TYPE1_GENERATED;
        if(this.state.compareTo(nTLMSchemeHC4$State0) >= 0) {
            if(this.state == nTLMSchemeHC4$State0) {
                this.state = State.MSG_TYPE2_RECEVIED;
            }
            return;
        }
        this.state = State.FAILED;
        throw new MalformedChallengeException("Out of sequence NTLM response message");
    }
}

