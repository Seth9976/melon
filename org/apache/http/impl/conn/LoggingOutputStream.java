package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final WireHC4 wire;

    public LoggingOutputStream(OutputStream outputStream0, WireHC4 wireHC40) {
        this.out = outputStream0;
        this.wire = wireHC40;
    }

    @Override
    public void close() {
        try {
            this.out.close();
        }
        catch(IOException iOException0) {
            this.wire.output("[close] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void flush() {
        try {
            this.out.flush();
        }
        catch(IOException iOException0) {
            this.wire.output("[flush] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void write(int v) {
        try {
            this.wire.output(v);
        }
        catch(IOException iOException0) {
            this.wire.output("[write] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void write(byte[] arr_b) {
        try {
            this.wire.output(arr_b);
            this.out.write(arr_b);
        }
        catch(IOException iOException0) {
            this.wire.output("[write] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        try {
            this.wire.output(arr_b, v, v1);
            this.out.write(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            this.wire.output("[write] I/O error: " + iOException0.getMessage());
            throw iOException0;
        }
    }
}

