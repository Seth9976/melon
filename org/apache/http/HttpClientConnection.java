package org.apache.http;

@Deprecated
public interface HttpClientConnection extends HttpConnection {
    void flush();

    boolean isResponseAvailable(int arg1);

    void receiveResponseEntity(HttpResponse arg1);

    HttpResponse receiveResponseHeader();

    void sendRequestEntity(HttpEntityEnclosingRequest arg1);

    void sendRequestHeader(HttpRequest arg1);
}

