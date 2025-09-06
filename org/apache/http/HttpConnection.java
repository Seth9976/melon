package org.apache.http;

@Deprecated
public interface HttpConnection {
    void close();

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int arg1);

    void shutdown();
}

