package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

public class NullBackoffStrategy implements ConnectionBackoffStrategy {
    @Override  // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable throwable0) {
        return false;
    }

    @Override  // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse httpResponse0) {
        return false;
    }
}

