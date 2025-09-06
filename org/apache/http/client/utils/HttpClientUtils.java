package org.apache.http.client.utils;

import java.io.Closeable;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtilsHC4;

public class HttpClientUtils {
    public static void closeQuietly(HttpResponse httpResponse0) {
        if(httpResponse0 != null) {
            HttpEntity httpEntity0 = httpResponse0.getEntity();
            if(httpEntity0 != null) {
                try {
                    EntityUtilsHC4.consume(httpEntity0);
                }
                catch(IOException unused_ex) {
                }
            }
        }
    }

    public static void closeQuietly(HttpClient httpClient0) {
        if(httpClient0 != null && httpClient0 instanceof Closeable) {
            try {
                ((Closeable)httpClient0).close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static void closeQuietly(CloseableHttpResponse closeableHttpResponse0) {
        if(closeableHttpResponse0 != null) {
            try {
                EntityUtilsHC4.consume(closeableHttpResponse0.getEntity());
            }
            catch(IOException unused_ex) {
            }
            finally {
                closeableHttpResponse0.close();
            }
        }
    }
}

