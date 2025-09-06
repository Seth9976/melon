package org.apache.http.impl.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtilsHC4;

@NotThreadSafe
class CloseableHttpResponseProxy implements InvocationHandler {
    private final HttpResponse original;

    public CloseableHttpResponseProxy(HttpResponse httpResponse0) {
        this.original = httpResponse0;
    }

    public void close() {
        EntityUtilsHC4.consume(this.original.getEntity());
    }

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        if(method0.getName().equals("close")) {
            this.close();
            return null;
        }
        try {
            return method0.invoke(this.original, arr_object);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 != null) {
                throw throwable0;
            }
            throw invocationTargetException0;
        }
    }

    public static CloseableHttpResponse newProxy(HttpResponse httpResponse0) {
        CloseableHttpResponseProxy closeableHttpResponseProxy0 = new CloseableHttpResponseProxy(httpResponse0);
        return (CloseableHttpResponse)Proxy.newProxyInstance(CloseableHttpResponseProxy.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, closeableHttpResponseProxy0);
    }
}

