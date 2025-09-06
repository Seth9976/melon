package org.apache.http;

@Deprecated
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String arg1, String arg2);

    HttpRequest newHttpRequest(RequestLine arg1);
}

