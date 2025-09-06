package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class EofSensorInputStreamHC4 extends InputStream implements ConnectionReleaseTrigger {
    private final EofSensorWatcher eofWatcher;
    private boolean selfClosed;
    protected InputStream wrappedStream;

    public EofSensorInputStreamHC4(InputStream inputStream0, EofSensorWatcher eofSensorWatcher0) {
        Args.notNull(inputStream0, "Wrapped stream");
        this.wrappedStream = inputStream0;
        this.selfClosed = false;
        this.eofWatcher = eofSensorWatcher0;
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        this.selfClosed = true;
        this.checkAbort();
    }

    @Override
    public int available() {
        if(this.isReadAllowed()) {
            try {
                return this.wrappedStream.available();
            }
            catch(IOException iOException0) {
                this.checkAbort();
                throw iOException0;
            }
        }
        return 0;
    }

    public void checkAbort() {
        InputStream inputStream0 = this.wrappedStream;
        if(inputStream0 != null) {
            try {
                if((this.eofWatcher == null ? true : this.eofWatcher.streamAbort(inputStream0))) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    public void checkClose() {
        InputStream inputStream0 = this.wrappedStream;
        if(inputStream0 != null) {
            try {
                if((this.eofWatcher == null ? true : this.eofWatcher.streamClosed(inputStream0))) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    public void checkEOF(int v) {
        InputStream inputStream0 = this.wrappedStream;
        if(inputStream0 != null && v < 0) {
            try {
                if((this.eofWatcher == null ? true : this.eofWatcher.eofDetected(inputStream0))) {
                    this.wrappedStream.close();
                }
            }
            finally {
                this.wrappedStream = null;
            }
        }
    }

    @Override
    public void close() {
        this.selfClosed = true;
        this.checkClose();
    }

    public InputStream getWrappedStream() {
        return this.wrappedStream;
    }

    public boolean isReadAllowed() {
        if(this.selfClosed) {
            throw new IOException("Attempted read on closed stream.");
        }
        return this.wrappedStream != null;
    }

    public boolean isSelfClosed() {
        return this.selfClosed;
    }

    @Override
    public int read() {
        if(this.isReadAllowed()) {
            try {
                int v = this.wrappedStream.read();
                this.checkEOF(v);
                return v;
            }
            catch(IOException iOException0) {
                this.checkAbort();
                throw iOException0;
            }
        }
        return -1;
    }

    @Override
    public int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        if(this.isReadAllowed()) {
            try {
                int v2 = this.wrappedStream.read(arr_b, v, v1);
                this.checkEOF(v2);
                return v2;
            }
            catch(IOException iOException0) {
                this.checkAbort();
                throw iOException0;
            }
        }
        return -1;
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        this.close();
    }
}

