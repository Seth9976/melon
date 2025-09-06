package io.netty.channel;

import java.net.ConnectException;

public class ConnectTimeoutException extends ConnectException {
    private static final long serialVersionUID = 0x2027DE918AF49117L;

    public ConnectTimeoutException() {
    }

    public ConnectTimeoutException(String s) {
        super(s);
    }
}

