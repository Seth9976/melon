package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;

@Deprecated
public interface PoolEntryRequest {
    void abortRequest();

    BasicPoolEntry getPoolEntry(long arg1, TimeUnit arg2);
}

