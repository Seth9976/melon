package org.apache.http;

import java.io.Serializable;

@Deprecated
public final class HttpVersion extends ProtocolVersion implements Serializable {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9;
    public static final HttpVersion HTTP_1_0;
    public static final HttpVersion HTTP_1_1;

    public HttpVersion(int v, int v1) {
        super(null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int v, int v1) {
        throw new RuntimeException("Stub!");
    }
}

