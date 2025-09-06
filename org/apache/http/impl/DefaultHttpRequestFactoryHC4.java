package org.apache.http.impl;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.Args;

@Immutable
public class DefaultHttpRequestFactoryHC4 implements HttpRequestFactory {
    public static final DefaultHttpRequestFactoryHC4 INSTANCE;
    private static final String[] RFC2616_COMMON_METHODS;
    private static final String[] RFC2616_ENTITY_ENC_METHODS;
    private static final String[] RFC2616_SPECIAL_METHODS;

    static {
        DefaultHttpRequestFactoryHC4.INSTANCE = new DefaultHttpRequestFactoryHC4();
        DefaultHttpRequestFactoryHC4.RFC2616_COMMON_METHODS = new String[]{"GET"};
        DefaultHttpRequestFactoryHC4.RFC2616_ENTITY_ENC_METHODS = new String[]{"POST", "PUT"};
        DefaultHttpRequestFactoryHC4.RFC2616_SPECIAL_METHODS = new String[]{"HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"};
    }

    private static boolean isOneOf(String[] arr_s, String s) {
        for(int v = 0; v < arr_s.length; ++v) {
            if(arr_s[v].equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    @Override  // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String s, String s1) {
        if(DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_COMMON_METHODS, s)) {
            return new BasicHttpRequest(s, s1);
        }
        if(DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_ENTITY_ENC_METHODS, s)) {
            return new BasicHttpEntityEnclosingRequest(s, s1);
        }
        if(!DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_SPECIAL_METHODS, s)) {
            throw new MethodNotSupportedException(s + " method not supported");
        }
        return new BasicHttpRequest(s, s1);
    }

    @Override  // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine requestLine0) {
        Args.notNull(requestLine0, "Request line");
        String s = requestLine0.getMethod();
        if(DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_COMMON_METHODS, s)) {
            return new BasicHttpRequest(requestLine0);
        }
        if(DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_ENTITY_ENC_METHODS, s)) {
            return new BasicHttpEntityEnclosingRequest(requestLine0);
        }
        if(!DefaultHttpRequestFactoryHC4.isOneOf(DefaultHttpRequestFactoryHC4.RFC2616_SPECIAL_METHODS, s)) {
            throw new MethodNotSupportedException(s + " method not supported");
        }
        return new BasicHttpRequest(requestLine0);
    }
}

