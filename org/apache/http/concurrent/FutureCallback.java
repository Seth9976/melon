package org.apache.http.concurrent;

public interface FutureCallback {
    void cancelled();

    void completed(Object arg1);

    void failed(Exception arg1);
}

