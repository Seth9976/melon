package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

@Deprecated
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long arg1, TimeUnit arg2);
}

