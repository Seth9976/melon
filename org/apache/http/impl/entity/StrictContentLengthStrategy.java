package org.apache.http.impl.entity;

import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;

@Deprecated
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public StrictContentLengthStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage0) {
        throw new RuntimeException("Stub!");
    }
}

