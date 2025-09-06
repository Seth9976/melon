package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class LoggingInputStream extends InputStream {
    private final InputStream in;
    private final WireHC4 wire;

    public LoggingInputStream(InputStream inputStream0, WireHC4 wireHC40) {
        this.in = inputStream0;
        this.wire = wireHC40;
    }

    @Override
    public int available() {
        try {
            return this.in.available();
        }
        catch(IOException iOException0) {
            this.wire.input("[available] I/O error : " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void close() {
        try {
            this.in.close();
        }
        catch(IOException iOException0) {
            this.wire.input("[close] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void mark(int v) {
        super.mark(v);
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        try {
            int v = this.in.read();
            if(v == -1) {
                this.wire.input("end of stream");
                return -1;
            }
            this.wire.input(v);
            return v;
        }
        catch(IOException iOException0) {
        }
        this.wire.input("[read] I/O error: " + iOException0.getMessage());
        throw iOException0;
    }

    @Override
    public int read(byte[] arr_b) {
        try {
            int v = this.in.read(arr_b);
            if(v == -1) {
                this.wire.input("end of stream");
                return -1;
            }
            if(v > 0) {
                this.wire.input(arr_b, 0, v);
            }
            return v;
        }
        catch(IOException iOException0) {
        }
        this.wire.input("[read] I/O error: " + iOException0.getMessage());
        throw iOException0;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        try {
            int v2 = this.in.read(arr_b, v, v1);
            if(v2 == -1) {
                this.wire.input("end of stream");
                return -1;
            }
            if(v2 > 0) {
                this.wire.input(arr_b, v, v2);
            }
            return v2;
        }
        catch(IOException iOException0) {
        }
        this.wire.input("[read] I/O error: " + iOException0.getMessage());
        throw iOException0;
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public long skip(long v) {
        try {
            return super.skip(v);
        }
        catch(IOException iOException0) {
            this.wire.input("[skip] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }
}

