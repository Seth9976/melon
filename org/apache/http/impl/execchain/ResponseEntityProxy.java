package org.apache.http.impl.execchain;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.EofSensorInputStreamHC4;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.entity.HttpEntityWrapperHC4;

@NotThreadSafe
class ResponseEntityProxy extends HttpEntityWrapperHC4 implements EofSensorWatcher {
    private final ConnectionHolder connHolder;

    public ResponseEntityProxy(HttpEntity httpEntity0, ConnectionHolder connectionHolder0) {
        super(httpEntity0);
        this.connHolder = connectionHolder0;
    }

    private void cleanup() {
        ConnectionHolder connectionHolder0 = this.connHolder;
        if(connectionHolder0 != null) {
            connectionHolder0.abortConnection();
        }
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    @Deprecated
    public void consumeContent() {
        this.releaseConnection();
    }

    public static void enchance(HttpResponse httpResponse0, ConnectionHolder connectionHolder0) {
        HttpEntity httpEntity0 = httpResponse0.getEntity();
        if(httpEntity0 != null && httpEntity0.isStreaming() && connectionHolder0 != null) {
            httpResponse0.setEntity(new ResponseEntityProxy(httpEntity0, connectionHolder0));
        }
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream0) {
        try {
            inputStream0.close();
            this.releaseConnection();
            return false;
        }
        finally {
            this.cleanup();
        }
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public InputStream getContent() {
        return new EofSensorInputStreamHC4(this.wrappedEntity.getContent(), this);
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public boolean isRepeatable() {
        return false;
    }

    public void releaseConnection() {
        ConnectionHolder connectionHolder0 = this.connHolder;
        if(connectionHolder0 != null) {
            try {
                if(connectionHolder0.isReusable()) {
                    this.connHolder.releaseConnection();
                }
            }
            finally {
                this.cleanup();
            }
        }
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean streamAbort(InputStream inputStream0) {
        this.cleanup();
        return false;
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean streamClosed(InputStream inputStream0) {
        try {
            boolean z = this.connHolder != null && !this.connHolder.isReleased();
            try {
                inputStream0.close();
                this.releaseConnection();
            }
            catch(SocketException socketException0) {
                if(z) {
                    throw socketException0;
                }
            }
            return false;
        }
        finally {
            this.cleanup();
        }
    }

    @Override
    public String toString() {
        return "ResponseEntityProxy{" + this.wrappedEntity + '}';
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public void writeTo(OutputStream outputStream0) {
        try {
            this.wrappedEntity.writeTo(outputStream0);
            this.releaseConnection();
        }
        finally {
            this.cleanup();
        }
    }
}

