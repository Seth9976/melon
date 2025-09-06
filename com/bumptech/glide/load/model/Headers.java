package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

public interface Headers {
    public static final Headers DEFAULT;
    @Deprecated
    public static final Headers NONE;

    static {
        Headers.NONE = new Headers() {
            @Override  // com.bumptech.glide.load.model.Headers
            public Map getHeaders() {
                return Collections.EMPTY_MAP;
            }
        };
        Headers.DEFAULT = new Builder().build();
    }

    Map getHeaders();
}

