package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import jeb.synthetic.TWR;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.AbstractHttpEntityHC4;
import org.apache.http.entity.BasicHttpEntityHC4;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategyHC4;
import org.apache.http.impl.entity.StrictContentLengthStrategyHC4;
import org.apache.http.impl.io.ChunkedInputStreamHC4;
import org.apache.http.impl.io.ChunkedOutputStreamHC4;
import org.apache.http.impl.io.ContentLengthInputStreamHC4;
import org.apache.http.impl.io.ContentLengthOutputStreamHC4;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStreamHC4;
import org.apache.http.impl.io.IdentityOutputStreamHC4;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.NetUtils;

@NotThreadSafe
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private volatile boolean open;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private volatile Socket socket;

    public BHttpConnectionBase(int v, int v1, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1) {
        Args.positive(v, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl0 = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl1 = new HttpTransportMetricsImpl();
        if(messageConstraints0 == null) {
            messageConstraints0 = MessageConstraints.DEFAULT;
        }
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl0, v, -1, messageConstraints0, charsetDecoder0);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl1, v, v1, charsetEncoder0);
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl0, httpTransportMetricsImpl1);
        if(contentLengthStrategy0 == null) {
            contentLengthStrategy0 = LaxContentLengthStrategyHC4.INSTANCE;
        }
        this.incomingContentStrategy = contentLengthStrategy0;
        if(contentLengthStrategy1 == null) {
            contentLengthStrategy1 = StrictContentLengthStrategyHC4.INSTANCE;
        }
        this.outgoingContentStrategy = contentLengthStrategy1;
    }

    public boolean awaitInput(int v) {
        if(this.inbuffer.hasBufferedData()) {
            return true;
        }
        this.fillInputBuffer(v);
        return this.inbuffer.hasBufferedData();
    }

    public void bind(Socket socket0) {
        Args.notNull(socket0, "Socket");
        this.socket = socket0;
        this.open = true;
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    @Override  // org.apache.http.HttpConnection
    public void close() {
        Socket socket0;
        if(!this.open) {
            return;
        }
        try {
            this.open = false;
            socket0 = this.socket;
            this.inbuffer.clear();
            this.outbuffer.flush();
            try {
                try {
                    socket0.shutdownOutput();
                }
                catch(IOException unused_ex) {
                }
                try {
                    socket0.shutdownInput();
                }
                catch(IOException unused_ex) {
                }
            }
            catch(UnsupportedOperationException unused_ex) {
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(socket0, throwable0);
            throw throwable0;
        }
        socket0.close();
    }

    public InputStream createInputStream(long v, SessionInputBuffer sessionInputBuffer0) {
        if(v == -2L) {
            return new ChunkedInputStreamHC4(sessionInputBuffer0);
        }
        return v == -1L ? new IdentityInputStreamHC4(sessionInputBuffer0) : new ContentLengthInputStreamHC4(sessionInputBuffer0, v);
    }

    public OutputStream createOutputStream(long v, SessionOutputBuffer sessionOutputBuffer0) {
        if(v == -2L) {
            return new ChunkedOutputStreamHC4(0x800, sessionOutputBuffer0);
        }
        return v == -1L ? new IdentityOutputStreamHC4(sessionOutputBuffer0) : new ContentLengthOutputStreamHC4(sessionOutputBuffer0, v);
    }

    public void doFlush() {
        this.outbuffer.flush();
    }

    public void ensureOpen() {
        Asserts.check(this.open, "Connection is not open");
        if(!this.inbuffer.isBound()) {
            InputStream inputStream0 = this.getSocketInputStream(this.socket);
            this.inbuffer.bind(inputStream0);
        }
        if(!this.outbuffer.isBound()) {
            OutputStream outputStream0 = this.getSocketOutputStream(this.socket);
            this.outbuffer.bind(outputStream0);
        }
    }

    private int fillInputBuffer(int v) {
        int v1 = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(v);
            return this.inbuffer.fillBuffer();
        }
        finally {
            this.socket.setSoTimeout(v1);
        }
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        return this.socket == null ? null : this.socket.getLocalAddress();
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        return this.socket == null ? -1 : this.socket.getLocalPort();
    }

    @Override  // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return this.socket == null ? null : this.socket.getInetAddress();
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        return this.socket == null ? -1 : this.socket.getPort();
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public InputStream getSocketInputStream(Socket socket0) {
        return socket0.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket socket0) {
        return socket0.getOutputStream();
    }

    @Override  // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        if(this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            }
            catch(SocketException unused_ex) {
            }
        }
        return -1;
    }

    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isOpen() {
        return this.open;
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isStale() {
        if(!this.isOpen()) {
            return true;
        }
        try {
            return this.fillInputBuffer(1) < 0;
        }
        catch(SocketTimeoutException unused_ex) {
            return false;
        }
        catch(IOException unused_ex) {
            return true;
        }
    }

    public HttpEntity prepareInput(HttpMessage httpMessage0) {
        HttpEntity httpEntity0 = new BasicHttpEntityHC4();
        long v = this.incomingContentStrategy.determineLength(httpMessage0);
        InputStream inputStream0 = this.createInputStream(v, this.inbuffer);
        if(Long.compare(v, -2L) == 0) {
            ((AbstractHttpEntityHC4)httpEntity0).setChunked(true);
            ((BasicHttpEntityHC4)httpEntity0).setContentLength(-1L);
        }
        else if(Long.compare(v, -1L) == 0) {
            ((AbstractHttpEntityHC4)httpEntity0).setChunked(false);
            ((BasicHttpEntityHC4)httpEntity0).setContentLength(-1L);
        }
        else {
            ((AbstractHttpEntityHC4)httpEntity0).setChunked(false);
            ((BasicHttpEntityHC4)httpEntity0).setContentLength(v);
        }
        ((BasicHttpEntityHC4)httpEntity0).setContent(inputStream0);
        Header header0 = httpMessage0.getFirstHeader("Content-Type");
        if(header0 != null) {
            ((AbstractHttpEntityHC4)httpEntity0).setContentType(header0);
        }
        Header header1 = httpMessage0.getFirstHeader("Content-Encoding");
        if(header1 != null) {
            ((AbstractHttpEntityHC4)httpEntity0).setContentEncoding(header1);
        }
        return httpEntity0;
    }

    public OutputStream prepareOutput(HttpMessage httpMessage0) {
        return this.createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage0), this.outbuffer);
    }

    @Override  // org.apache.http.HttpConnection
    public void setSocketTimeout(int v) {
        if(this.socket != null) {
            try {
                this.socket.setSoTimeout(v);
            }
            catch(SocketException unused_ex) {
            }
        }
    }

    @Override  // org.apache.http.HttpConnection
    public void shutdown() {
        this.open = false;
        Socket socket0 = this.socket;
        if(socket0 != null) {
            socket0.close();
        }
    }

    @Override
    public String toString() {
        if(this.socket != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            SocketAddress socketAddress0 = this.socket.getRemoteSocketAddress();
            SocketAddress socketAddress1 = this.socket.getLocalSocketAddress();
            if(socketAddress0 != null && socketAddress1 != null) {
                NetUtils.formatAddress(stringBuilder0, socketAddress1);
                stringBuilder0.append("<->");
                NetUtils.formatAddress(stringBuilder0, socketAddress0);
            }
            return stringBuilder0.toString();
        }
        return "[Not bound]";
    }
}

