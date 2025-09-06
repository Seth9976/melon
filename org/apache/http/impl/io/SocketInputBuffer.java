package org.apache.http.impl.io;

import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer {
    public SocketInputBuffer(Socket socket0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int v) {
        throw new RuntimeException("Stub!");
    }

    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }
}

