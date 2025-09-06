package org.apache.http.impl.client;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

public class DefaultBackoffStrategy implements ConnectionBackoffStrategy {
    // 去混淆评级： 低(20)
    @Override  // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(Throwable throwable0) {
        return throwable0 instanceof SocketTimeoutException || throwable0 instanceof ConnectException;
    }

    @Override  // org.apache.http.client.ConnectionBackoffStrategy
    public boolean shouldBackoff(HttpResponse httpResponse0) {
        return httpResponse0.getStatusLine().getStatusCode() == 503;
    }
}

