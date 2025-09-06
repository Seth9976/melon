package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface SessionOutputBuffer {
    void flush();

    HttpTransportMetrics getMetrics();

    void write(int arg1);

    void write(byte[] arg1);

    void write(byte[] arg1, int arg2, int arg3);

    void writeLine(String arg1);

    void writeLine(CharArrayBuffer arg1);
}

