package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException arg1, int arg2, HttpContext arg3);
}

