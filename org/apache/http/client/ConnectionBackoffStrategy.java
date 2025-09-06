package org.apache.http.client;

import org.apache.http.HttpResponse;

public interface ConnectionBackoffStrategy {
    boolean shouldBackoff(Throwable arg1);

    boolean shouldBackoff(HttpResponse arg1);
}

