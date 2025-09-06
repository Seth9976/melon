package org.apache.http;

@Deprecated
public interface HttpServerConnection extends HttpConnection {
    void flush();

    void receiveRequestEntity(HttpEntityEnclosingRequest arg1);

    HttpRequest receiveRequestHeader();

    void sendResponseEntity(HttpResponse arg1);

    void sendResponseHeader(HttpResponse arg1);
}

