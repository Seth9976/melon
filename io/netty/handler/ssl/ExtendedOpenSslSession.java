package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
abstract class ExtendedOpenSslSession extends ExtendedSSLSession implements OpenSslSession {
    final class SSLSessionBindingListenerDecorator implements SSLSessionBindingListener {
        final SSLSessionBindingListener delegate;

        public SSLSessionBindingListenerDecorator(SSLSessionBindingListener sSLSessionBindingListener0) {
            this.delegate = sSLSessionBindingListener0;
        }

        @Override  // javax.net.ssl.SSLSessionBindingListener
        public void valueBound(SSLSessionBindingEvent sSLSessionBindingEvent0) {
            String s = sSLSessionBindingEvent0.getName();
            SSLSessionBindingEvent sSLSessionBindingEvent1 = new SSLSessionBindingEvent(ExtendedOpenSslSession.this, s);
            this.delegate.valueBound(sSLSessionBindingEvent1);
        }

        @Override  // javax.net.ssl.SSLSessionBindingListener
        public void valueUnbound(SSLSessionBindingEvent sSLSessionBindingEvent0) {
            String s = sSLSessionBindingEvent0.getName();
            SSLSessionBindingEvent sSLSessionBindingEvent1 = new SSLSessionBindingEvent(ExtendedOpenSslSession.this, s);
            this.delegate.valueUnbound(sSLSessionBindingEvent1);
        }
    }

    private static final String[] LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS;
    private final OpenSslSession wrapped;

    static {
        ExtendedOpenSslSession.LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS = new String[]{"SHA512withRSA", "SHA512withECDSA", "SHA384withRSA", "SHA384withECDSA", "SHA256withRSA", "SHA256withECDSA", "SHA224withRSA", "SHA224withECDSA", "SHA1withRSA", "SHA1withECDSA", "RSASSA-PSS"};
    }

    public ExtendedOpenSslSession(OpenSslSession openSslSession0) {
        this.wrapped = openSslSession0;
    }

    @Override  // javax.net.ssl.SSLSession
    public final int getApplicationBufferSize() {
        return this.wrapped.getApplicationBufferSize();
    }

    @Override  // javax.net.ssl.SSLSession
    public final String getCipherSuite() {
        return this.wrapped.getCipherSuite();
    }

    @Override  // javax.net.ssl.SSLSession
    public final long getCreationTime() {
        return this.wrapped.getCreationTime();
    }

    @Override  // javax.net.ssl.SSLSession
    public final byte[] getId() {
        return this.wrapped.getId();
    }

    @Override  // javax.net.ssl.SSLSession
    public final long getLastAccessedTime() {
        return this.wrapped.getLastAccessedTime();
    }

    @Override  // javax.net.ssl.SSLSession
    public final Certificate[] getLocalCertificates() {
        return this.wrapped.getLocalCertificates();
    }

    @Override  // javax.net.ssl.SSLSession
    public final Principal getLocalPrincipal() {
        return this.wrapped.getLocalPrincipal();
    }

    @Override  // javax.net.ssl.ExtendedSSLSession
    public final String[] getLocalSupportedSignatureAlgorithms() {
        return (String[])ExtendedOpenSslSession.LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    @Override  // javax.net.ssl.SSLSession
    public final int getPacketBufferSize() {
        return this.wrapped.getPacketBufferSize();
    }

    @Override  // javax.net.ssl.SSLSession
    public final X509Certificate[] getPeerCertificateChain() {
        return this.wrapped.getPeerCertificateChain();
    }

    @Override  // javax.net.ssl.SSLSession
    public final Certificate[] getPeerCertificates() {
        return this.wrapped.getPeerCertificates();
    }

    @Override  // javax.net.ssl.SSLSession
    public final String getPeerHost() {
        return this.wrapped.getPeerHost();
    }

    @Override  // javax.net.ssl.SSLSession
    public final int getPeerPort() {
        return this.wrapped.getPeerPort();
    }

    @Override  // javax.net.ssl.SSLSession
    public final Principal getPeerPrincipal() {
        return this.wrapped.getPeerPrincipal();
    }

    @Override  // javax.net.ssl.ExtendedSSLSession
    public String[] getPeerSupportedSignatureAlgorithms() {
        return EmptyArrays.EMPTY_STRINGS;
    }

    @Override  // javax.net.ssl.SSLSession
    public String getProtocol() {
        return this.wrapped.getProtocol();
    }

    @Override  // javax.net.ssl.ExtendedSSLSession
    public abstract List getRequestedServerNames();

    @Override  // io.netty.handler.ssl.OpenSslSession
    public final OpenSslSessionContext getSessionContext() {
        return this.wrapped.getSessionContext();
    }

    @Override  // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return this.getSessionContext();
    }

    public List getStatusResponses() {
        return Collections.EMPTY_LIST;
    }

    @Override  // javax.net.ssl.SSLSession
    public final Object getValue(String s) {
        SSLSessionBindingListener sSLSessionBindingListener0 = this.wrapped.getValue(s);
        return sSLSessionBindingListener0 instanceof SSLSessionBindingListenerDecorator ? ((SSLSessionBindingListenerDecorator)sSLSessionBindingListener0).delegate : sSLSessionBindingListener0;
    }

    @Override  // javax.net.ssl.SSLSession
    public final String[] getValueNames() {
        return this.wrapped.getValueNames();
    }

    @Override  // io.netty.handler.ssl.OpenSslSession
    public void handshakeFinished(byte[] arr_b, String s, String s1, byte[] arr_b1, byte[][] arr2_b, long v, long v1) {
        this.wrapped.handshakeFinished(arr_b, s, s1, arr_b1, arr2_b, v, v1);
    }

    @Override  // javax.net.ssl.SSLSession
    public final void invalidate() {
        this.wrapped.invalidate();
    }

    @Override  // javax.net.ssl.SSLSession
    public final boolean isValid() {
        return this.wrapped.isValid();
    }

    @Override  // javax.net.ssl.SSLSession
    public final void putValue(String s, Object object0) {
        if(object0 instanceof SSLSessionBindingListener) {
            object0 = new SSLSessionBindingListenerDecorator(this, ((SSLSessionBindingListener)object0));
        }
        this.wrapped.putValue(s, object0);
    }

    @Override  // javax.net.ssl.SSLSession
    public final void removeValue(String s) {
        this.wrapped.removeValue(s);
    }

    @Override  // io.netty.handler.ssl.OpenSslSession
    public OpenSslSessionId sessionId() {
        return this.wrapped.sessionId();
    }

    @Override  // io.netty.handler.ssl.OpenSslSession
    public final void setLocalCertificate(Certificate[] arr_certificate) {
        this.wrapped.setLocalCertificate(arr_certificate);
    }

    @Override  // io.netty.handler.ssl.OpenSslSession
    public void setSessionId(OpenSslSessionId openSslSessionId0) {
        this.wrapped.setSessionId(openSslSessionId0);
    }

    @Override
    public String toString() {
        return "ExtendedOpenSslSession{wrapped=" + this.wrapped + '}';
    }

    @Override  // io.netty.handler.ssl.OpenSslSession
    public final void tryExpandApplicationBufferSize(int v) {
        this.wrapped.tryExpandApplicationBufferSize(v);
    }
}

