package org.apache.http.impl.conn;

import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.protocol.HttpContext;

@NotThreadSafe
public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection implements ManagedHttpClientConnection, HttpContext {
    private final Map attributes;
    private final String id;
    private volatile boolean shutdown;

    public DefaultManagedHttpClientConnection(String s, int v) {
        this(s, v, v, null, null, null, null, null, null, null);
    }

    public DefaultManagedHttpClientConnection(String s, int v, int v1, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        super(v, v1, charsetDecoder0, charsetEncoder0, messageConstraints0, contentLengthStrategy0, contentLengthStrategy1, httpMessageWriterFactory0, httpMessageParserFactory0);
        this.id = s;
        this.attributes = new ConcurrentHashMap();
    }

    @Override  // org.apache.http.impl.DefaultBHttpClientConnection, org.apache.http.conn.ManagedHttpClientConnection
    public void bind(Socket socket0) {
        if(!this.shutdown) {
            super.bind(socket0);
            return;
        }
        socket0.close();
        throw new InterruptedIOException("Connection already shutdown");
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object getAttribute(String s) {
        return this.attributes.get(s);
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public String getId() {
        return this.id;
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        Socket socket0 = super.getSocket();
        return socket0 instanceof SSLSocket ? ((SSLSocket)socket0).getSession() : null;
    }

    @Override  // org.apache.http.conn.ManagedHttpClientConnection, org.apache.http.impl.BHttpConnectionBase
    public Socket getSocket() {
        return super.getSocket();
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String s) {
        return this.attributes.remove(s);
    }

    @Override  // org.apache.http.protocol.HttpContext
    public void setAttribute(String s, Object object0) {
        this.attributes.put(s, object0);
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase, org.apache.http.HttpConnection
    public void shutdown() {
        this.shutdown = true;
        super.shutdown();
    }
}

