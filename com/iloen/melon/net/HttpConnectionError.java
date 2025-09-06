package com.iloen.melon.net;

import com.android.volley.VolleyError;

public class HttpConnectionError extends VolleyError {
    public HttpConnectionError() {
    }

    public HttpConnectionError(String s) {
        super(s);
    }
}

