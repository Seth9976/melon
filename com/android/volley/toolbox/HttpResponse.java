package com.android.volley.toolbox;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class HttpResponse {
    private final InputStream mContent;
    private final int mContentLength;
    private final List mHeaders;
    private final int mStatusCode;

    public HttpResponse(int v, List list0) {
        this(v, list0, -1, null);
    }

    public HttpResponse(int v, List list0, int v1, InputStream inputStream0) {
        this.mStatusCode = v;
        this.mHeaders = list0;
        this.mContentLength = v1;
        this.mContent = inputStream0;
    }

    public final InputStream getContent() {
        return this.mContent;
    }

    public final int getContentLength() {
        return this.mContentLength;
    }

    public final List getHeaders() {
        return Collections.unmodifiableList(this.mHeaders);
    }

    public final int getStatusCode() {
        return this.mStatusCode;
    }
}

