package org.apache.http.impl.execchain;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;

public interface ClientExecChain {
    CloseableHttpResponse execute(HttpRoute arg1, HttpRequestWrapper arg2, HttpClientContext arg3, HttpExecutionAware arg4);
}

