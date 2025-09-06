package org.apache.http;

@Deprecated
public interface HttpConnectionMetrics {
    Object getMetric(String arg1);

    long getReceivedBytesCount();

    long getRequestCount();

    long getResponseCount();

    long getSentBytesCount();

    void reset();
}

