package com.iloen.melon.net;

import com.android.volley.VolleyError;

public class ClientDefinedError extends VolleyError {
    public ClientDefinedError() {
    }

    public ClientDefinedError(String s) {
        super(s);
    }
}

