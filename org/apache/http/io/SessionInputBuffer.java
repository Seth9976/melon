package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    boolean isDataAvailable(int arg1);

    int read();

    int read(byte[] arg1);

    int read(byte[] arg1, int arg2, int arg3);

    int readLine(CharArrayBuffer arg1);

    String readLine();
}

