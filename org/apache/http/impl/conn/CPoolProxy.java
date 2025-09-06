package org.apache.http.impl.conn;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.protocol.HttpContext;

@NotThreadSafe
class CPoolProxy implements ManagedHttpClientConnection, HttpContext {
    private volatile CPoolEntry poolEntry;

    public CPoolProxy(CPoolEntry cPoolEntry0) {
        this.poolEntry = cPoolEntry0;
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public void bind(Socket socket0) {
        this.getValidConnection().bind(socket0);
    }

    @Override  // org.apache.http.HttpConnection
    public void close() {
        CPoolEntry cPoolEntry0 = this.poolEntry;
        if(cPoolEntry0 != null) {
            cPoolEntry0.closeConnection();
        }
    }

    public static CPoolEntry detach(HttpClientConnection httpClientConnection0) {
        return CPoolProxy.getProxy(httpClientConnection0).detach();
    }

    public CPoolEntry detach() {
        CPoolEntry cPoolEntry0 = this.poolEntry;
        this.poolEntry = null;
        return cPoolEntry0;
    }

    @Override  // org.apache.http.HttpClientConnection
    public void flush() {
        this.getValidConnection().flush();
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object getAttribute(String s) {
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getValidConnection();
        return managedHttpClientConnection0 instanceof HttpContext ? ((HttpContext)managedHttpClientConnection0).getAttribute(s) : null;
    }

    public ManagedHttpClientConnection getConnection() {
        return this.poolEntry == null ? null : ((ManagedHttpClientConnection)this.poolEntry.getConnection());
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public String getId() {
        return this.getValidConnection().getId();
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        return this.getValidConnection().getLocalAddress();
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        return this.getValidConnection().getLocalPort();
    }

    @Override  // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.getValidConnection().getMetrics();
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection httpClientConnection0) {
        CPoolEntry cPoolEntry0 = CPoolProxy.getProxy(httpClientConnection0).getPoolEntry();
        if(cPoolEntry0 == null) {
            throw new ConnectionShutdownException();
        }
        return cPoolEntry0;
    }

    public CPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    private static CPoolProxy getProxy(HttpClientConnection httpClientConnection0) {
        Class class0 = CPoolProxy.class;
        if(!class0.isInstance(httpClientConnection0)) {
            throw new IllegalStateException("Unexpected connection proxy class: " + httpClientConnection0.getClass());
        }
        return (CPoolProxy)class0.cast(httpClientConnection0);
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return this.getValidConnection().getRemoteAddress();
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        return this.getValidConnection().getRemotePort();
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        return this.getValidConnection().getSSLSession();
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        return this.getValidConnection().getSocket();
    }

    @Override  // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        return this.getValidConnection().getSocketTimeout();
    }

    public ManagedHttpClientConnection getValidConnection() {
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getConnection();
        if(managedHttpClientConnection0 == null) {
            throw new ConnectionShutdownException();
        }
        return managedHttpClientConnection0;
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.poolEntry == null ? false : !this.poolEntry.isClosed();
    }

    @Override  // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int v) {
        return this.getValidConnection().isResponseAvailable(v);
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isStale() {
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getConnection();
        return managedHttpClientConnection0 == null ? true : managedHttpClientConnection0.isStale();
    }

    public static HttpClientConnection newProxy(CPoolEntry cPoolEntry0) {
        return new CPoolProxy(cPoolEntry0);
    }

    @Override  // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse0) {
        this.getValidConnection().receiveResponseEntity(httpResponse0);
    }

    @Override  // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        return this.getValidConnection().receiveResponseHeader();
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String s) {
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getValidConnection();
        return managedHttpClientConnection0 instanceof HttpContext ? ((HttpContext)managedHttpClientConnection0).removeAttribute(s) : null;
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        this.getValidConnection().sendRequestEntity(httpEntityEnclosingRequest0);
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest0) {
        this.getValidConnection().sendRequestHeader(httpRequest0);
    }

    @Override  // org.apache.http.protocol.HttpContext
    public void setAttribute(String s, Object object0) {
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getValidConnection();
        if(managedHttpClientConnection0 instanceof HttpContext) {
            ((HttpContext)managedHttpClientConnection0).setAttribute(s, object0);
        }
    }

    @Override  // org.apache.http.HttpConnection
    public void setSocketTimeout(int v) {
        this.getValidConnection().setSocketTimeout(v);
    }

    @Override  // org.apache.http.HttpConnection
    public void shutdown() {
        CPoolEntry cPoolEntry0 = this.poolEntry;
        if(cPoolEntry0 != null) {
            cPoolEntry0.shutdownConnection();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CPoolProxy{");
        ManagedHttpClientConnection managedHttpClientConnection0 = this.getConnection();
        if(managedHttpClientConnection0 == null) {
            stringBuilder0.append("detached");
        }
        else {
            stringBuilder0.append(managedHttpClientConnection0);
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }
}

