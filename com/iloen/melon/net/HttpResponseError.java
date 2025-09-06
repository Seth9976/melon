package com.iloen.melon.net;

import com.android.volley.VolleyError;

public class HttpResponseError extends VolleyError {
    public HttpResponseError() {
    }

    public HttpResponseError(String s) {
        super(s);
    }

    public HttpResponseError(String s, Throwable throwable0) {
        super(s, throwable0);
    }
}

