package org.apache.http;

import java.net.Socket;

public interface HttpConnectionFactory {
    HttpConnection createConnection(Socket arg1);
}

