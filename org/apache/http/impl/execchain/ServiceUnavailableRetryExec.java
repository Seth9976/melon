package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.InterruptedIOException;
import jeb.synthetic.TWR;
import org.apache.http.Header;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Immutable
public class ServiceUnavailableRetryExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final ClientExecChain requestExecutor;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public ServiceUnavailableRetryExec(ClientExecChain clientExecChain0, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy0) {
        Args.notNull(clientExecChain0, "HTTP request executor");
        Args.notNull(serviceUnavailableRetryStrategy0, "Retry strategy");
        this.requestExecutor = clientExecChain0;
        this.retryStrategy = serviceUnavailableRetryStrategy0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        CloseableHttpResponse closeableHttpResponse0;
        Header[] arr_header = httpRequestWrapper0.getAllHeaders();
        int v = 1;
        while(true) {
            closeableHttpResponse0 = this.requestExecutor.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
            try {
                if(!this.retryStrategy.retryRequest(closeableHttpResponse0, v, httpClientContext0)) {
                    return closeableHttpResponse0;
                }
                closeableHttpResponse0.close();
                long v1 = this.retryStrategy.getRetryInterval();
                if(v1 > 0L) {
                    try {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Wait for " + v1);
                        }
                        Thread.sleep(v1);
                    }
                    catch(InterruptedException unused_ex) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                httpRequestWrapper0.setHeaders(arr_header);
                ++v;
                continue;
            }
            catch(RuntimeException runtimeException0) {
            }
            break;
        }
        TWR.safeClose$NT(closeableHttpResponse0, runtimeException0);
        throw runtimeException0;
    }
}

