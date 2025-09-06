package tg;

import okhttp3.Request;
import okio.Timeout;

public interface d extends Cloneable {
    void cancel();

    d clone();

    void enqueue(g arg1);

    Q execute();

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}

