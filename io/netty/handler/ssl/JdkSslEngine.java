package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

class JdkSslEngine extends SSLEngine implements ApplicationProtocolAccessor {
    private volatile String applicationProtocol;
    private final SSLEngine engine;

    public JdkSslEngine(SSLEngine sSLEngine0) {
        this.engine = sSLEngine0;
    }

    @Override  // javax.net.ssl.SSLEngine
    public void beginHandshake() {
        this.engine.beginHandshake();
    }

    @Override  // javax.net.ssl.SSLEngine
    public void closeInbound() {
        this.engine.closeInbound();
    }

    @Override  // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        this.engine.closeOutbound();
    }

    @Override  // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override  // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override  // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override  // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Can only be called when running on JDK7+")
    public SSLSession getHandshakeSession() {
        return this.engine.getHandshakeSession();
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    @Override  // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override  // javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    @Override  // javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.engine.getSession();
    }

    @Override  // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override  // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public SSLEngine getWrappedEngine() {
        return this.engine;
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    @Override  // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.engine.setEnableSessionCreation(z);
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] arr_s) {
        this.engine.setEnabledCipherSuites(arr_s);
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] arr_s) {
        this.engine.setEnabledProtocols(arr_s);
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.engine.setNeedClientAuth(z);
    }

    public void setNegotiatedApplicationProtocol(String s) {
        this.applicationProtocol = s;
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters0) {
        this.engine.setSSLParameters(sSLParameters0);
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        this.engine.setUseClientMode(z);
    }

    @Override  // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.engine.setWantClientAuth(z);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        return this.engine.unwrap(byteBuffer0, byteBuffer1);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer) {
        return this.engine.unwrap(byteBuffer0, arr_byteBuffer);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer0, ByteBuffer[] arr_byteBuffer, int v, int v1) {
        return this.engine.unwrap(byteBuffer0, arr_byteBuffer, v, v1);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer0, ByteBuffer byteBuffer1) {
        return this.engine.wrap(byteBuffer0, byteBuffer1);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] arr_byteBuffer, int v, int v1, ByteBuffer byteBuffer0) {
        return this.engine.wrap(arr_byteBuffer, v, v1, byteBuffer0);
    }

    @Override  // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] arr_byteBuffer, ByteBuffer byteBuffer0) {
        return this.engine.wrap(arr_byteBuffer, byteBuffer0);
    }
}

