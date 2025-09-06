package org.apache.http.client;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScheme;

public interface AuthCache {
    void clear();

    AuthScheme get(HttpHost arg1);

    void put(HttpHost arg1, AuthScheme arg2);

    void remove(HttpHost arg1);
}

