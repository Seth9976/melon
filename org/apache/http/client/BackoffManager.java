package org.apache.http.client;

import org.apache.http.conn.routing.HttpRoute;

public interface BackoffManager {
    void backOff(HttpRoute arg1);

    void probe(HttpRoute arg1);
}

