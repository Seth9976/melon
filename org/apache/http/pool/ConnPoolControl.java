package org.apache.http.pool;

public interface ConnPoolControl {
    int getDefaultMaxPerRoute();

    int getMaxPerRoute(Object arg1);

    int getMaxTotal();

    PoolStats getStats(Object arg1);

    PoolStats getTotalStats();

    void setDefaultMaxPerRoute(int arg1);

    void setMaxPerRoute(Object arg1, int arg2);

    void setMaxTotal(int arg1);
}

