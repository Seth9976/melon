package org.apache.http.pool;

import java.util.concurrent.Future;
import org.apache.http.concurrent.FutureCallback;

public interface ConnPool {
    Future lease(Object arg1, Object arg2, FutureCallback arg3);

    void release(Object arg1, boolean arg2);
}

